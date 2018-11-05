package com.zjts.buscenter.web.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *      公交保养
 * </p>
 *
 * @author zs
 * @since 2018-10-25
 */
@TableName("maintenance_info")
public class MaintenanceInfo extends Model<MaintenanceInfo> {

    private static final long serialVersionUID = 1L;

	private Integer id;
    /**
     * 保养日期
     */
	@TableField("maintenance_date")
	private Date maintenanceDate;
    /**
     * 保养厂信息
     */
	@TableField("maintenance_plant")
	private String maintenanceFactory;
    /**
     * 保养内容
     */
	@TableField("maintenance_content")
	private String maintenanceContent;
    /**
     * 下次保养日期
     */
	@TableField("next_maintenance_date")
	private Date nextMaintenanceDate;

	/**
	 * 保养车牌号
	 */
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

	public MaintenanceInfo setId(Integer id) {
		this.id = id;
		return this;
	}

	public Date getMaintenanceDate() {
		return maintenanceDate;
	}

	public MaintenanceInfo setMaintenanceDate(Date maintenanceDate) {
		this.maintenanceDate = maintenanceDate;
		return this;
	}

	public String getMaintenanceFactory() {
		return maintenanceFactory;
	}

	public MaintenanceInfo setMaintenanceFactory(String maintenanceFactory) {
		this.maintenanceFactory = maintenanceFactory;
		return this;
	}

	public String getMaintenanceContent() {
		return maintenanceContent;
	}

	public MaintenanceInfo setMaintenanceContent(String maintenanceContent) {
		this.maintenanceContent = maintenanceContent;
		return this;
	}

	public Date getNextMaintenanceDate() {
		return nextMaintenanceDate;
	}

	public MaintenanceInfo setNextMaintenanceDate(Date nextMaintenanceDate) {
		this.nextMaintenanceDate = nextMaintenanceDate;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
