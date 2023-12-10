package com.riteship.common.apis.entities;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "employee_manager_id")
    private String employeeManagerId;

    @Column(name = "employee_role")
    private String employeeRole;

    @Column(name = "employee_sal")
    private String employeeSal;

    @Column(name = "employee_first_name")
    private String employeeFirstName;

    @Column(name = "employee_middle_name")
    private String employeeMiddleName;

    @Column(name = "employee_last_name")
    private String employeeLastName;

    @Column(name = "employee_gender")
    private String employeeGender;

    @Column(name = "employee_address")
    private String employeeAddress;

    @Column(name = "employee_village")
    private String employeeVillage;

    @Column(name = "employee_state")
    private String employeeState;

    @Column(name = "employee_country")
    private String employeeCountry;

    @Column(name = "employee_landline")
    private String employeeLandline;

    @Column(name = "employee_mobile")
    private String employeeMobile;

    @Column(name = "employee_email")
    private String employeeEmail;

    @Column(name = "employee_status")
    private String employeeStatus;

    @Column(name = "employee_deparment")
    private String employeeDeparment;

    @Column(name = "employee_dob")
    private String employeeDob;

    @Column(name = "employee_nationalty")
    private String employeeNationalty;

    public Integer getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeManagerId() {
        return this.employeeManagerId;
    }

    public void setEmployeeManagerId(String employeeManagerId) {
        this.employeeManagerId = employeeManagerId;
    }

    public String getEmployeeRole() {
        return this.employeeRole;
    }

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    public String getEmployeeSal() {
        return this.employeeSal;
    }

    public void setEmployeeSal(String employeeSal) {
        this.employeeSal = employeeSal;
    }

    public String getEmployeeFirstName() {
        return this.employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeMiddleName() {
        return this.employeeMiddleName;
    }

    public void setEmployeeMiddleName(String employeeMiddleName) {
        this.employeeMiddleName = employeeMiddleName;
    }

    public String getEmployeeLastName() {
        return this.employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getEmployeeGender() {
        return this.employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getEmployeeAddress() {
        return this.employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeVillage() {
        return this.employeeVillage;
    }

    public void setEmployeeVillage(String employeeVillage) {
        this.employeeVillage = employeeVillage;
    }

    public String getEmployeeState() {
        return this.employeeState;
    }

    public void setEmployeeState(String employeeState) {
        this.employeeState = employeeState;
    }

    public String getEmployeeCountry() {
        return this.employeeCountry;
    }

    public void setEmployeeCountry(String employeeCountry) {
        this.employeeCountry = employeeCountry;
    }

    public String getEmployeeLandline() {
        return this.employeeLandline;
    }

    public void setEmployeeLandline(String employeeLandline) {
        this.employeeLandline = employeeLandline;
    }

    public String getEmployeeMobile() {
        return this.employeeMobile;
    }

    public void setEmployeeMobile(String employeeMobile) {
        this.employeeMobile = employeeMobile;
    }

    public String getEmployeeEmail() {
        return this.employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeStatus() {
        return this.employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public String getEmployeeDeparment() {
        return this.employeeDeparment;
    }

    public void setEmployeeDeparment(String employeeDeparment) {
        this.employeeDeparment = employeeDeparment;
    }

    public String getEmployeeDob() {
        return this.employeeDob;
    }

    public void setEmployeeDob(String employeeDob) {
        this.employeeDob = employeeDob;
    }

    public String getEmployeeNationalty() {
        return this.employeeNationalty;
    }

    public void setEmployeeNationalty(String employeeNationalty) {
        this.employeeNationalty = employeeNationalty;
    }
}
