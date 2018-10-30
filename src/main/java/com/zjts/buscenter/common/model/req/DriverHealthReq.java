package com.zjts.buscenter.common.model.req;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.zjts.buscenter.web.model.DriverHealth;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class DriverHealthReq {

    private static final long serialVersionUID = 1L;

    /**
     * 员工号
     */
    @NotEmpty(message = "员工号不能为空")
    @ApiModelProperty(value = "员工号",example = "1001",required = true)
    private Integer employeeId;
    /**
     * 姓名
     */
    @NotEmpty(message = "员工姓名不能为空")
    @ApiModelProperty(value = "姓名",example = "张三")
    private String name;
    /**
     * 档案编号
     */
    @NotEmpty(message = "档案编号不能为空")
    @ApiModelProperty(value = "档案编号",example = "201810267458")
    private String recordId;
    /**
     * 身高
     */
    @NotNull(message = "身高不能为空")
    @ApiModelProperty(value = "档案编号",example = "201810267458")
    private Integer height;
    /**
     * 左眼视力
     */
    @NotNull(message = "左眼视力不能为空")
    @ApiModelProperty(value = "左眼视力",example = "2.0")
    private String leftVision;
    /**
     * 右眼视力
     */
    @NotNull(message = "右眼视力不能为空")
    @ApiModelProperty(value = "右眼视力",example = "2.0")
    private String rightVision;
    /**
     * 是否色盲
     */
    @NotNull(message = "是否色盲不能为空")
    @ApiModelProperty(value = "是否色盲",example = "0")
    private Integer colorBlindness;
    /**
     * 左眼是否矫正
     */
    @NotNull(message = "左眼是否矫正不能为空")
    @ApiModelProperty(value = "左眼是否矫正",example = "0")
    private Integer leftCisualcorrection;
    /**
     * 右眼是否矫正
     */
    @NotNull(message = "右眼是否矫正不能为空")
    @ApiModelProperty(value = "右眼是否矫正",example = "0")
    private Integer rightCisualcorrection;
    /**
     * 是否运动功能障碍
     */
    @NotNull(message = "是否运动功能障碍不能为空")
    @ApiModelProperty(value = "是否运动功能障碍",example = "0")
    private Integer dyskinesia;
    /**
     * 左耳听力
     */
    @NotNull(message = "左耳听力不能为空")
    @ApiModelProperty(value = "左耳听力",example = "正常")
    private String leftEarhearing;
    /**
     * 右耳听力
     */
    @NotNull(message = "右耳听力不能为空")
    @ApiModelProperty(value = "是否运动功能障碍",example = "良好")
    private String rightEarhearing;
    /**
     * 上肢状况
     */
    @NotNull(message = "上肢状况不能为空")
    @ApiModelProperty(value = "上肢状况",example = "良好")
    private String upperlimbCondition;
    /**
     * 下肢状态
     */
    @NotNull(message = "下肢状态不能为空")
    @ApiModelProperty(value = "下肢状态",example = "良好")
    private String lowerlimbCondition;
    /**
     * 双下肢缺失或者丧失运动功能障碍是否能够自主坐立
     */
    @NotNull(message = "自主坐立状态不能为空")
    @ApiModelProperty(value = "自主坐立",example = "1")
    private Integer independySit;
    /**
     * 疾病备注
     */
    @ApiModelProperty(value = "疾病备注",example = "心脏病")
    private String diseaseRemark;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getLeftVision() {
        return leftVision;
    }

    public void setLeftVision(String leftVision) {
        this.leftVision = leftVision;
    }

    public String getRightVision() {
        return rightVision;
    }

    public void setRightVision(String rightVision) {
        this.rightVision = rightVision;
    }

    public Integer getColorBlindness() {
        return colorBlindness;
    }

    public void setColorBlindness(Integer colorBlindness) {
        this.colorBlindness = colorBlindness;
    }

    public Integer getLeftCisualcorrection() {
        return leftCisualcorrection;
    }

    public void setLeftCisualcorrection(Integer leftCisualcorrection) {
        this.leftCisualcorrection = leftCisualcorrection;
    }

    public Integer getRightCisualcorrection() {
        return rightCisualcorrection;
    }

    public void setRightCisualcorrection(Integer rightCisualcorrection) {
        this.rightCisualcorrection = rightCisualcorrection;
    }

    public Integer getDyskinesia() {
        return dyskinesia;
    }

    public void setDyskinesia(Integer dyskinesia) {
        this.dyskinesia = dyskinesia;
    }

    public String getLeftEarhearing() {
        return leftEarhearing;
    }

    public void setLeftEarhearing(String leftEarhearing) {
        this.leftEarhearing = leftEarhearing;
    }

    public String getRightEarhearing() {
        return rightEarhearing;
    }

    public void setRightEarhearing(String rightEarhearing) {
        this.rightEarhearing = rightEarhearing;
    }

    public String getUpperlimbCondition() {
        return upperlimbCondition;
    }

    public void setUpperlimbCondition(String upperlimbCondition) {
        this.upperlimbCondition = upperlimbCondition;
    }

    public String getLowerlimbCondition() {
        return lowerlimbCondition;
    }

    public void setLowerlimbCondition(String lowerlimbCondition) {
        this.lowerlimbCondition = lowerlimbCondition;
    }

    public Integer getIndependySit() {
        return independySit;
    }

    public void setIndependySit(Integer independySit) {
        this.independySit = independySit;
    }

    public String getDiseaseRemark() {
        return diseaseRemark;
    }

    public void setDiseaseRemark(String diseaseRemark) {
        this.diseaseRemark = diseaseRemark;
    }
}
