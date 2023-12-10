package com.riteship.common.apis.entities;

import javax.persistence.*;

@Entity
@Table(name = "type")
public class Type {
    @Id
    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "type_name")
    private String typeName;

    public Integer getTypeId() {
        return this.typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
