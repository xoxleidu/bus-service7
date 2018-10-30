package com.zjts.buscenter.web.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 驾驶员体检信息表
 * </p>
 *
 * @author han zq
 * @since 2018-10-29
 */
@TableName("driver_health")
public class DriverHealth extends Model<DriverHealth> {

    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 员工号
     */
	@TableField("employee_id")
	private Integer employeeId;
    /**
     * 姓名
     */
	private String name;
    /**
     * 档案编号
     */
	@TableField("record_id")
	private String recordId;
    /**
     * 身高
     */
	private Integer height;
    /**
     * 左眼视力
     */
	@TableField("left_vision")
	private String leftVision;
    /**
     * 右眼视力
     */
	@TableField("right_vision")
	private String rightVision;
    /**
     * 是否色盲
     */
	@TableField("color_blindness")
	private Integer colorBlindness;
    /**
     * 左眼是否矫正
     */
	@TableField("left_cisualcorrection")
	private Integer leftCisualcorrection;
    /**
     * 右眼是否矫正
     */
	@TableField("right_cisualcorrection")
	private Integer rightCisualcorrection;
    /**
     * 是否运动功能障碍
     */
	private Integer dyskinesia;
    /**
     * 左耳听力
     */
	@TableField("left_earhearing")
	private String leftEarhearing;
    /**
     * 右耳听力
     */
	@TableField("right_earhearing")
	private String rightEarhearing;
    /**
     * 上肢状况
     */
	@TableField("upperlimb_condition")
	private String upperlimbCondition;
    /**
     * 下肢状态
     */
	@TableField("lowerlimb_condition")
	private String lowerlimbCondition;
    /**
     * 双下肢缺失或者丧失运动功能障碍是否能够自主坐立
     */
	@TableField("independy_sit")
	private Integer independySit;
    /**
     * 疾病备注
     */
	@TableField("disease_remark")
	private String diseaseRemark;

	/**
	 * 修改时间
	 */
	@TableField("modified_time")
	private Date modifiedTime;

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
