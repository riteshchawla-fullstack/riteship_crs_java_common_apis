package com.riteship.common.apis.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task_execution")
public class TaskExecution {
    @Id
    @Column(name = "TASK_EXECUTION_ID")
    private Long taskExecutionId;

    @Column(name = "START_TIME")
    private LocalDateTime startTime;

    @Column(name = "END_TIME")
    private LocalDateTime endTime;

    @Column(name = "TASK_NAME")
    private String taskName;

    @Column(name = "EXIT_CODE")
    private Integer exitCode;

    @Column(name = "EXIT_MESSAGE")
    private String exitMessage;

    @Column(name = "ERROR_MESSAGE")
    private String errorMessage;

    @Column(name = "LAST_UPDATED")
    private LocalDateTime lastUpdated;

    @Column(name = "EXTERNAL_EXECUTION_ID")
    private String externalExecutionId;

    @Column(name = "PARENT_EXECUTION_ID")
    private Long parentExecutionId;

    public Long getTaskExecutionId() {
        return this.taskExecutionId;
    }

    public void setTaskExecutionId(Long taskExecutionId) {
        this.taskExecutionId = taskExecutionId;
    }

    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return this.endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getExitCode() {
        return this.exitCode;
    }

    public void setExitCode(Integer exitCode) {
        this.exitCode = exitCode;
    }

    public String getExitMessage() {
        return this.exitMessage;
    }

    public void setExitMessage(String exitMessage) {
        this.exitMessage = exitMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public LocalDateTime getLastUpdated() {
        return this.lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getExternalExecutionId() {
        return this.externalExecutionId;
    }

    public void setExternalExecutionId(String externalExecutionId) {
        this.externalExecutionId = externalExecutionId;
    }

    public Long getParentExecutionId() {
        return this.parentExecutionId;
    }

    public void setParentExecutionId(Long parentExecutionId) {
        this.parentExecutionId = parentExecutionId;
    }
}
