package Project.SpringProject.Jobs.Management.controller;

import Project.SpringProject.Jobs.Listings.JobListing;
import Project.SpringProject.Jobs.Listings.JobListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {

    @Autowired
    private JobListingRepository jobListingRepository;

    @PostMapping
    public ResponseEntity<JobListing> createJobListing(@RequestBody JobListing jobListing) {
        // This will save to the SAME table as api/job_listings
        JobListing savedJob = jobListingRepository.save(jobListing);
        return ResponseEntity.ok(savedJob);
    }

    private List<JobListing> jobs = new ArrayList<>();
    private Long nextId = 1L;

    @GetMapping
    public List<JobListing> getAllJobs() {
        return jobs;
    }
}