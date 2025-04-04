package Project.SpringProject.Jobs.Listings;

import Project.SpringProject.Authentication.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface JobListingRepository extends JpaRepository<JobListing, Long> {
    List<JobListing> findByEmploymentType(String employmentType);
}

