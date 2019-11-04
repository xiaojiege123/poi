package com.example.demo.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

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
public class DangerImportVo implements Serializable {
    @Excel(name = "企业id")
    private Long enterpriseId;
    @Excel(name = "项目id")
    private Long projectId;
    @Excel(name = "危险源名称")
    private String dangerName;
    @Excel(name = "危险源位置")
    private String dangerPosition;
    @Excel(name = "危险源图片", type = 2 ,width = 40 , height = 20,needMerge = true,imageType = 1)
    private String img;
    @Excel(name = "危险源等级",replace = { "低风险_1", "一般风险_2", "较大风险_3","高风险_4"})
    private Integer dangerLevel;
    @Excel(name = "危险源状态",replace = { "正常_1" ,"异常_2","紧急_3"})
    private Integer dangerStatus;
    @Excel(name = "风险描述")
    private String dangerDescription;

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
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
}
