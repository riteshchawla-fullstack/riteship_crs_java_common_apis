package com.riteship.common.apis.dtos;

import java.time.LocalDateTime;

public class TaskLockDTO {
    private Integer lockKey;
    private String region;
    private Integer clientId;
    private LocalDateTime createdDate;

    public Integer getLockKey() {
        return this.lockKey;
    }

    public void setLockKey(Integer lockKey) {
        this.lockKey = lockKey;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getClientId() {
        return this.clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
