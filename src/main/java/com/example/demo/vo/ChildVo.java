package com.example.demo.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import java.io.Serializable;

@ExcelTarget("child")
public class ChildVo implements Serializable {
    @Excel(name = "姓名",fixedIndex = 3,needMerge = true)
    private String name;
    @Excel(name = "性别",fixedIndex = 4,needMerge = true)
    private String sex;

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


}
