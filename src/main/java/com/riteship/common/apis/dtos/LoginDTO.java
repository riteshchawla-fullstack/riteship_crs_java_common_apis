package com.riteship.common.apis.dtos;

public class LoginDTO {
    private Integer loginId;
    private Integer loginEmpId;
    private String loginUser;
    private String loginPassword;
    private Integer loginLevel;
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
