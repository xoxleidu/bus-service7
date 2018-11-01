package com.zjts.buscenter.web.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author zs
 * @since 2018-10-26
 */
@TableName("bus_basis")
public class BusInfo extends Model<BusInfo> {

	private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	/**
	 * 车辆类型
	 */
	@TableField("vehicle_type")
	private String vehicleType;
	/**
	 * 车牌号
	 */
	@TableField("license_number")
	private String licenseNumber;
	/**
	 * 车长
	 */
	@TableField("bus_length")
	private Double busLength;
	/**
	 * 车身宽
	 */
	@TableField("bus_wide")
	private Double busWide;
	/**
	 * 车身高
	 */
	@TableField("bus_high")
	private Double busHigh;
	/**
	 * 座位
	 */
	private Integer seating;
	/**
	 * 厂牌号
	 */
	@TableField("factory_brand")
	private Integer factoryBrand;
	/**
	 * 路线id
	 */
	@TableField("path_id")
	private Integer pathId;
	/**
	 * 站点id（0：未知）
	 */
	@TableField("station_id")
	private Integer stationId;
	/**
	 * 运营状态（0：运营中  -1：非运营）
	 */
	@TableField("operation_state")
	private Integer operationState;
	/**
	 * 进出站状态（0：站外 1：站内）
	 */
	@TableField("station_status")
	private Integer stationStatus;
	/**
	 * 上下行状态（0：上行  1：下行）
	 */
	@TableField("up_downStream")
	private Integer upDownStream;
	/**
	 * 经纬度id
	 */
	@TableField("GSP_id")
	private Integer GSPId;
	/**
	 * 车辆登记编号
	 */
	@TableField("registration_number")
	private Integer registrationNumber;
	/**
	 * 发动机号
	 */
	@TableField("engine_no")
	private Integer engineNo;
	/**
	 * 车辆识别码
	 */
	@TableField("identification_code")
	private String identificationCode;
	/**
	 * 登记日期
	 */
	@TableField("registration_date")
	private Date registrationDate;
	/**
	 * 验车信息
	 */

	private String maintenanceid;
	/**
	 * 所属公司
	 */
	@TableField("affiliation_company")
	private String affiliationCompany;
	/**
	 * 油耗
	 */
	@TableField("fuel_consumption")
	private String fuelConsumption;
	/**
	 * 空调车标记（0：默认  1：空调车  2：非空调车）
	 */
	@TableField("air_Conditioned")
	private Integer airConditioned;
	/**
	 * 出厂日期
	 */
	@TableField("manufacture_date")
	private Date manufactureDate;
	/**
	 * 行驶公里
	 */
	@TableField("driving_km")
	private Double drivingKm;
	/**
	 * 车辆备注
	 */
	@TableField("bus_note")
	private String busNote;

	/**
	 * 车辆事故信息
	 * @return
	 */
	private String faultid;

	public String getFaultid() {
		return faultid;
	}

	public void setFaultidl(String faultid) {
		this.faultid = faultid;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public Double getBusLength() {
		return busLength;
	}

	public void setBusLength(Double busLength) {
		this.busLength = busLength;
	}

	public Double getBusWide() {
		return busWide;
	}

	public void setBusWide(Double busWide) {
		this.busWide = busWide;
	}

	public Double getBusHigh() {
		return busHigh;
	}

	public void setBusHigh(Double busHigh) {
		this.busHigh = busHigh;
	}

	public Integer getSeating() {
		return seating;
	}

	public void setSeating(Integer seating) {
		this.seating = seating;
	}

	public Integer getFactoryBrand() {
		return factoryBrand;
	}

	public void setFactoryBrand(Integer factoryBrand) {
		this.factoryBrand = factoryBrand;
	}

	public Integer getPathId() {
		return pathId;
	}

	public void setPathId(Integer pathId) {
		this.pathId = pathId;
	}

	public Integer getStationId() {
		return stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}

	public Integer getOperationState() {
		return operationState;
	}

	public void setOperationState(Integer operationState) {
		this.operationState = operationState;
	}

	public Integer getStationStatus() {
		return stationStatus;
	}

	public void setStationStatus(Integer stationStatus) {
		this.stationStatus = stationStatus;
	}

	public Integer getUpDownStream() {
		return upDownStream;
	}

	public void setUpDownStream(Integer upDownStream) {
		this.upDownStream = upDownStream;
	}

	public Integer getGSPId() {
		return GSPId;
	}

	public void setGSPId(Integer GSPId) {
		this.GSPId = GSPId;
	}

	public Integer getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(Integer registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Integer getEngineNo() {
		return engineNo;
	}

	public void setEngineNo(Integer engineNo) {
		this.engineNo = engineNo;
	}

	public String getIdentificationCode() {
		return identificationCode;
	}

	public void setIdentificationCode(String identificationCode) {
		this.identificationCode = identificationCode;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getMaintenanceid() {
		return maintenanceid;
	}

	public void setMaintenanceid(String maintenanceid) {
		this.maintenanceid = maintenanceid;
	}

	public String getAffiliationCompany() {
		return affiliationCompany;
	}

	public void setAffiliationCompany(String affiliationCompany) {
		this.affiliationCompany = affiliationCompany;
	}

	public String getFuelConsumption() {
		return fuelConsumption;
	}

	public void setFuelConsumption(String fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	public Integer getAirConditioned() {
		return airConditioned;
	}

	public void setAirConditioned(Integer airConditioned) {
		this.airConditioned = airConditioned;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public Double getDrivingKm() {
		return drivingKm;
	}

	public void setDrivingKm(Double drivingKm) {
		this.drivingKm = drivingKm;
	}

	public String getBusNote() {
		return busNote;
	}

	public void setBusNote(String busNote) {
		this.busNote = busNote;
	}

	@Override
	protected Serializable pkVal() {
		return null;
	}
}
