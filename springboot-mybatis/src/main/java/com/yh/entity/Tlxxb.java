package com.yh.entity;

import java.io.Serializable;
import java.util.Date;

public class Tlxxb implements Serializable {
    private Integer 标识列;

    private String 索取号;

    private String 正题名;

    private String 责任者;

    private String 分册号;

    private String 版本;

    private String 出版地;

    private String 出版者;

    private String 出版日期;

    private String 页卷数;

    private String 标准编号;

    private String 获得方式;

    private Integer 复本数;

    private String 拼音编码;

    private Date 导入时刻;

    private Integer 套录次数;

    private String 作品语种;

    private String 丛编题名;

    private String 丛编题名拼音头;

    private String schoolid;

    private String editflag;

    private String marc;

    private static final long serialVersionUID = 1L;

    public Integer get标识列() {
        return 标识列;
    }

    public void set标识列(Integer 标识列) {
        this.标识列 = 标识列;
    }

    public String get索取号() {
        return 索取号;
    }

    public void set索取号(String 索取号) {
        this.索取号 = 索取号 == null ? null : 索取号.trim();
    }

    public String get正题名() {
        return 正题名;
    }

    public void set正题名(String 正题名) {
        this.正题名 = 正题名 == null ? null : 正题名.trim();
    }

    public String get责任者() {
        return 责任者;
    }

    public void set责任者(String 责任者) {
        this.责任者 = 责任者 == null ? null : 责任者.trim();
    }

    public String get分册号() {
        return 分册号;
    }

    public void set分册号(String 分册号) {
        this.分册号 = 分册号 == null ? null : 分册号.trim();
    }

    public String get版本() {
        return 版本;
    }

    public void set版本(String 版本) {
        this.版本 = 版本 == null ? null : 版本.trim();
    }

    public String get出版地() {
        return 出版地;
    }

    public void set出版地(String 出版地) {
        this.出版地 = 出版地 == null ? null : 出版地.trim();
    }

    public String get出版者() {
        return 出版者;
    }

    public void set出版者(String 出版者) {
        this.出版者 = 出版者 == null ? null : 出版者.trim();
    }

    public String get出版日期() {
        return 出版日期;
    }

    public void set出版日期(String 出版日期) {
        this.出版日期 = 出版日期 == null ? null : 出版日期.trim();
    }

    public String get页卷数() {
        return 页卷数;
    }

    public void set页卷数(String 页卷数) {
        this.页卷数 = 页卷数 == null ? null : 页卷数.trim();
    }

    public String get标准编号() {
        return 标准编号;
    }

    public void set标准编号(String 标准编号) {
        this.标准编号 = 标准编号 == null ? null : 标准编号.trim();
    }

    public String get获得方式() {
        return 获得方式;
    }

    public void set获得方式(String 获得方式) {
        this.获得方式 = 获得方式 == null ? null : 获得方式.trim();
    }

    public Integer get复本数() {
        return 复本数;
    }

    public void set复本数(Integer 复本数) {
        this.复本数 = 复本数;
    }

    public String get拼音编码() {
        return 拼音编码;
    }

    public void set拼音编码(String 拼音编码) {
        this.拼音编码 = 拼音编码 == null ? null : 拼音编码.trim();
    }

    public Date get导入时刻() {
        return 导入时刻;
    }

    public void set导入时刻(Date 导入时刻) {
        this.导入时刻 = 导入时刻;
    }

    public Integer get套录次数() {
        return 套录次数;
    }

    public void set套录次数(Integer 套录次数) {
        this.套录次数 = 套录次数;
    }

    public String get作品语种() {
        return 作品语种;
    }

    public void set作品语种(String 作品语种) {
        this.作品语种 = 作品语种 == null ? null : 作品语种.trim();
    }

    public String get丛编题名() {
        return 丛编题名;
    }

    public void set丛编题名(String 丛编题名) {
        this.丛编题名 = 丛编题名 == null ? null : 丛编题名.trim();
    }

    public String get丛编题名拼音头() {
        return 丛编题名拼音头;
    }

    public void set丛编题名拼音头(String 丛编题名拼音头) {
        this.丛编题名拼音头 = 丛编题名拼音头 == null ? null : 丛编题名拼音头.trim();
    }

    public String getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(String schoolid) {
        this.schoolid = schoolid == null ? null : schoolid.trim();
    }

    public String getEditflag() {
        return editflag;
    }

    public void setEditflag(String editflag) {
        this.editflag = editflag == null ? null : editflag.trim();
    }

    public String getMarc() {
        return marc;
    }

