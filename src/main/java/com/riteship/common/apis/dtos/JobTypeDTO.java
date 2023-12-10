package com.riteship.common.apis.dtos;

public class JobTypeDTO {
    private Integer jtId;
    private String jtTitle;
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
