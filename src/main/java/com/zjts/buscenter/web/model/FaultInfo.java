package com.zjts.buscenter.web.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *      公交故障
 * </p>
 *
 * @author zs
 * @since 2018-10-25
 */
@TableName("fault_info")
public class FaultInfo extends Model<FaultInfo> {

    private static final long serialVersionUID = 1L;

	private Integer id;
    /**
     * 故障时间
     */
	@TableField("fault_time")
	private Date faultTime;
    /**
     * 故障内容
     */
	@TableField("fault_content")
	private String faultContent;
	private String solution;
    /**
     * 故障次数
     */
	@TableField("failure_frequency")
	private Integer failureFrequency;

	/**
	 * 故障车牌号
	 */
	@TableField("license_number")
	private String licenseNumber;


	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public Integer getId() {
		return id;
	}

	public FaultInfo setId(Integer id) {
		this.id = id;
		return this;
	}

	public Date getFaultTime() {
		return faultTime;
	}

	public FaultInfo setFaultTime(Date faultTime) {
		this.faultTime = faultTime;
		return this;
	}

	public String getFaultContent() {
		return faultContent;
	}

	public FaultInfo setFaultContent(String faultContent) {
		this.faultContent = faultContent;
		return this;
	}

	public String getSolution() {
		return solution;
	}

	public FaultInfo setSolution(String solution) {
		this.solution = solution;
		return this;
	}

	public Integer getFailureFrequency() {
		return failureFrequency;
	}

	public FaultInfo setFailureFrequency(Integer failureFrequency) {
		this.failureFrequency = failureFrequency;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
