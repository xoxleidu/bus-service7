package com.zjts.buscenter.web.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 司机驾驶证,以及工作评分表
 * </p>
 *
 * @author han zq
 * @since 2018-10-24
 */
@TableName("driver_license")
public class DriverLicense extends Model<DriverLicense> {

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
     * 驾驶证下次年检时间
     */
	@TableField("license_expirydate")
	private Date licenseExpirydate;
    /**
     * 驾龄
     */
	@TableField("license_age")
	private Integer licenseAge;
    /**
     * 驾驶证类型
     */
	@TableField("license_type")
	private String licenseType;
    /**
     * 备注
     */
	private String remarks;
    /**
     * 驾驶证档案编号
     */
	@TableField("license_id")
	private String licenseId;
    /**
     * 修改时间
     */
	@TableField("modified_time")
	private Date modifiedTime;
    /**
     * 驾驶证分数
     */
	@TableField("license_point")
	private Integer licensePoint;

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

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public Integer getLicensePoint() {
		return licensePoint;
	}

	public void setLicensePoint(Integer licensePoint) {
		this.licensePoint = licensePoint;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
