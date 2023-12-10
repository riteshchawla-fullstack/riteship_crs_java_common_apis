package com.riteship.common.apis.entities;

import javax.persistence.*;

@Entity
@Table(name = "month")
public class Month {
    @Id
    @Column(name = "month_id")
    private Integer monthId;

    @Column(name = "month_name")
    private String monthName;

    public Integer getMonthId() {
        return this.monthId;
    }

    public void setMonthId(Integer monthId) {
        this.monthId = monthId;
    }

    public String getMonthName() {
        return this.monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }
}
