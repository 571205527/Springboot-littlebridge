package com.yh.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class AssessLog implements Serializable {
    private Long id;

    private Long schId;

    private Long classId;

    private Long tchId;

    private Long stuId;

    private Long itemId;

    private String tagId;

    private Byte assessSrc;

    private Byte assessType;

    private Byte assessNum;

    private Byte assessScore;

    private Date assessTime;

    private Integer dateWeek;

    private Integer dateMonth;

    private Integer dateDay;

    private Byte status;

    private Date createdDt;

    private Date updatedDt;

    private List<Tag> tags;

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

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

    public Long getTchId() {
        return tchId;
    }

    public void setTchId(Long tchId) {
        this.tchId = tchId;
    }

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId == null ? null : tagId.trim();
    }

    public Byte getAssessSrc() {
        return assessSrc;
    }

    public void setAssessSrc(Byte assessSrc) {
        this.assessSrc = assessSrc;
    }

    public Byte getAssessType() {
        return assessType;
    }

    public void setAssessType(Byte assessType) {
        this.assessType = assessType;
    }

    public Byte getAssessNum() {
        return assessNum;
    }

    public void setAssessNum(Byte assessNum) {
        this.assessNum = assessNum;
    }

    public Byte getAssessScore() {
        return assessScore;
    }

    public void setAssessScore(Byte assessScore) {
        this.assessScore = assessScore;
    }

    public Date getAssessTime() {
        return assessTime;
    }

    public void setAssessTime(Date assessTime) {
        this.assessTime = assessTime;
    }

    public Integer getDateWeek() {
        return dateWeek;
    }

    public void setDateWeek(Integer dateWeek) {
        this.dateWeek = dateWeek;
    }

    public Integer getDateMonth() {
        return dateMonth;
    }

    public void setDateMonth(Integer dateMonth) {
        this.dateMonth = dateMonth;
    }

    public Integer getDateDay() {
        return dateDay;
    }

    public void setDateDay(Integer dateDay) {
        this.dateDay = dateDay;
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
        AssessLog other = (AssessLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSchId() == null ? other.getSchId() == null : this.getSchId().equals(other.getSchId()))
            && (this.getClassId() == null ? other.getClassId() == null : this.getClassId().equals(other.getClassId()))
            && (this.getTchId() == null ? other.getTchId() == null : this.getTchId().equals(other.getTchId()))
            && (this.getStuId() == null ? other.getStuId() == null : this.getStuId().equals(other.getStuId()))
            && (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()))
            && (this.getTagId() == null ? other.getTagId() == null : this.getTagId().equals(other.getTagId()))
            && (this.getAssessSrc() == null ? other.getAssessSrc() == null : this.getAssessSrc().equals(other.getAssessSrc()))
            && (this.getAssessType() == null ? other.getAssessType() == null : this.getAssessType().equals(other.getAssessType()))
            && (this.getAssessNum() == null ? other.getAssessNum() == null : this.getAssessNum().equals(other.getAssessNum()))
            && (this.getAssessScore() == null ? other.getAssessScore() == null : this.getAssessScore().equals(other.getAssessScore()))
            && (this.getAssessTime() == null ? other.getAssessTime() == null : this.getAssessTime().equals(other.getAssessTime()))
            && (this.getDateWeek() == null ? other.getDateWeek() == null : this.getDateWeek().equals(other.getDateWeek()))
            && (this.getDateMonth() == null ? other.getDateMonth() == null : this.getDateMonth().equals(other.getDateMonth()))
            && (this.getDateDay() == null ? other.getDateDay() == null : this.getDateDay().equals(other.getDateDay()))
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
        result = prime * result + ((getTchId() == null) ? 0 : getTchId().hashCode());
        result = prime * result + ((getStuId() == null) ? 0 : getStuId().hashCode());
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        result = prime * result + ((getTagId() == null) ? 0 : getTagId().hashCode());
        result = prime * result + ((getAssessSrc() == null) ? 0 : getAssessSrc().hashCode());
        result = prime * result + ((getAssessType() == null) ? 0 : getAssessType().hashCode());
        result = prime * result + ((getAssessNum() == null) ? 0 : getAssessNum().hashCode());
        result = prime * result + ((getAssessScore() == null) ? 0 : getAssessScore().hashCode());
        result = prime * result + ((getAssessTime() == null) ? 0 : getAssessTime().hashCode());
        result = prime * result + ((getDateWeek() == null) ? 0 : getDateWeek().hashCode());
        result = prime * result + ((getDateMonth() == null) ? 0 : getDateMonth().hashCode());
        result = prime * result + ((getDateDay() == null) ? 0 : getDateDay().hashCode());
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
        sb.append(", tchId=").append(tchId);
        sb.append(", stuId=").append(stuId);
        sb.append(", itemId=").append(itemId);
        sb.append(", tagId=").append(tagId);
        sb.append(", assessSrc=").append(assessSrc);
        sb.append(", assessType=").append(assessType);
        sb.append(", assessNum=").append(assessNum);
        sb.append(", assessScore=").append(assessScore);
        sb.append(", assessTime=").append(assessTime);
        sb.append(", dateWeek=").append(dateWeek);
        sb.append(", dateMonth=").append(dateMonth);
        sb.append(", dateDay=").append(dateDay);
        sb.append(", status=").append(status);
        sb.append(", createdDt=").append(createdDt);
        sb.append(", updatedDt=").append(updatedDt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}