package com.riteship.common.apis.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task_lock")
public class TaskLock {
    @Id
    @Column(name = "LOCK_KEY")
    private Integer lockKey;

    @Id
    @Column(name = "REGION")
    private String region;

    @Column(name = "CLIENT_ID")
    private String clientId;

    @Column(name = "CREATED_DATE")
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

    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
