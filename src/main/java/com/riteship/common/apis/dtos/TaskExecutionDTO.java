package com.riteship.common.apis.dtos;

import java.time.LocalDateTime;

public class TaskExecutionDTO {
    private Long taskExecutionId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String taskName;
    private Integer exitCode;
    private String exitMessage;
    private String errorMessage;
    private LocalDateTime lastUpdated;
    private String externalExecutionId;
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
