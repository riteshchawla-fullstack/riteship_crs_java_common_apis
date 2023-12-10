package com.riteship.common.apis.entities;

import javax.persistence.*;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_city")
    private String companyCity;

    @Column(name = "company_state")
    private String companyState;

    @Column(name = "company_country")
    private String companyCountry;

    @Column(name = "company_mobile")
    private String companyMobile;

    @Column(name = "company_email")
    private String companyEmail;

    @Column(name = "company_address")
    private String companyAddress;

    @Column(name = "company_description")
    private String companyDescription;

    @Column(name = "company_website")
    private String companyWebsite;

    @Column(name = "company_image")
    private String companyImage;

    @Column(name = "company_password")
    private String companyPassword;

    public Integer getCompanyId() {
        return this.companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyCity() {
        return this.companyCity;
    }

    public void setCompanyCity(String companyCity) {
        this.companyCity = companyCity;
    }

    public String getCompanyState() {
        return this.companyState;
    }

    public void setCompanyState(String companyState) {
        this.companyState = companyState;
    }

    public String getCompanyCountry() {
        return this.companyCountry;
    }

    public void setCompanyCountry(String companyCountry) {
        this.companyCountry = companyCountry;
    }

    public String getCompanyMobile() {
        return this.companyMobile;
    }

    public void setCompanyMobile(String companyMobile) {
        this.companyMobile = companyMobile;
    }

    public String getCompanyEmail() {
        return this.companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyAddress() {
        return this.companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyDescription() {
        return this.companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public String getCompanyWebsite() {
        return this.companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public String getCompanyImage() {
        return this.companyImage;
    }

    public void setCompanyImage(String companyImage) {
        this.companyImage = companyImage;
    }

    public String getCompanyPassword() {
        return this.companyPassword;
    }

    public void setCompanyPassword(String companyPassword) {
        this.companyPassword = companyPassword;
    }
}