    public void setMarc(String marc) {
        this.marc = marc == null ? null : marc.trim();
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
        Tlxxb other = (Tlxxb) that;
        return (this.get标识列() == null ? other.get标识列() == null : this.get标识列().equals(other.get标识列()))
            && (this.get索取号() == null ? other.get索取号() == null : this.get索取号().equals(other.get索取号()))
            && (this.get正题名() == null ? other.get正题名() == null : this.get正题名().equals(other.get正题名()))
            && (this.get责任者() == null ? other.get责任者() == null : this.get责任者().equals(other.get责任者()))
            && (this.get分册号() == null ? other.get分册号() == null : this.get分册号().equals(other.get分册号()))
            && (this.get版本() == null ? other.get版本() == null : this.get版本().equals(other.get版本()))
            && (this.get出版地() == null ? other.get出版地() == null : this.get出版地().equals(other.get出版地()))
            && (this.get出版者() == null ? other.get出版者() == null : this.get出版者().equals(other.get出版者()))
            && (this.get出版日期() == null ? other.get出版日期() == null : this.get出版日期().equals(other.get出版日期()))
            && (this.get页卷数() == null ? other.get页卷数() == null : this.get页卷数().equals(other.get页卷数()))
            && (this.get标准编号() == null ? other.get标准编号() == null : this.get标准编号().equals(other.get标准编号()))
            && (this.get获得方式() == null ? other.get获得方式() == null : this.get获得方式().equals(other.get获得方式()))
            && (this.get复本数() == null ? other.get复本数() == null : this.get复本数().equals(other.get复本数()))
            && (this.get拼音编码() == null ? other.get拼音编码() == null : this.get拼音编码().equals(other.get拼音编码()))
            && (this.get导入时刻() == null ? other.get导入时刻() == null : this.get导入时刻().equals(other.get导入时刻()))
            && (this.get套录次数() == null ? other.get套录次数() == null : this.get套录次数().equals(other.get套录次数()))
            && (this.get作品语种() == null ? other.get作品语种() == null : this.get作品语种().equals(other.get作品语种()))
            && (this.get丛编题名() == null ? other.get丛编题名() == null : this.get丛编题名().equals(other.get丛编题名()))
            && (this.get丛编题名拼音头() == null ? other.get丛编题名拼音头() == null : this.get丛编题名拼音头().equals(other.get丛编题名拼音头()))
            && (this.getSchoolid() == null ? other.getSchoolid() == null : this.getSchoolid().equals(other.getSchoolid()))
            && (this.getEditflag() == null ? other.getEditflag() == null : this.getEditflag().equals(other.getEditflag()))
            && (this.getMarc() == null ? other.getMarc() == null : this.getMarc().equals(other.getMarc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((get标识列() == null) ? 0 : get标识列().hashCode());
        result = prime * result + ((get索取号() == null) ? 0 : get索取号().hashCode());
        result = prime * result + ((get正题名() == null) ? 0 : get正题名().hashCode());
        result = prime * result + ((get责任者() == null) ? 0 : get责任者().hashCode());
        result = prime * result + ((get分册号() == null) ? 0 : get分册号().hashCode());
        result = prime * result + ((get版本() == null) ? 0 : get版本().hashCode());
        result = prime * result + ((get出版地() == null) ? 0 : get出版地().hashCode());
        result = prime * result + ((get出版者() == null) ? 0 : get出版者().hashCode());
        result = prime * result + ((get出版日期() == null) ? 0 : get出版日期().hashCode());
        result = prime * result + ((get页卷数() == null) ? 0 : get页卷数().hashCode());
        result = prime * result + ((get标准编号() == null) ? 0 : get标准编号().hashCode());
        result = prime * result + ((get获得方式() == null) ? 0 : get获得方式().hashCode());
        result = prime * result + ((get复本数() == null) ? 0 : get复本数().hashCode());
        result = prime * result + ((get拼音编码() == null) ? 0 : get拼音编码().hashCode());
        result = prime * result + ((get导入时刻() == null) ? 0 : get导入时刻().hashCode());
        result = prime * result + ((get套录次数() == null) ? 0 : get套录次数().hashCode());
        result = prime * result + ((get作品语种() == null) ? 0 : get作品语种().hashCode());
        result = prime * result + ((get丛编题名() == null) ? 0 : get丛编题名().hashCode());
        result = prime * result + ((get丛编题名拼音头() == null) ? 0 : get丛编题名拼音头().hashCode());
        result = prime * result + ((getSchoolid() == null) ? 0 : getSchoolid().hashCode());
        result = prime * result + ((getEditflag() == null) ? 0 : getEditflag().hashCode());
        result = prime * result + ((getMarc() == null) ? 0 : getMarc().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", 标识列=").append(标识列);
        sb.append(", 索取号=").append(索取号);
        sb.append(", 正题名=").append(正题名);
        sb.append(", 责任者=").append(责任者);
        sb.append(", 分册号=").append(分册号);
        sb.append(", 版本=").append(版本);
        sb.append(", 出版地=").append(出版地);
        sb.append(", 出版者=").append(出版者);
        sb.append(", 出版日期=").append(出版日期);
        sb.append(", 页卷数=").append(页卷数);
        sb.append(", 标准编号=").append(标准编号);
        sb.append(", 获得方式=").append(获得方式);
        sb.append(", 复本数=").append(复本数);
        sb.append(", 拼音编码=").append(拼音编码);
        sb.append(", 导入时刻=").append(导入时刻);
        sb.append(", 套录次数=").append(套录次数);
        sb.append(", 作品语种=").append(作品语种);
        sb.append(", 丛编题名=").append(丛编题名);
        sb.append(", 丛编题名拼音头=").append(丛编题名拼音头);
        sb.append(", schoolid=").append(schoolid);
        sb.append(", editflag=").append(editflag);
        sb.append(", marc=").append(marc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}