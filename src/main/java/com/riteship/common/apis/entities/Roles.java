package com.riteship.common.apis.entities;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "role_title")
    private String roleTitle;

    public Integer getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleTitle() {
        return this.roleTitle;
    }

    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }
}
