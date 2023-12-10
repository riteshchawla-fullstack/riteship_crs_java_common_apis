package com.riteship.common.apis.entities;

import javax.persistence.*;

@Entity
@Table(name = "state")
public class State {
    @Id
    @Column(name = "state_id")
    private Integer stateId;

    @Column(name = "state_name")
    private String stateName;

    public Integer getStateId() {
        return this.stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return this.stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}
