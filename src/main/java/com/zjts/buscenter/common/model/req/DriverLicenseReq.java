package com.zjts.buscenter.common.model.req;

import com.zjts.buscenter.common.model.req.group.AddDriverDetails;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
	@NotEmpty(groups = {AddDriverDetails.class},message = "员工号不能为空")
	private Integer employeeId;
    /**
     * 驾驶证有效期
     */
	@NotNull(groups = {AddDriverDetails.class},message = "驾驶证有效期不能为空")
	@Max(value = 42,message = "有效期参数不符")
	private Integer licenseExpirydate;
    /**
     * 所属公司
     */
	@NotNull(groups = {AddDriverDetails.class},message = "所属公司不能为空")
	private Integer CompanyId;
    /**
     * 驾龄
     */
	@NotNull(groups = {AddDriverDetails.class},message = "驾龄不能为空")
	@Max(value = 42,message = "驾龄参数不符")
	private Integer licenseAge;
    /**
     * 驾驶证类型
     */
	@Length(max = 2,message = "驾照类型不符")
	@NotEmpty(groups = {AddDriverDetails.class},message = "驾驶证类型不能为空")
	private String licenseType;

    /**
     * 受到投诉次数
     */
	private Integer complaintCount;
    /**
     * 评级分数
     */
	private Integer grade;



	public Integer getEmployeeId() {
		return employeeId;
	}

	public DriverLicenseReq setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
		return this;
	}

	public Integer getLicenseExpirydate() {
		return licenseExpirydate;
	}

	public DriverLicenseReq setLicenseExpirydate(Integer licenseExpirydate) {
		this.licenseExpirydate = licenseExpirydate;
		return this;
	}

	public Integer getCompanyId() {
		return CompanyId;
	}

	public DriverLicenseReq setCompanyId(Integer CompanyId) {
		this.CompanyId = CompanyId;
		return this;
	}

	public Integer getLicenseAge() {
		return licenseAge;
	}

	public DriverLicenseReq setLicenseAge(Integer licenseAge) {
		this.licenseAge = licenseAge;
		return this;
	}

	public String getLicenseType() {
		return licenseType;
	}

	public DriverLicenseReq setLicenseType(String licenseType) {
		this.licenseType = licenseType;
		return this;
	}

	public Integer getComplaintCount() {
		return complaintCount;
	}

	public DriverLicenseReq setComplaintCount(Integer complaintCount) {
		this.complaintCount = complaintCount;
		return this;
	}

	public Integer getGrade() {
		return grade;
	}

	public DriverLicenseReq setGrade(Integer grade) {
		this.grade = grade;
		return this;
	}



}
