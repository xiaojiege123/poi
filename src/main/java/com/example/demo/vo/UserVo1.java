package com.example.demo.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import java.io.Serializable;
import java.util.List;

@ExcelTarget("userVo")
public class UserVo1 implements Serializable {
    @Excel(name = "姓名",needMerge = true)
    private String name;
    @Excel(name = "性别",needMerge = true)
    private String sex;
    @Excel(name = "电话",needMerge = true)
    private String phone;
    @Excel(name = "儿子",needMerge = true)
    private String sonName;
    @Excel(name = "女儿",needMerge = true)
    private String dName;
    @Excel(name = "头像", type = 2 ,width = 40 , height = 20,needMerge = true,imageType = 1)
    private String img;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSonName() {
        return sonName;
    }

    public void setSonName(String sonName) {
        this.sonName = sonName;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
