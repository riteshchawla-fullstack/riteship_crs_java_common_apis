package com.riteship.common.apis.entities;

import javax.persistence.*;

@Entity
@Table(name = "task_task_batch")
public class TaskTaskBatch {
    @Column(name = "TASK_EXECUTION_ID")
    private Long taskExecutionId;

    @Column(name = "JOB_EXECUTION_ID")
    private Long jobExecutionId;
    @Id
    private Integer id;

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

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
