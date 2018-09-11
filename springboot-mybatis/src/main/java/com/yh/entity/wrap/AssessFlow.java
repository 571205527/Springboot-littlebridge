package com.yh.entity.wrap;

import com.yh.util.BaseUtil;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Created by: LHZ
 * @Description:
 */
public class AssessFlow implements Serializable {

    private Long id;
    private String tchName;
    private String className;
    private String stuName;
    private Integer classNo;
    private Integer grade;
    private String stuNickname;
    private String itemName;
    private String eventLocation;
    private String eventNote;
    private Byte assessType;
    private Integer assessScore;
    private String time;

    public String getStuNickname() {
        return stuNickname;
    }

    public void setStuNickname(String stuNickname) {
        this.stuNickname = stuNickname;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTchName() {
        return tchName;
    }

    public void setTchName(String tchName) {
        this.tchName = tchName;
    }

    public Integer getClassNo() {
        return classNo;
    }

    public void setClassNo(Integer classNo) {
        this.classNo = classNo;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        className = BaseUtil.classToChinese(getGrade(),getClassNo());
        this.className = className;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Byte getAssessType() {
        return assessType;
    }

    public void setAssessType(Byte assessType) {
        this.assessType = assessType;
    }

    public Integer getAssessScore() {
        return assessScore;
    }

    public void setAssessScore(Integer assessScore) {
        this.assessScore = assessScore;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(time);
            this.time = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
