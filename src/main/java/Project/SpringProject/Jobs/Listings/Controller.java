package Project.SpringProject.Jobs.Listings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {

    @Autowired
    private JobListingRepository jobListingRepository;

    @GetMapping("/api/job-listings")
    public List<JobListing> getJobListings(@RequestParam(required = false) String employmentType) {
        if (employmentType != null) {
            return jobListingRepository.findByEmploymentType(employmentType);
        }
        return jobListingRepository.findAll();
    }

//     Optional: Add endpoint to initialize some data
//    @PostMapping("/api/init-data")
//    public String initData() {
//        // Clear existing data
//        jobListingRepository.deleteAll();
//
//        // Add sample data
//        jobListingRepository.save(new JobListing(1L, "Google", "Software Engineer", "Full Time",
//                "Mountain View, CA", "Work on scalable distributed systems.",
//                "$110,000 - $140,000", "3+ years of experience with Java and Kubernetes",
//                new String[]{"Java", "Kubernetes", "Docker"}));
//
//        // Add all your other sample listings here...
//
//        return "Database initialized with sample data!";
//    }
}