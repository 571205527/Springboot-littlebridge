package com.yh.entity;

import java.io.Serializable;

public class DzxxbWithBLOBs extends Dzxxb implements Serializable {
    private byte[] 读者照片;

    private String 喜欢类目;

    private static final long serialVersionUID = 1L;

    public byte[] get读者照片() {
        return 读者照片;
    }

    public void set读者照片(byte[] 读者照片) {
        this.读者照片 = 读者照片;
    }

    public String get喜欢类目() {
        return 喜欢类目;
    }

    public void set喜欢类目(String 喜欢类目) {
        this.喜欢类目 = 喜欢类目 == null ? null : 喜欢类目.trim();
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
        DzxxbWithBLOBs other = (DzxxbWithBLOBs) that;
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
            && (this.getEditflag() == null ? other.getEditflag() == null : this.getEditflag().equals(other.getEditflag()))
            && (this.get读者照片() == null ? other.get读者照片() == null : this.get读者照片().equals(other.get读者照片()))
            && (this.get喜欢类目() == null ? other.get喜欢类目() == null : this.get喜欢类目().equals(other.get喜欢类目()));
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
        result = prime * result + ((get读者照片() == null) ? 0 : get读者照片().hashCode());
        result = prime * result + ((get喜欢类目() == null) ? 0 : get喜欢类目().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", 读者照片=").append(读者照片);
        sb.append(", 喜欢类目=").append(喜欢类目);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}