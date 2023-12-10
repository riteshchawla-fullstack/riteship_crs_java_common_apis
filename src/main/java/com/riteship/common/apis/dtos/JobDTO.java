package com.riteship.common.apis.dtos;

public class JobDTO {
    private Integer jobId;
    private String jobCompanyId;
    private String jobTitle;
    private String jobSkills;
    private String jobPostDate;
    private String jobCity;
    private String jobDescription;
    private String jobJtId;

    public Integer getJobId() {
        return this.jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getJobCompanyId() {
        return this.jobCompanyId;
    }

    public void setJobCompanyId(String jobCompanyId) {
        this.jobCompanyId = jobCompanyId;
    }

    public String getJobTitle() {
        return this.jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobSkills() {
        return this.jobSkills;
    }

    public void setJobSkills(String jobSkills) {
        this.jobSkills = jobSkills;
    }

    public String getJobPostDate() {
        return this.jobPostDate;
    }

    public void setJobPostDate(String jobPostDate) {
        this.jobPostDate = jobPostDate;
    }

    public String getJobCity() {
        return this.jobCity;
    }

    public void setJobCity(String jobCity) {
        this.jobCity = jobCity;
    }

    public String getJobDescription() {
        return this.jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobJtId() {
        return this.jobJtId;
    }

    public void setJobJtId(String jobJtId) {
        this.jobJtId = jobJtId;
    }
}
