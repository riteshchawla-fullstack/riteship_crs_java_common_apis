package com.riteship.common.apis.entities;

import javax.persistence.*;

@Entity
@Table(name = "job_type")
public class JobType {
    @Id
    @Column(name = "jt_id")
    private Integer jtId;

    @Column(name = "jt_title")
    private String jtTitle;

    @Column(name = "jt_description")
    private String jtDescription;

    public Integer getJtId() {
        return this.jtId;
    }

    public void setJtId(Integer jtId) {
        this.jtId = jtId;
    }

    public String getJtTitle() {
        return this.jtTitle;
    }

    public void setJtTitle(String jtTitle) {
        this.jtTitle = jtTitle;
    }

    public String getJtDescription() {
        return this.jtDescription;
    }

    public void setJtDescription(String jtDescription) {
        this.jtDescription = jtDescription;
    }
}
