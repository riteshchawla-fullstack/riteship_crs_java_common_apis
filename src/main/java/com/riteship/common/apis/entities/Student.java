package com.riteship.common.apis.entities;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "student_mobile")
    private String studentMobile;

    @Column(name = "student_email")
    private String studentEmail;

    @Column(name = "student_password")
    private String studentPassword;

    @Column(name = "student_address")
    private String studentAddress;

    @Column(name = "student_city")
    private String studentCity;

    @Column(name = "student_state")
    private String studentState;

    @Column(name = "student_pincode")
    private String studentPincode;

    @Column(name = "student_high_college")
    private String studentHighCollege;

    @Column(name = "student_high_start")
    private String studentHighStart;

    @Column(name = "student_high_pass")
    private String studentHighPass;

    @Column(name = "student_high_subject")
    private String studentHighSubject;

    @Column(name = "student_high_persantage")
    private String studentHighPersantage;

    @Column(name = "student_inter_college")
    private String studentInterCollege;

    @Column(name = "student_inter_start")
    private String studentInterStart;

    @Column(name = "student_inter_pass")
    private String studentInterPass;

    @Column(name = "student_inter_subject")
    private String studentInterSubject;

    @Column(name = "student_inter_persantage")
    private String studentInterPersantage;

    @Column(name = "student_graduate_college")
    private String studentGraduateCollege;

    @Column(name = "student_graduate_start")
    private String studentGraduateStart;

    @Column(name = "student_graduate_pass")
    private String studentGraduatePass;

    @Column(name = "student_graduate_subject")
    private String studentGraduateSubject;

    @Column(name = "student_graduate_persantage")
    private String studentGraduatePersantage;

    @Column(name = "student_pg_college")
    private String studentPgCollege;

    @Column(name = "student_pg_start")
    private String studentPgStart;

    @Column(name = "student_pg_pass")
    private String studentPgPass;

    @Column(name = "student_pg_subject")
    private String studentPgSubject;

    @Column(name = "student_pg_persantage")
    private String studentPgPersantage;

    public Integer getStudentId() {
        return this.studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentMobile() {
        return this.studentMobile;
    }

    public void setStudentMobile(String studentMobile) {
        this.studentMobile = studentMobile;
    }

    public String getStudentEmail() {
        return this.studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentPassword() {
        return this.studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getStudentAddress() {
        return this.studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentCity() {
        return this.studentCity;
    }

    public void setStudentCity(String studentCity) {
        this.studentCity = studentCity;
    }

    public String getStudentState() {
        return this.studentState;
    }

    public void setStudentState(String studentState) {
        this.studentState = studentState;
    }

    public String getStudentPincode() {
        return this.studentPincode;
    }

    public void setStudentPincode(String studentPincode) {
        this.studentPincode = studentPincode;
    }

    public String getStudentHighCollege() {
        return this.studentHighCollege;
    }

    public void setStudentHighCollege(String studentHighCollege) {
        this.studentHighCollege = studentHighCollege;
    }

    public String getStudentHighStart() {
        return this.studentHighStart;
    }

    public void setStudentHighStart(String studentHighStart) {
        this.studentHighStart = studentHighStart;
    }

    public String getStudentHighPass() {
        return this.studentHighPass;
    }

    public void setStudentHighPass(String studentHighPass) {
        this.studentHighPass = studentHighPass;
    }

    public String getStudentHighSubject() {
        return this.studentHighSubject;
    }

    public void setStudentHighSubject(String studentHighSubject) {
        this.studentHighSubject = studentHighSubject;
    }

    public String getStudentHighPersantage() {
        return this.studentHighPersantage;
    }

    public void setStudentHighPersantage(String studentHighPersantage) {
        this.studentHighPersantage = studentHighPersantage;
    }

    public String getStudentInterCollege() {
        return this.studentInterCollege;
    }

    public void setStudentInterCollege(String studentInterCollege) {
        this.studentInterCollege = studentInterCollege;
    }

    public String getStudentInterStart() {
        return this.studentInterStart;
    }

    public void setStudentInterStart(String studentInterStart) {
        this.studentInterStart = studentInterStart;
    }

    public String getStudentInterPass() {
        return this.studentInterPass;
    }

    public void setStudentInterPass(String studentInterPass) {
        this.studentInterPass = studentInterPass;
    }

    public String getStudentInterSubject() {
        return this.studentInterSubject;
    }

    public void setStudentInterSubject(String studentInterSubject) {
        this.studentInterSubject = studentInterSubject;
    }

    public String getStudentInterPersantage() {
        return this.studentInterPersantage;
    }

    public void setStudentInterPersantage(String studentInterPersantage) {
        this.studentInterPersantage = studentInterPersantage;
    }

    public String getStudentGraduateCollege() {
        return this.studentGraduateCollege;
    }

    public void setStudentGraduateCollege(String studentGraduateCollege) {
        this.studentGraduateCollege = studentGraduateCollege;
    }

    public String getStudentGraduateStart() {
        return this.studentGraduateStart;
    }

    public void setStudentGraduateStart(String studentGraduateStart) {
        this.studentGraduateStart = studentGraduateStart;
    }

    public String getStudentGraduatePass() {
        return this.studentGraduatePass;
    }

    public void setStudentGraduatePass(String studentGraduatePass) {
        this.studentGraduatePass = studentGraduatePass;
    }

    public String getStudentGraduateSubject() {
        return this.studentGraduateSubject;
    }

    public void setStudentGraduateSubject(String studentGraduateSubject) {
        this.studentGraduateSubject = studentGraduateSubject;
    }

    public String getStudentGraduatePersantage() {
        return this.studentGraduatePersantage;
    }

    public void setStudentGraduatePersantage(String studentGraduatePersantage) {
        this.studentGraduatePersantage = studentGraduatePersantage;
    }

    public String getStudentPgCollege() {
        return this.studentPgCollege;
    }

    public void setStudentPgCollege(String studentPgCollege) {
        this.studentPgCollege = studentPgCollege;
    }

    public String getStudentPgStart() {
        return this.studentPgStart;
    }

    public void setStudentPgStart(String studentPgStart) {
        this.studentPgStart = studentPgStart;
    }

    public String getStudentPgPass() {
        return this.studentPgPass;
    }

    public void setStudentPgPass(String studentPgPass) {
        this.studentPgPass = studentPgPass;
    }

    public String getStudentPgSubject() {
        return this.studentPgSubject;
    }

    public void setStudentPgSubject(String studentPgSubject) {
        this.studentPgSubject = studentPgSubject;
    }

    public String getStudentPgPersantage() {
        return this.studentPgPersantage;
    }

    public void setStudentPgPersantage(String studentPgPersantage) {
        this.studentPgPersantage = studentPgPersantage;
    }
}
