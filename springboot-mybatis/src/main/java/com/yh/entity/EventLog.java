package com.yh.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class EventLog implements Serializable {
    private Long id;

    private Long schId;

    private Long classId;

    private Long tchId;

    private Long stuId;

    private Long assessId;

    private Long eventCategory;

    private String eventLocation;

    private String eventNote;

    private Date eventTime;

    private Integer dateDay;

    private Byte status;

    //private Byte pushLog;

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

    public Long getAssessId() {
        return assessId;
    }

    public void setAssessId(Long assessId) {
        this.assessId = assessId;
    }

    public Long getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(Long eventCategory) {
        this.eventCategory = eventCategory;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation == null ? null : eventLocation.trim();
    }

    public String getEventNote() {
        return eventNote;
    }

    public void setEventNote(String eventNote) {
        this.eventNote = eventNote == null ? null : eventNote.trim();
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
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
        EventLog other = (EventLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSchId() == null ? other.getSchId() == null : this.getSchId().equals(other.getSchId()))
            && (this.getClassId() == null ? other.getClassId() == null : this.getClassId().equals(other.getClassId()))
            && (this.getTchId() == null ? other.getTchId() == null : this.getTchId().equals(other.getTchId()))
            && (this.getStuId() == null ? other.getStuId() == null : this.getStuId().equals(other.getStuId()))
            && (this.getAssessId() == null ? other.getAssessId() == null : this.getAssessId().equals(other.getAssessId()))
            && (this.getEventCategory() == null ? other.getEventCategory() == null : this.getEventCategory().equals(other.getEventCategory()))
            && (this.getEventLocation() == null ? other.getEventLocation() == null : this.getEventLocation().equals(other.getEventLocation()))
            && (this.getEventNote() == null ? other.getEventNote() == null : this.getEventNote().equals(other.getEventNote()))
            && (this.getEventTime() == null ? other.getEventTime() == null : this.getEventTime().equals(other.getEventTime()))
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
        result = prime * result + ((getAssessId() == null) ? 0 : getAssessId().hashCode());
        result = prime * result + ((getEventCategory() == null) ? 0 : getEventCategory().hashCode());
        result = prime * result + ((getEventLocation() == null) ? 0 : getEventLocation().hashCode());
        result = prime * result + ((getEventNote() == null) ? 0 : getEventNote().hashCode());
        result = prime * result + ((getEventTime() == null) ? 0 : getEventTime().hashCode());
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
        sb.append(", assessId=").append(assessId);
        sb.append(", eventCategory=").append(eventCategory);
        sb.append(", eventLocation=").append(eventLocation);
        sb.append(", eventNote=").append(eventNote);
        sb.append(", eventTime=").append(eventTime);
        sb.append(", dateDay=").append(dateDay);
        sb.append(", status=").append(status);
        sb.append(", createdDt=").append(createdDt);
        sb.append(", updatedDt=").append(updatedDt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}