package com.riteship.common.apis.entities;

import javax.persistence.*;

@Entity
@Table(name = "login")
public class Login {
    @Id
    @Column(name = "login_id")
    private Integer loginId;

    @Column(name = "login_emp_id")
    private Integer loginEmpId;

    @Column(name = "login_user")
    private String loginUser;

    @Column(name = "login_password")
    private String loginPassword;

    @Column(name = "login_level")
    private Integer loginLevel;

    @Column(name = "login_email")
    private String loginEmail;

    public Integer getLoginId() {
        return this.loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public Integer getLoginEmpId() {
        return this.loginEmpId;
    }

    public void setLoginEmpId(Integer loginEmpId) {
        this.loginEmpId = loginEmpId;
    }

    public String getLoginUser() {
        return this.loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public String getLoginPassword() {
        return this.loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public Integer getLoginLevel() {
        return this.loginLevel;
    }

    public void setLoginLevel(Integer loginLevel) {
        this.loginLevel = loginLevel;
    }

    public String getLoginEmail() {
        return this.loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
    }
}
