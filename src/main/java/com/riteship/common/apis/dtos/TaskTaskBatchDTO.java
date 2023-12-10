package com.riteship.common.apis.dtos;

public class TaskTaskBatchDTO {
    private Long taskExecutionId;
    private Long jobExecutionId;

    public Long getTaskExecutionId() {
        return this.taskExecutionId;
    }

    public void setTaskExecutionId(Long taskExecutionId) {
        this.taskExecutionId = taskExecutionId;
    }

    public Long getJobExecutionId() {
        return this.jobExecutionId;
    }

    public void setJobExecutionId(Long jobExecutionId) {
        this.jobExecutionId = jobExecutionId;
    }
}
