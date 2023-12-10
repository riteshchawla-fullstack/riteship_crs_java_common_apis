package com.riteship.common.apis.dtos;

public class TaskExecutionParamsDTO {
    private Long taskExecutionId;
    private String taskParam;

    public Long getTaskExecutionId() {
        return this.taskExecutionId;
    }

    public void setTaskExecutionId(Long taskExecutionId) {
        this.taskExecutionId = taskExecutionId;
    }

    public String getTaskParam() {
        return this.taskParam;
    }

    public void setTaskParam(String taskParam) {
        this.taskParam = taskParam;
    }
}
