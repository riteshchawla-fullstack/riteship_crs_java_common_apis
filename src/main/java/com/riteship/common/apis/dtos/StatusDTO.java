package com.riteship.common.apis.dtos;

public class StatusDTO {
    private Integer statusId;
    private String statusName;

    public Integer getStatusId() {
        return this.statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return this.statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
