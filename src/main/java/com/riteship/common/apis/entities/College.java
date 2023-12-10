package com.riteship.common.apis.entities;

import javax.persistence.*;

@Entity
@Table(name = "college")
public class College {
    @Id
    @Column(name = "college_id")
    private Integer collegeId;

    @Column(name = "college_name")
    private String collegeName;

    @Column(name = "college_city")
    private String collegeCity;

    @Column(name = "college_state")
    private String collegeState;

    @Column(name = "college_country")
    private String collegeCountry;

    @Column(name = "college_mobile")
    private String collegeMobile;

    @Column(name = "college_email")
    private String collegeEmail;

    @Column(name = "college_address")
    private String collegeAddress;

    @Column(name = "college_description")
    private String collegeDescription;

    @Column(name = "college_website")
    private String collegeWebsite;

    @Column(name = "college_image")
    private String collegeImage;

    public Integer getCollegeId() {
        return this.collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return this.collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCollegeCity() {
        return this.collegeCity;
    }

    public void setCollegeCity(String collegeCity) {
        this.collegeCity = collegeCity;
    }

    public String getCollegeState() {
        return this.collegeState;
    }

    public void setCollegeState(String collegeState) {
        this.collegeState = collegeState;
    }

    public String getCollegeCountry() {
        return this.collegeCountry;
    }

    public void setCollegeCountry(String collegeCountry) {
        this.collegeCountry = collegeCountry;
    }

    public String getCollegeMobile() {
        return this.collegeMobile;
    }

    public void setCollegeMobile(String collegeMobile) {
        this.collegeMobile = collegeMobile;
    }

    public String getCollegeEmail() {
        return this.collegeEmail;
    }

    public void setCollegeEmail(String collegeEmail) {
        this.collegeEmail = collegeEmail;
    }

    public String getCollegeAddress() {
        return this.collegeAddress;
    }

    public void setCollegeAddress(String collegeAddress) {
        this.collegeAddress = collegeAddress;
    }

    public String getCollegeDescription() {
        return this.collegeDescription;
    }

    public void setCollegeDescription(String collegeDescription) {
        this.collegeDescription = collegeDescription;
    }

    public String getCollegeWebsite() {
        return this.collegeWebsite;
    }

    public void setCollegeWebsite(String collegeWebsite) {
        this.collegeWebsite = collegeWebsite;
    }

    public String getCollegeImage() {
        return this.collegeImage;
    }

    public void setCollegeImage(String collegeImage) {
        this.collegeImage = collegeImage;
    }
}
