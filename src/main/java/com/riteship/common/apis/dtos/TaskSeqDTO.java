package com.riteship.common.apis.dtos;

public class TaskSeqDTO {
    private Long id;
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
