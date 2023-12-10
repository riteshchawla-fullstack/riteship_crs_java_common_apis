package com.riteship.common.apis.entities;

import javax.persistence.*;

@Entity
@Table(name = "job")
public class Job {
    @Id
    @Column(name = "job_id")
    private Integer jobId;

    @Column(name = "job_company_id")
    private String jobCompanyId;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "job_skills")
    private String jobSkills;

    @Column(name = "job_post_date")
    private String jobPostDate;

    @Column(name = "job_city")
    private String jobCity;

    @Column(name = "job_description")
    private String jobDescription;

    @Column(name = "job_jt_id")
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
