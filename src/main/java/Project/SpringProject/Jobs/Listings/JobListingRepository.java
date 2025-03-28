package Project.SpringProject.Jobs.Listings;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JobListingRepository extends JpaRepository<JobListing, Long> {
    List<JobListing> findByEmploymentType(String employmentType);
}