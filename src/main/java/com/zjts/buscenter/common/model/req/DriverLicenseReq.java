package com.zjts.buscenter.common.model.req;

import com.baomidou.mybatisplus.annotations.TableField;
import com.zjts.buscenter.common.model.req.group.AddDriverDetails;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * <p>
 * 司机驾驶证,以及工作评分表 ,前台验证实体类
 * </p>
 *
 * @author han zq
 * @since 2018-10-24
 */

public class DriverLicenseReq {

    private static final long serialVersionUID = 1L;

    /**
     * 员工号
     */
	@NotNull(message = "员工号不能为空")
	@ApiModelProperty(value = "员工号",example = "1001",required = true)
	private Integer employeeId;

    /**
	 * 驾驶证有效期
	 */
	@NotNull(message = "驾驶证有效期不能为空")
	@Future(message = "日期格式不对")
	@ApiModelProperty(value = "驾驶证有效期",example = "2020-10-25")
	private Date licenseExpirydate;


	/**
     * 驾龄
     */
	@NotNull(message = "驾龄不能为空")
	@Max(value = 42,message = "驾龄参数不符")
	@ApiModelProperty(value = "驾龄",example = "15")
	private Integer licenseAge;
    /**
     * 驾驶证类型
     */
	@Length(max = 2,message = "驾照类型不符")
	@NotEmpty(message = "驾驶证类型不能为空")
	@ApiModelProperty(value = "驾驶证类型",example = "A1")
	private String licenseType;

	/**
	 * 驾驶证分数
	 */
	@NotNull
	@Max(12)
	@Min(1)
	@ApiModelProperty(value = "驾驶证分数",example = "12")
	private Integer licensePoint;
	/**
	 * 备注
	 */
	@ApiModelProperty(value = "备注信息",example = "测试数据")
	private String remarks;
	/**
	 * 驾驶证档案编号
	 */
	@NotNull
	@ApiModelProperty(value = "驾驶证档案编号",example = "402578957854")
	private String licenseId;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Date getLicenseExpirydate() {
		return licenseExpirydate;
	}

	public void setLicenseExpirydate(Date licenseExpirydate) {
		this.licenseExpirydate = licenseExpirydate;
	}

	public Integer getLicenseAge() {
		return licenseAge;
	}

	public void setLicenseAge(Integer licenseAge) {
		this.licenseAge = licenseAge;
	}

	public String getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}

	public Integer getLicensePoint() {
		return licensePoint;
	}

	public void setLicensePoint(Integer licensePoint) {
		this.licensePoint = licensePoint;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getLicenseId() {
		return licenseId;
	}

	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}
}
