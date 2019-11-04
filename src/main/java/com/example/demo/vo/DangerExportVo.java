package com.example.demo.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 危险源导入表
 * </p>
 *
 * @author zhoujie
 * @since 2019-10-10
 */
public class DangerExportVo implements Serializable {
    @Excel(name = "企业名称",width = 20,mergeVertical = true)
    private String enterpriseName;
    @Excel(name = "项目名称",width = 20,mergeVertical = true)
    private String projectName;
    @Excel(name = "危险源名称")
    private String dangerName;
    @Excel(name = "危险源位置")
    private String dangerPosition;
    @Excel(name = "危险源图片", type = 2 ,width = 10 , height = 20,needMerge = true,imageType = 1)
    private String img;
    @Excel(name = "危险源等级",replace = { "低风险_1", "一般风险_2", "较大风险_3","高风险_4"})
    private Integer dangerLevel;
    @Excel(name = "危险源状态",replace = { "正常_1" ,"异常_2","紧急_3"})
    private Integer dangerStatus;
    @Excel(name = "风险描述",width = 20)
    private String dangerDescription;
    @Excel(name = "整改时间",exportFormat="yyyy-MM-dd")
    private Date createTime;

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDangerName() {
        return dangerName;
    }

    public void setDangerName(String dangerName) {
        this.dangerName = dangerName;
    }

    public String getDangerPosition() {
        return dangerPosition;
    }

    public void setDangerPosition(String dangerPosition) {
        this.dangerPosition = dangerPosition;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(Integer dangerLevel) {
        this.dangerLevel = dangerLevel;
    }

    public Integer getDangerStatus() {
        return dangerStatus;
    }

    public void setDangerStatus(Integer dangerStatus) {
        this.dangerStatus = dangerStatus;
    }

    public String getDangerDescription() {
        return dangerDescription;
    }

    public void setDangerDescription(String dangerDescription) {
        this.dangerDescription = dangerDescription;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
