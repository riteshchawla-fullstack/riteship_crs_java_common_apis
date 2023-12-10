package com.riteship.common.apis.entities;

import javax.persistence.*;

@Entity
@Table(name = "task_seq")
public class TaskSeq {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "UNIQUE_KEY")
    private Integer uniqueKey;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUniqueKey() {
        return this.uniqueKey;
    }

    public void setUniqueKey(Integer uniqueKey) {
        this.uniqueKey = uniqueKey;
    }
}
