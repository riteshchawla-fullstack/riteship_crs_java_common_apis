package com.riteship.common.apis.entities;

import javax.persistence.*;

@Entity
@Table(name = "salutions")
public class Salutions {
    @Id
    @Column(name = "sl_id")
    private Integer slId;

    @Column(name = "sl_name")
    private String slName;

    public Integer getSlId() {
        return this.slId;
    }

    public void setSlId(Integer slId) {
        this.slId = slId;
    }

    public String getSlName() {
        return this.slName;
    }

    public void setSlName(String slName) {
        this.slName = slName;
    }
}
