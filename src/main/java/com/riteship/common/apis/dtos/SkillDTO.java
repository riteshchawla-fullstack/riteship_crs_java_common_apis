package com.riteship.common.apis.dtos;

public class SkillDTO {
    private Integer skillId;
    private Integer skillEmpId;
    private String skillName;
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
