package com.riteship.common.apis.entities;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "country_id")
    private Integer countryId;

    @Column(name = "country_name")
    private String countryName;

    public Integer getCountryId() {
        return this.countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
