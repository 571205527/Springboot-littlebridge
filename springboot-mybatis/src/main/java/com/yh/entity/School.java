package com.yh.entity;

import java.io.Serializable;
import java.util.Date;

public class School implements Serializable {
    private Long id;

    private String schNo;

    private String schName;

    private String schIcon;

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

    public String getSchNo() {
        return schNo;
    }

    public void setSchNo(String schNo) {
        this.schNo = schNo == null ? null : schNo.trim();
    }

    public String getSchName() {
        return schName;
    }

    public void setSchName(String schName) {
        this.schName = schName == null ? null : schName.trim();
    }

    public String getSchIcon() {
        return schIcon;
    }

    public void setSchIcon(String schIcon) {
        this.schIcon = schIcon == null ? null : schIcon.trim();
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
        School other = (School) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSchNo() == null ? other.getSchNo() == null : this.getSchNo().equals(other.getSchNo()))
            && (this.getSchName() == null ? other.getSchName() == null : this.getSchName().equals(other.getSchName()))
            && (this.getSchIcon() == null ? other.getSchIcon() == null : this.getSchIcon().equals(other.getSchIcon()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreatedDt() == null ? other.getCreatedDt() == null : this.getCreatedDt().equals(other.getCreatedDt()))
            && (this.getUpdatedDt() == null ? other.getUpdatedDt() == null : this.getUpdatedDt().equals(other.getUpdatedDt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSchNo() == null) ? 0 : getSchNo().hashCode());
        result = prime * result + ((getSchName() == null) ? 0 : getSchName().hashCode());
        result = prime * result + ((getSchIcon() == null) ? 0 : getSchIcon().hashCode());
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
        sb.append(", schNo=").append(schNo);
        sb.append(", schName=").append(schName);
        sb.append(", schIcon=").append(schIcon);
        sb.append(", status=").append(status);
        sb.append(", createdDt=").append(createdDt);
        sb.append(", updatedDt=").append(updatedDt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}