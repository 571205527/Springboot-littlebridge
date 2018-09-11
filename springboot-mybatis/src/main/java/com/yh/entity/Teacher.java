package com.yh.entity;

import java.io.Serializable;
import java.util.Date;

public class Teacher implements Serializable {
    private Long id;

    private Long schId;

    private String tchNo;

    private String tchName;

    private Byte gender;

    private String tchIcon;

    private Byte status;

    private Date createdDt;

    private Date updatedDt;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSchId() {
        return schId;
    }

    public void setSchId(Long schId) {
        this.schId = schId;
    }

    public String getTchNo() {
        return tchNo;
    }

    public void setTchNo(String tchNo) {
        this.tchNo = tchNo == null ? null : tchNo.trim();
    }

    public String getTchName() {
        return tchName;
    }

    public void setTchName(String tchName) {
        this.tchName = tchName == null ? null : tchName.trim();
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public String getTchIcon() {
        return tchIcon;
    }

    public void setTchIcon(String tchIcon) {
        this.tchIcon = tchIcon == null ? null : tchIcon.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    public Date getUpdatedDt() {
        return updatedDt;
    }

    public void setUpdatedDt(Date updatedDt) {
        this.updatedDt = updatedDt;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Teacher other = (Teacher) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSchId() == null ? other.getSchId() == null : this.getSchId().equals(other.getSchId()))
            && (this.getTchNo() == null ? other.getTchNo() == null : this.getTchNo().equals(other.getTchNo()))
            && (this.getTchName() == null ? other.getTchName() == null : this.getTchName().equals(other.getTchName()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getTchIcon() == null ? other.getTchIcon() == null : this.getTchIcon().equals(other.getTchIcon()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreatedDt() == null ? other.getCreatedDt() == null : this.getCreatedDt().equals(other.getCreatedDt()))
            && (this.getUpdatedDt() == null ? other.getUpdatedDt() == null : this.getUpdatedDt().equals(other.getUpdatedDt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSchId() == null) ? 0 : getSchId().hashCode());
        result = prime * result + ((getTchNo() == null) ? 0 : getTchNo().hashCode());
        result = prime * result + ((getTchName() == null) ? 0 : getTchName().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getTchIcon() == null) ? 0 : getTchIcon().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreatedDt() == null) ? 0 : getCreatedDt().hashCode());
        result = prime * result + ((getUpdatedDt() == null) ? 0 : getUpdatedDt().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", schId=").append(schId);
        sb.append(", tchNo=").append(tchNo);
        sb.append(", tchName=").append(tchName);
        sb.append(", gender=").append(gender);
        sb.append(", tchIcon=").append(tchIcon);
        sb.append(", status=").append(status);
        sb.append(", createdDt=").append(createdDt);
        sb.append(", updatedDt=").append(updatedDt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}