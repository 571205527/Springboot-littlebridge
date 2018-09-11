package com.yh.entity;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    private Long id;

    private Long schId;

    private Long classId;

    private String stuNo;

    private String stuName;

    private String stuNickname;

    private Byte gender;

    private Short stuEnrlYear;

    private String stuIcon;

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

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo == null ? null : stuNo.trim();
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public String getStuNickname() {
        return stuNickname;
    }

    public void setStuNickname(String stuNickname) {
        this.stuNickname = stuNickname == null ? null : stuNickname.trim();
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public Short getStuEnrlYear() {
        return stuEnrlYear;
    }

    public void setStuEnrlYear(Short stuEnrlYear) {
        this.stuEnrlYear = stuEnrlYear;
    }

    public String getStuIcon() {
        return stuIcon;
    }

    public void setStuIcon(String stuIcon) {
        this.stuIcon = stuIcon == null ? null : stuIcon.trim();
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
        Student other = (Student) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSchId() == null ? other.getSchId() == null : this.getSchId().equals(other.getSchId()))
            && (this.getClassId() == null ? other.getClassId() == null : this.getClassId().equals(other.getClassId()))
            && (this.getStuNo() == null ? other.getStuNo() == null : this.getStuNo().equals(other.getStuNo()))
            && (this.getStuName() == null ? other.getStuName() == null : this.getStuName().equals(other.getStuName()))
            && (this.getStuNickname() == null ? other.getStuNickname() == null : this.getStuNickname().equals(other.getStuNickname()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getStuEnrlYear() == null ? other.getStuEnrlYear() == null : this.getStuEnrlYear().equals(other.getStuEnrlYear()))
            && (this.getStuIcon() == null ? other.getStuIcon() == null : this.getStuIcon().equals(other.getStuIcon()))
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
        result = prime * result + ((getClassId() == null) ? 0 : getClassId().hashCode());
        result = prime * result + ((getStuNo() == null) ? 0 : getStuNo().hashCode());
        result = prime * result + ((getStuName() == null) ? 0 : getStuName().hashCode());
        result = prime * result + ((getStuNickname() == null) ? 0 : getStuNickname().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getStuEnrlYear() == null) ? 0 : getStuEnrlYear().hashCode());
        result = prime * result + ((getStuIcon() == null) ? 0 : getStuIcon().hashCode());
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
        sb.append(", classId=").append(classId);
        sb.append(", stuNo=").append(stuNo);
        sb.append(", stuName=").append(stuName);
        sb.append(", stuNickname=").append(stuNickname);
        sb.append(", gender=").append(gender);
        sb.append(", stuEnrlYear=").append(stuEnrlYear);
        sb.append(", stuIcon=").append(stuIcon);
        sb.append(", status=").append(status);
        sb.append(", createdDt=").append(createdDt);
        sb.append(", updatedDt=").append(updatedDt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}