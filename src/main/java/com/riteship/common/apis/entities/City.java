package com.riteship.common.apis.entities;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Id
    @Column(name = "city_id")
    private Integer cityId;

    @Column(name = "city_name")
    private String cityName;

    public Integer getCityId() {
        return this.cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
