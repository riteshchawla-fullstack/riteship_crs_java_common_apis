package com.riteship.common.apis.entities;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @Column(name = "dept_id")
    private Integer deptId;

    @Column(name = "dept_name")
    private String deptName;

    public Integer getDeptId() {
        return this.deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return this.deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
