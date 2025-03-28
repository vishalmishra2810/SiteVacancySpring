package Project.SpringProject.Jobs.Management.model;

import jakarta.validation.constraints.NotBlank;

public class JobListing {
    private Long id;

    @NotBlank(message = "Company name is required")
    private String companyName;

    @NotBlank(message = "Job title is required")
    private String jobTitle;

    @NotBlank(message = "Employment type is required")
    private String employmentType;

    @NotBlank(message = "Location is required")
    private String location;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Salary is required")
    private String salary;

    @NotBlank(message = "Requirements are required")
    private String requirements;

//    private String skills;

//    @NotNull(message = "Skills array is required")
//    private String[] skillsArray;

    // Constructors
    public JobListing() {}

    public JobListing(Long id, String companyName, String jobTitle, String employmentType,
                      String location, String description, String salary,
                      String requirements, String[] skillsArray) {
        this.id = id;
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.employmentType = employmentType;
        this.location = location;
        this.description = description;
        this.salary = salary;
        this.requirements = requirements;
//        this.skillsArray = skillsArray;
//          this.skills = String.join(",", skillsArray);
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

//    public String getSkills() {
//        return skills;
//    }

//    public void setSkills(String skills) {
//        this.skills = skills;
////        this.skillsArray = skills.split(",");
//    }

//    public String[] getSkillsArray() {
//        if (this.skills == null || this.skills.isEmpty()) {
//            return new String[0]; // Return empty array instead of null
//        }
//        return skills.split(",");
//    }

//    public void setSkillsArray(String[] skillsArray) {
//        this.skillsArray = skillsArray;
//        this.skills = (skillsArray != null) ? String.join(",", skillsArray) : "";
//    }

    // toString() for debugging
    @Override
    public String toString() {
        return "JobListing{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", employmentType='" + employmentType + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", salary='" + salary + '\'' +
                ", requirements='" + requirements + '\'' +
//                ", skills='" + skills + '\'' +
//                ", skillsArray=" + Arrays.toString(skillsArray) +
                '}';
    }
}