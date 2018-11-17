package com.zjts.buscenter.web.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 		车辆信息实体类
 * </p>
 *
 * @author zs
 * @since 2018-11-13
 */
@TableName("bus_info")
public class BusInfo extends Model<BusInfo> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private String id;
    /**
     * 线路
     */
	private String line;
    /**
     * 车牌号
     */
	@TableField("bus_license")
	private String busLicense;
    /**
     * 厂牌型号
     */
	@TableField("brand_cachet")
	private String brandCachet;
    /**
     * 车辆登记编号
     */
	@TableField("registration_number")
	private String registrationNumber;
    /**
     * 发动机号
     */
	@TableField("engine_number")
	private String engineNumber;
    /**
     * 车辆识别码
     */
	@TableField("vehicle_identification")
	private String vehicleIdentification;
    /**
     * 座位数
     */
	private String seating;
    /**
     * 登记日期
     */
	@TableField("record_date")
	private String recordDate;
    /**
     * 备注
     */
	private String remarks;
    /**
     * 验车日期
     */
	@TableField("vehicle_examination")
	private String vehicleExamination;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getBusLicense() {
		return busLicense;
	}

	public void setBusLicense(String busLicense) {
		this.busLicense = busLicense;
	}

	public String getBrandCachet() {
		return brandCachet;
	}

	public void setBrandCachet(String brandCachet) {
		this.brandCachet = brandCachet;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getEngineNumber() {
		return engineNumber;
	}

	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}

	public String getVehicleIdentification() {
		return vehicleIdentification;
	}

	public void setVehicleIdentification(String vehicleIdentification) {
		this.vehicleIdentification = vehicleIdentification;
	}

	public String getSeating() {
		return seating;
	}

	public void setSeating(String seating) {
		this.seating = seating;
	}

	public String getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getVehicleExamination() {
		return vehicleExamination;
	}

	public void setVehicleExamination(String vehicleExamination) {
		this.vehicleExamination = vehicleExamination;
	}

	@Override
	public String toString() {
		return "BusInfo{" +
				"id=" + id +
				", line='" + line + '\'' +
				", busLicense='" + busLicense + '\'' +
				", brandCachet='" + brandCachet + '\'' +
				", registrationNumber='" + registrationNumber + '\'' +
				", engineNumber='" + engineNumber + '\'' +
				", vehicleIdentification='" + vehicleIdentification + '\'' +
				", seating=" + seating +
				", recordDate='" + recordDate + '\'' +
				", remarks='" + remarks + '\'' +
				", vehicleExamination='" + vehicleExamination + '\'' +
				'}';
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
