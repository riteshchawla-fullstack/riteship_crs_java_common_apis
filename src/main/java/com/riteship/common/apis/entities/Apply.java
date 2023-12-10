package com.riteship.common.apis.entities;

import javax.persistence.*;

@Entity
@Table(name = "apply")
public class Apply {
    @Id
    @Column(name = "apply_id")
    private Integer applyId;

    @Column(name = "apply_job_id")
    private String applyJobId;

    @Column(name = "apply_user_id")
    private String applyUserId;

    @Column(name = "apply_date")
    private String applyDate;

    public Integer getApplyId() {
        return this.applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public String getApplyJobId() {
        return this.applyJobId;
    }

    public void setApplyJobId(String applyJobId) {
        this.applyJobId = applyJobId;
    }

    public String getApplyUserId() {
        return this.applyUserId;
    }

    public void setApplyUserId(String applyUserId) {
        this.applyUserId = applyUserId;
    }

    public String getApplyDate() {
        return this.applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }
}
