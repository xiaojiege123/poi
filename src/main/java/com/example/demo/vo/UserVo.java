package com.example.demo.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import java.io.Serializable;
import java.util.List;

@ExcelTarget("userVo")
public class UserVo implements Serializable {
    @Excel(name = "姓名",needMerge = true)
    private String name;
    @Excel(name = "性别",needMerge = true)
    private String sex;
    @Excel(name = "电话",needMerge = true)
    private String phone;
    @ExcelCollection(name = "儿子")
    private List<ChildVo> childVo;
    @ExcelCollection(name = "女儿")
    private List<ChildVo1> childVo1s;

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

    public List<ChildVo> getChildVo() {
        return childVo;
    }

    public void setChildVo(List<ChildVo> childVo) {
        this.childVo = childVo;
    }

    public List<ChildVo1> getChildVo1s() {
        return childVo1s;
    }

    public void setChildVo1s(List<ChildVo1> childVo1s) {
        this.childVo1s = childVo1s;
    }
}
