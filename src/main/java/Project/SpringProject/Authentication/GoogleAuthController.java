package Project.SpringProject.Authentication;

import Project.SpringProject.Jobs.Listings.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/auth/google")
public class GoogleAuthController {

    @Value("${spring.security.oauth2.client.registration.google.client-id")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.google.client-secret")
    private String clientSecret;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/callback")
    public ResponseEntity<?> handleGoogleCallBack(@RequestParam String code){
        try{
            //1. Exchange Auth Code with Token
            String tokenEndpoint = "https://oauth2.googleapis.com/token";
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("code", code);
            params.add("client_id", clientId);
            params.add("client_secret", clientSecret);
            params.add("redirect_uri", "http://localhost:3000");
            params.add("grant_type", "authorization_code");

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

            ResponseEntity<Map> tokenResponse = restTemplate.postForEntity(tokenEndpoint, request, Map.class);
            String idToken = (String) tokenResponse.getBody().get("id_token");
            String userInfoURL = "https://oauth2.googleapis.com/tokeninfo?id_token=" + idToken;

            ResponseEntity<Map> userInfoResponse = restTemplate.getForEntity(userInfoURL, Map.class);

            if(userInfoResponse.getStatusCode() == HttpStatus.OK){
                Map<String, Object> userInfo = userInfoResponse.getBody();
                String email = (String) userInfo.get("email");
                UserDetails userDetails = userDetailsService.loadUserByUsername(email);
                if((userDetails) == null){
                    User user = new User();
                    user.setEmail(email);
                    user.setUserName(email);
                    user.setPassword((passwordEncoder.encode(UUID.randomUUID().toString())));
                    user.setRoles(Arrays.asList("USER"));
                    userRepository.save(user);
                    userDetails = userDetailsService.loadUserByUsername(email);
                }

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails. null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);

                return ResponseEntity.status(HttpStatus.OK).build();

            }

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        }catch(Exception e){
            log.error("exception")
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
