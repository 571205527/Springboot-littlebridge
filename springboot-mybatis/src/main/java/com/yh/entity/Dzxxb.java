package com.yh.entity;

import java.io.Serializable;
import java.util.Date;

public class Dzxxb implements Serializable {
    private Integer 标识列;

    private String 读者证号;

    private String 读者姓名;

    private String 读者性别;

    private String 读者单位;

    private String 读者类别;

    private String 读者身份;

    private String 读者口令;

    private String 出生日期;

    private String 办证日期;

    private String 终止日期;

    private String 邮政编码;

    private String 地址;

    private String 电话;

    private String email;

    private Integer 允借册数;

    private Integer 借出册数;

    private String 状态位;

    private Boolean 预约资格;

    private Boolean 馆际互借;

    private String 停借日期;

    private Integer 停借天数;

    private String 图书馆代码;

    private String 图书馆名称;

    private Date 更新时间;

    private String 身份证号;

    private String 职业行业;

    private String 文化程度;

    private String 业务职称;

    private String 备注;

    private String 停借原因;

    private String 停借操作员;

    private String 卡号;

    private Boolean 预借资格;

    private String 读者签名;

    private String 读者流水号;

    private String schoolid;

    private String editflag;

    private static final long serialVersionUID = 1L;

    public Integer get标识列() {
        return 标识列;
    }

    public void set标识列(Integer 标识列) {
        this.标识列 = 标识列;
    }

    public String get读者证号() {
        return 读者证号;
    }

    public void set读者证号(String 读者证号) {
        this.读者证号 = 读者证号 == null ? null : 读者证号.trim();
    }

    public String get读者姓名() {
        return 读者姓名;
    }

    public void set读者姓名(String 读者姓名) {
        this.读者姓名 = 读者姓名 == null ? null : 读者姓名.trim();
    }

    public String get读者性别() {
        return 读者性别;
    }

    public void set读者性别(String 读者性别) {
        this.读者性别 = 读者性别 == null ? null : 读者性别.trim();
    }

    public String get读者单位() {
        return 读者单位;
    }

    public void set读者单位(String 读者单位) {
        this.读者单位 = 读者单位 == null ? null : 读者单位.trim();
    }

    public String get读者类别() {
        return 读者类别;
    }

    public void set读者类别(String 读者类别) {
        this.读者类别 = 读者类别 == null ? null : 读者类别.trim();
    }

    public String get读者身份() {
        return 读者身份;
    }

    public void set读者身份(String 读者身份) {
        this.读者身份 = 读者身份 == null ? null : 读者身份.trim();
    }

    public String get读者口令() {
        return 读者口令;
    }

    public void set读者口令(String 读者口令) {
        this.读者口令 = 读者口令 == null ? null : 读者口令.trim();
    }

    public String get出生日期() {
        return 出生日期;
    }

    public void set出生日期(String 出生日期) {
        this.出生日期 = 出生日期 == null ? null : 出生日期.trim();
    }

    public String get办证日期() {
        return 办证日期;
    }

    public void set办证日期(String 办证日期) {
        this.办证日期 = 办证日期 == null ? null : 办证日期.trim();
    }

    public String get终止日期() {
        return 终止日期;
    }

    public void set终止日期(String 终止日期) {
        this.终止日期 = 终止日期 == null ? null : 终止日期.trim();
    }

    public String get邮政编码() {
        return 邮政编码;
    }

    public void set邮政编码(String 邮政编码) {
        this.邮政编码 = 邮政编码 == null ? null : 邮政编码.trim();
    }

    public String get地址() {
        return 地址;
    }

    public void set地址(String 地址) {
        this.地址 = 地址 == null ? null : 地址.trim();
    }

    public String get电话() {
        return 电话;
    }

