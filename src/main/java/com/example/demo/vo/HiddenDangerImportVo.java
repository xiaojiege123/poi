package com.example.demo.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 隐患记录表
 * </p>
 *
 * @author zhoujie
 * @since 2019-10-10
 */
public class HiddenDangerImportVo implements Serializable {
    @Excel(name = "企业id")
    private Long enterpriseId;
    @Excel(name = "项目id")
    private Long projectId;
    @Excel(name = "隐患描述")
    private String hiddenDangerDescription;
    @Excel(name = "隐患位置")
    private String address;
    @Excel(name = "隐患图片", type = 2 ,width = 40 ,needMerge = true,imageType = 1)
    private String img;
    @Excel(name = "隐患类别",replace = { "特种设备现场管理_1", "生产设备设施及工艺类隐患_2", "场所环境_3","从业人员操作行为_4", "消防安全_5", "用电安全_6","职业卫生现场安全_7", "有限空间现场安全_8", "辅助动力系统_9","相关方现场管理_10", "其它现场管理_11"})
    private Integer type;
    @Excel(name = "隐患等级",replace = { "一般隐患_1" ,"较大隐患_2","重大隐患_3"})
    private Integer level;
    @Excel(name = "整改建议")
    private String rectificationSuggest;
    @Excel(name = "法律法规")
    private String law;
    @Excel(name = "整改时间",importFormat="yyyy-MM-dd")
    private Date rectificationPeriod;

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

    public String getHiddenDangerDescription() {
        return hiddenDangerDescription;
    }

    public void setHiddenDangerDescription(String hiddenDangerDescription) {
        this.hiddenDangerDescription = hiddenDangerDescription;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getRectificationSuggest() {
        return rectificationSuggest;
    }

    public void setRectificationSuggest(String rectificationSuggest) {
        this.rectificationSuggest = rectificationSuggest;
    }

    public String getLaw() {
        return law;
    }

    public void setLaw(String law) {
        this.law = law;
    }

    public Date getRectificationPeriod() {
        return rectificationPeriod;
    }

    public void setRectificationPeriod(Date rectificationPeriod) {
        this.rectificationPeriod = rectificationPeriod;
    }
}
