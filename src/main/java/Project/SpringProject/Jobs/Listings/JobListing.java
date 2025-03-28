package Project.SpringProject.Jobs.Listings;

import jakarta.persistence.*;
//import java.util.Arrays;

@Entity
@Table(name = "job_listings")
public class JobListing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String jobTitle;
    private String employmentType;
    private String location;

    @Column(length = 1000)
    private String description;

    private String salary;

    @Column(length = 1000)
    private String requirements;

//    @Column(length = 1000)
//    private String skills;

//    @Transient
//    private String[] skillsArray;

    // Default constructor
    public JobListing() {}

    // Constructor
    public JobListing(Long id, String companyName, String jobTitle, String employmentType,
                      String location, String description, String salary,
                      String requirements) {
        this.id = id;
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.employmentType = employmentType;
        this.location = location;
        this.description = description;
        this.salary = salary;
        this.requirements = requirements;
//        this.skills = String.join(",", skills);
    }

    // Getters and Setters
    public Long getId() { return id; }
    public String getJobTitle() { return jobTitle; }
    public String getEmploymentType() { return employmentType; }
    public String getLocation() { return location; }
    public String getDescription() { return description; }
    public String getSalary() { return salary; }
    public String getRequirements() { return requirements; }
//    public String getSkills() { return skills; }  // Add this if you want the raw string
    public String getCompanyName() { return companyName; }
//    public void setSkillsArray(String[] skillsArray) {
//        this.skillsArray = skillsArray;
//        this.skills = String.join(",", skillsArray); // Convert to string for DB
//    }


    public void setId(Long id) { this.id = id; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }
    public void setEmploymentType(String employmentType) { this.employmentType = employmentType; }
    public void setLocation(String location) { this.location = location; }
    public void setDescription(String description) { this.description = description; }
    public void setSalary(String salary) { this.salary = salary; }
    public void setRequirements(String requirements) { this.requirements = requirements; }
//    public void setSkills(String skills) { this.skills = skills; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
//    public String[] getSkillsArray() {
//        return skills.split(",");
//    }
}