    public void set电话(String 电话) {
        this.电话 = 电话 == null ? null : 电话.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer get允借册数() {
        return 允借册数;
    }

    public void set允借册数(Integer 允借册数) {
        this.允借册数 = 允借册数;
    }

    public Integer get借出册数() {
        return 借出册数;
    }

    public void set借出册数(Integer 借出册数) {
        this.借出册数 = 借出册数;
    }

    public String get状态位() {
        return 状态位;
    }

    public void set状态位(String 状态位) {
        this.状态位 = 状态位 == null ? null : 状态位.trim();
    }

    public Boolean get预约资格() {
        return 预约资格;
    }

    public void set预约资格(Boolean 预约资格) {
        this.预约资格 = 预约资格;
    }

    public Boolean get馆际互借() {
        return 馆际互借;
    }

    public void set馆际互借(Boolean 馆际互借) {
        this.馆际互借 = 馆际互借;
    }

    public String get停借日期() {
        return 停借日期;
    }

    public void set停借日期(String 停借日期) {
        this.停借日期 = 停借日期 == null ? null : 停借日期.trim();
    }

    public Integer get停借天数() {
        return 停借天数;
    }

    public void set停借天数(Integer 停借天数) {
        this.停借天数 = 停借天数;
    }

    public String get图书馆代码() {
        return 图书馆代码;
    }

    public void set图书馆代码(String 图书馆代码) {
        this.图书馆代码 = 图书馆代码 == null ? null : 图书馆代码.trim();
    }

    public String get图书馆名称() {
        return 图书馆名称;
    }

    public void set图书馆名称(String 图书馆名称) {
        this.图书馆名称 = 图书馆名称 == null ? null : 图书馆名称.trim();
    }

    public Date get更新时间() {
        return 更新时间;
    }

    public void set更新时间(Date 更新时间) {
        this.更新时间 = 更新时间;
    }

    public String get身份证号() {
        return 身份证号;
    }

    public void set身份证号(String 身份证号) {
        this.身份证号 = 身份证号 == null ? null : 身份证号.trim();
    }

    public String get职业行业() {
        return 职业行业;
    }

    public void set职业行业(String 职业行业) {
        this.职业行业 = 职业行业 == null ? null : 职业行业.trim();
    }

    public String get文化程度() {
        return 文化程度;
    }

    public void set文化程度(String 文化程度) {
        this.文化程度 = 文化程度 == null ? null : 文化程度.trim();
    }

    public String get业务职称() {
        return 业务职称;
    }

    public void set业务职称(String 业务职称) {
        this.业务职称 = 业务职称 == null ? null : 业务职称.trim();
    }

    public String get备注() {
        return 备注;
    }

    public void set备注(String 备注) {
        this.备注 = 备注 == null ? null : 备注.trim();
    }

    public String get停借原因() {
        return 停借原因;
    }

    public void set停借原因(String 停借原因) {
        this.停借原因 = 停借原因 == null ? null : 停借原因.trim();
    }

    public String get停借操作员() {
        return 停借操作员;
    }

    public void set停借操作员(String 停借操作员) {
        this.停借操作员 = 停借操作员 == null ? null : 停借操作员.trim();
    }

    public String get卡号() {
        return 卡号;
    }

    public void set卡号(String 卡号) {
        this.卡号 = 卡号 == null ? null : 卡号.trim();
    }

    public Boolean get预借资格() {
        return 预借资格;
    }

    public void set预借资格(Boolean 预借资格) {
        this.预借资格 = 预借资格;
    }

    public String get读者签名() {
        return 读者签名;
    }

    public void set读者签名(String 读者签名) {
        this.读者签名 = 读者签名 == null ? null : 读者签名.trim();
    }

    public String get读者流水号() {
        return 读者流水号;
    }

    public void set读者流水号(String 读者流水号) {
        this.读者流水号 = 读者流水号 == null ? null : 读者流水号.trim();
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
        Dzxxb other = (Dzxxb) that;
        return (this.get标识列() == null ? other.get标识列() == null : this.get标识列().equals(other.get标识列()))
            && (this.get读者证号() == null ? other.get读者证号() == null : this.get读者证号().equals(other.get读者证号()))
            && (this.get读者姓名() == null ? other.get读者姓名() == null : this.get读者姓名().equals(other.get读者姓名()))
            && (this.get读者性别() == null ? other.get读者性别() == null : this.get读者性别().equals(other.get读者性别()))
            && (this.get读者单位() == null ? other.get读者单位() == null : this.get读者单位().equals(other.get读者单位()))
            && (this.get读者类别() == null ? other.get读者类别() == null : this.get读者类别().equals(other.get读者类别()))
            && (this.get读者身份() == null ? other.get读者身份() == null : this.get读者身份().equals(other.get读者身份()))
            && (this.get读者口令() == null ? other.get读者口令() == null : this.get读者口令().equals(other.get读者口令()))
            && (this.get出生日期() == null ? other.get出生日期() == null : this.get出生日期().equals(other.get出生日期()))
            && (this.get办证日期() == null ? other.get办证日期() == null : this.get办证日期().equals(other.get办证日期()))
            && (this.get终止日期() == null ? other.get终止日期() == null : this.get终止日期().equals(other.get终止日期()))
            && (this.get邮政编码() == null ? other.get邮政编码() == null : this.get邮政编码().equals(other.get邮政编码()))
            && (this.get地址() == null ? other.get地址() == null : this.get地址().equals(other.get地址()))
            && (this.get电话() == null ? other.get电话() == null : this.get电话().equals(other.get电话()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.get允借册数() == null ? other.get允借册数() == null : this.get允借册数().equals(other.get允借册数()))
            && (this.get借出册数() == null ? other.get借出册数() == null : this.get借出册数().equals(other.get借出册数()))
            && (this.get状态位() == null ? other.get状态位() == null : this.get状态位().equals(other.get状态位()))
            && (this.get预约资格() == null ? other.get预约资格() == null : this.get预约资格().equals(other.get预约资格()))
            && (this.get馆际互借() == null ? other.get馆际互借() == null : this.get馆际互借().equals(other.get馆际互借()))
            && (this.get停借日期() == null ? other.get停借日期() == null : this.get停借日期().equals(other.get停借日期()))
            && (this.get停借天数() == null ? other.get停借天数() == null : this.get停借天数().equals(other.get停借天数()))
            && (this.get图书馆代码() == null ? other.get图书馆代码() == null : this.get图书馆代码().equals(other.get图书馆代码()))
            && (this.get图书馆名称() == null ? other.get图书馆名称() == null : this.get图书馆名称().equals(other.get图书馆名称()))
            && (this.get更新时间() == null ? other.get更新时间() == null : this.get更新时间().equals(other.get更新时间()))
            && (this.get身份证号() == null ? other.get身份证号() == null : this.get身份证号().equals(other.get身份证号()))
            && (this.get职业行业() == null ? other.get职业行业() == null : this.get职业行业().equals(other.get职业行业()))
            && (this.get文化程度() == null ? other.get文化程度() == null : this.get文化程度().equals(other.get文化程度()))
            && (this.get业务职称() == null ? other.get业务职称() == null : this.get业务职称().equals(other.get业务职称()))
            && (this.get备注() == null ? other.get备注() == null : this.get备注().equals(other.get备注()))
            && (this.get停借原因() == null ? other.get停借原因() == null : this.get停借原因().equals(other.get停借原因()))
            && (this.get停借操作员() == null ? other.get停借操作员() == null : this.get停借操作员().equals(other.get停借操作员()))
            && (this.get卡号() == null ? other.get卡号() == null : this.get卡号().equals(other.get卡号()))
            && (this.get预借资格() == null ? other.get预借资格() == null : this.get预借资格().equals(other.get预借资格()))
            && (this.get读者签名() == null ? other.get读者签名() == null : this.get读者签名().equals(other.get读者签名()))
            && (this.get读者流水号() == null ? other.get读者流水号() == null : this.get读者流水号().equals(other.get读者流水号()))
            && (this.getSchoolid() == null ? other.getSchoolid() == null : this.getSchoolid().equals(other.getSchoolid()))
            && (this.getEditflag() == null ? other.getEditflag() == null : this.getEditflag().equals(other.getEditflag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((get标识列() == null) ? 0 : get标识列().hashCode());
        result = prime * result + ((get读者证号() == null) ? 0 : get读者证号().hashCode());
        result = prime * result + ((get读者姓名() == null) ? 0 : get读者姓名().hashCode());
        result = prime * result + ((get读者性别() == null) ? 0 : get读者性别().hashCode());
        result = prime * result + ((get读者单位() == null) ? 0 : get读者单位().hashCode());
        result = prime * result + ((get读者类别() == null) ? 0 : get读者类别().hashCode());
        result = prime * result + ((get读者身份() == null) ? 0 : get读者身份().hashCode());
        result = prime * result + ((get读者口令() == null) ? 0 : get读者口令().hashCode());
        result = prime * result + ((get出生日期() == null) ? 0 : get出生日期().hashCode());
        result = prime * result + ((get办证日期() == null) ? 0 : get办证日期().hashCode());
        result = prime * result + ((get终止日期() == null) ? 0 : get终止日期().hashCode());
        result = prime * result + ((get邮政编码() == null) ? 0 : get邮政编码().hashCode());
        result = prime * result + ((get地址() == null) ? 0 : get地址().hashCode());
        result = prime * result + ((get电话() == null) ? 0 : get电话().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((get允借册数() == null) ? 0 : get允借册数().hashCode());
        result = prime * result + ((get借出册数() == null) ? 0 : get借出册数().hashCode());
        result = prime * result + ((get状态位() == null) ? 0 : get状态位().hashCode());
        result = prime * result + ((get预约资格() == null) ? 0 : get预约资格().hashCode());
        result = prime * result + ((get馆际互借() == null) ? 0 : get馆际互借().hashCode());
        result = prime * result + ((get停借日期() == null) ? 0 : get停借日期().hashCode());
        result = prime * result + ((get停借天数() == null) ? 0 : get停借天数().hashCode());
        result = prime * result + ((get图书馆代码() == null) ? 0 : get图书馆代码().hashCode());
        result = prime * result + ((get图书馆名称() == null) ? 0 : get图书馆名称().hashCode());
        result = prime * result + ((get更新时间() == null) ? 0 : get更新时间().hashCode());
        result = prime * result + ((get身份证号() == null) ? 0 : get身份证号().hashCode());
        result = prime * result + ((get职业行业() == null) ? 0 : get职业行业().hashCode());
        result = prime * result + ((get文化程度() == null) ? 0 : get文化程度().hashCode());
        result = prime * result + ((get业务职称() == null) ? 0 : get业务职称().hashCode());
        result = prime * result + ((get备注() == null) ? 0 : get备注().hashCode());
        result = prime * result + ((get停借原因() == null) ? 0 : get停借原因().hashCode());
        result = prime * result + ((get停借操作员() == null) ? 0 : get停借操作员().hashCode());
        result = prime * result + ((get卡号() == null) ? 0 : get卡号().hashCode());
        result = prime * result + ((get预借资格() == null) ? 0 : get预借资格().hashCode());
        result = prime * result + ((get读者签名() == null) ? 0 : get读者签名().hashCode());
        result = prime * result + ((get读者流水号() == null) ? 0 : get读者流水号().hashCode());
        result = prime * result + ((getSchoolid() == null) ? 0 : getSchoolid().hashCode());
        result = prime * result + ((getEditflag() == null) ? 0 : getEditflag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", 标识列=").append(标识列);
        sb.append(", 读者证号=").append(读者证号);
        sb.append(", 读者姓名=").append(读者姓名);
        sb.append(", 读者性别=").append(读者性别);
        sb.append(", 读者单位=").append(读者单位);
        sb.append(", 读者类别=").append(读者类别);
        sb.append(", 读者身份=").append(读者身份);
        sb.append(", 读者口令=").append(读者口令);
        sb.append(", 出生日期=").append(出生日期);
        sb.append(", 办证日期=").append(办证日期);
        sb.append(", 终止日期=").append(终止日期);
        sb.append(", 邮政编码=").append(邮政编码);
        sb.append(", 地址=").append(地址);
        sb.append(", 电话=").append(电话);
        sb.append(", email=").append(email);
        sb.append(", 允借册数=").append(允借册数);
        sb.append(", 借出册数=").append(借出册数);
        sb.append(", 状态位=").append(状态位);
        sb.append(", 预约资格=").append(预约资格);
        sb.append(", 馆际互借=").append(馆际互借);
        sb.append(", 停借日期=").append(停借日期);
        sb.append(", 停借天数=").append(停借天数);
        sb.append(", 图书馆代码=").append(图书馆代码);
        sb.append(", 图书馆名称=").append(图书馆名称);
        sb.append(", 更新时间=").append(更新时间);
        sb.append(", 身份证号=").append(身份证号);
        sb.append(", 职业行业=").append(职业行业);
        sb.append(", 文化程度=").append(文化程度);
        sb.append(", 业务职称=").append(业务职称);
        sb.append(", 备注=").append(备注);
        sb.append(", 停借原因=").append(停借原因);
        sb.append(", 停借操作员=").append(停借操作员);
        sb.append(", 卡号=").append(卡号);
        sb.append(", 预借资格=").append(预借资格);
        sb.append(", 读者签名=").append(读者签名);
        sb.append(", 读者流水号=").append(读者流水号);
        sb.append(", schoolid=").append(schoolid);
        sb.append(", editflag=").append(editflag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}