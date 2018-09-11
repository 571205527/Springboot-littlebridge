package com.yh.entity.wrap;

import java.io.Serializable;
import java.util.List;

/**
 * Created by HR on 2018/5/17.
 */
public class EventAssessment implements Serializable {

    public Long getSchId() {
        return schId;
    }

    public void setSchId(Long schId) {
        this.schId = schId;
    }

    /*public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }*/

    public List<Long> getClassId() {
        return classId;
    }

    public void setClassId(List<Long> classId) {
        this.classId = classId;
    }

    public Long getTchId() {
        return tchId;
    }

    public void setTchId(Long tchId) {
        this.tchId = tchId;
    }

    public List<Long> getStuIds() {
        return stuIds;
    }

    public void setStuIds(List<Long> stuIds) {
        this.stuIds = stuIds;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
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

    public String getAssessTime() {
        return assessTime;
    }

    public void setAssessTime(String assessTime) {
        this.assessTime = assessTime;
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
        this.eventLocation = eventLocation;
    }

    public String getEventNote() {
        return eventNote;
    }

    public void setEventNote(String eventNote) {
        this.eventNote = eventNote;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public List<String> getTagId() {
        return tagId;
    }

    public void setTagId(List<String> tagId) {
        this.tagId = tagId;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    private Long schId;
    private List<Long> classId;
    private Long tchId;
    private List<Long> stuIds;
    private Long itemId;
    private List<String> tagId;
    private Byte assessSrc;
    private Byte assessType;
    private Byte assessNum;
    private Byte assessScore;
    private String assessTime;

    private String picPath;
    private Long eventCategory;
    private String eventLocation;
    private String eventNote;
    private String eventTime;
}
