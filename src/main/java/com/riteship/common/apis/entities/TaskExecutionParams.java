package com.riteship.common.apis.entities;

import javax.persistence.*;

@Entity
@Table(name = "task_execution_params")
public class TaskExecutionParams {
    @Column(name = "TASK_EXECUTION_ID")
    private Long taskExecutionId;

    @Column(name = "TASK_PARAM")
    private String taskParam;
    @Id
    private Integer id;

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

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
