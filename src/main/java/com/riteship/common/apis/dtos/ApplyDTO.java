package com.riteship.common.apis.dtos;

public class ApplyDTO {
    private Integer applyId;
    private String applyJobId;
    private String applyUserId;
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
