package com.example.demo.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import java.io.Serializable;
import java.util.List;

@ExcelTarget("userVo")
public class UserVo2 implements Serializable {
    @Excel(name = "姓名", needMerge = true)
    private String name;
    @Excel(name = "性别", needMerge = true)
    private String sex;
    @Excel(name = "电话", needMerge = true)
    private String phone;
    @ExcelEntity(name = "儿子")
    private ChildVo childVo;
    @ExcelEntity(name = "女儿")
    private ChildVo1 childVo1;

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

    public ChildVo getChildVo() {
        return childVo;
    }

    public void setChildVo(ChildVo childVo) {
        this.childVo = childVo;
    }

    public ChildVo1 getChildVo1() {
        return childVo1;
    }

    public void setChildVo1(ChildVo1 childVo1) {
        this.childVo1 = childVo1;
    }
}
