package com.riteship.common.apis.entities;

import javax.persistence.*;

@Entity
@Table(name = "skill")
public class Skill {
    @Id
    @Column(name = "skill_id")
    private Integer skillId;

    @Column(name = "skill_emp_id")
    private Integer skillEmpId;

    @Column(name = "skill_name")
    private String skillName;

    @Column(name = "skill_grade")
    private String skillGrade;

    public Integer getSkillId() {
        return this.skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public Integer getSkillEmpId() {
        return this.skillEmpId;
    }

    public void setSkillEmpId(Integer skillEmpId) {
        this.skillEmpId = skillEmpId;
    }

    public String getSkillName() {
        return this.skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillGrade() {
        return this.skillGrade;
    }

    public void setSkillGrade(String skillGrade) {
        this.skillGrade = skillGrade;
    }
}
