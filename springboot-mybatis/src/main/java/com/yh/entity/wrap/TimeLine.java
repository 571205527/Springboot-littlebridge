package com.yh.entity.wrap;

import com.yh.util.BaseUtil;
import java.io.Serializable;

/**
 * @Created by: LHZ
 * @Description:
 */
public class TimeLine  implements Serializable {

    private Long Id;
    private String eventLocation;
    private String eventNote;
    private String eventDate;
    private String eventTime;
    private String className;
    private String stuName;
    private String stuNickname;
    private Integer grade;
    private Integer classNo;
    private String tchName;
    private String tagName;

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getClassNo() {
        return classNo;
    }

    public void setClassNo(Integer classNo) {
        this.classNo = classNo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        className = BaseUtil.classToChinese(grade,classNo);
        this.className = className;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuNickname() {
        return stuNickname;
    }

    public void setStuNickname(String stuNickname) {
        this.stuNickname = stuNickname;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getTchName() {
        return tchName;
    }

    public void setTchName(String tchName) {
        this.tchName = tchName;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    private static final long serialVersionUID = 1L;
}
