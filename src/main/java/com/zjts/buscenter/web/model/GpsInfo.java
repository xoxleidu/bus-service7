package com.zjts.buscenter.web.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zs
 * @since 2018-11-06
 */
@TableName("gps_info")
public class GpsInfo extends Model<GpsInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 城市
     */
	private String city;
    /**
     * 线路id
     */
	@TableField("line_id")
	private String lineId;
    /**
     * 车辆标识
     */
	@TableField("vehicle_id")
	private String vehicleId;
    /**
     * 车牌号
     */
	@TableField("vehicle_number")
	private String vehicleNumber;
    /**
     * 车辆类型
     */
	@TableField("vehicle_typr")
	private String vehicleTypr;
    /**
     * 创建时间
     */
	@TableField("date_time")
	private String dateTime;
    /**
     * 经度信息
     */
	private String longitude;
    /**
     * 纬度信息
     */
	private String latitude;
    /**
     * gps方向
     */
	private String direction;
    /**
     * gps速度
     */
	private String speed;
    /**
     * gps信息是否异常
     */
	private Boolean exception;
    /**
     * 跑法号
     */
	@TableField("run_method")
	private String runMethod;
    /**
     * 线路版本
     */
	@TableField("line_version")
	private String lineVersion;
    /**
     * 上下行
     */
	@TableField("up_down")
	private Boolean upDown;
    /**
     * 站点序号
     */
	@TableField("station_id")
	private Integer stationId;
    /**
     * 站内站外,1位站外
     */
	@TableField("station_state")
	private Boolean stationState;
    /**
     * 是否空调车
     */
	@TableField("air_conditioner")
	private Boolean airConditioner;
    /**
     * 运行状态
     */
	@TableField("operation_state")
	private String operationState;
    /**
     * 站点id,草案预留
     */
	@TableField("state_number")
	private String stateNumber;


	public Integer getId() {
		return id;
	}

	public GpsInfo setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getCity() {
		return city;
	}

	public GpsInfo setCity(String city) {
		this.city = city;
		return this;
	}

	public String getLineId() {
		return lineId;
	}

	public GpsInfo setLineId(String lineId) {
		this.lineId = lineId;
		return this;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public GpsInfo setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
		return this;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public GpsInfo setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
		return this;
	}

	public String getVehicleTypr() {
		return vehicleTypr;
	}

	public GpsInfo setVehicleTypr(String vehicleTypr) {
		this.vehicleTypr = vehicleTypr;
		return this;
	}

	public String getDateTime() {
		return dateTime;
	}

	public GpsInfo setDateTime(String dateTime) {
		this.dateTime = dateTime;
		return this;
	}

	public String getLongitude() {
		return longitude;
	}

	public GpsInfo setLongitude(String longitude) {
		this.longitude = longitude;
		return this;
	}

	public String getLatitude() {
		return latitude;
	}

	public GpsInfo setLatitude(String latitude) {
		this.latitude = latitude;
		return this;
	}

	public String getDirection() {
		return direction;
	}

	public GpsInfo setDirection(String direction) {
		this.direction = direction;
		return this;
	}

	public String getSpeed() {
		return speed;
	}

	public GpsInfo setSpeed(String speed) {
		this.speed = speed;
		return this;
	}

	public Boolean isException() {
		return exception;
	}

	public GpsInfo setException(Boolean exception) {
		this.exception = exception;
		return this;
	}

	public String getRunMethod() {
		return runMethod;
	}

	public GpsInfo setRunMethod(String runMethod) {
		this.runMethod = runMethod;
		return this;
	}

	public String getLineVersion() {
		return lineVersion;
	}

	public GpsInfo setLineVersion(String lineVersion) {
		this.lineVersion = lineVersion;
		return this;
	}

	public Boolean getUpDown() {
		return upDown;
	}

	public GpsInfo setUpDown(Boolean upDown) {
		this.upDown = upDown;
		return this;
	}

	public Integer getStationId() {
		return stationId;
	}

	public GpsInfo setStationId(Integer stationId) {
		this.stationId = stationId;
		return this;
	}

	public Boolean getStationState() {
		return stationState;
	}

	public GpsInfo setStationState(Boolean stationState) {
		this.stationState = stationState;
		return this;
	}

	public Boolean isAirConditioner() {
		return airConditioner;
	}

	public GpsInfo setAirConditioner(Boolean airConditioner) {
		this.airConditioner = airConditioner;
		return this;
	}

	public String getOperationState() {
		return operationState;
	}

	public GpsInfo setOperationState(String operationState) {
		this.operationState = operationState;
		return this;
	}

	public String getStateNumber() {
		return stateNumber;
	}

	public GpsInfo setStateNumber(String stateNumber) {
		this.stateNumber = stateNumber;
		return this;
	}

	@Override
	public String toString() {
		return "GpsInfo{" +
				"id=" + id +
				", city='" + city + '\'' +
				", lineId='" + lineId + '\'' +
				", vehicleId='" + vehicleId + '\'' +
				", vehicleNumber='" + vehicleNumber + '\'' +
				", vehicleTypr='" + vehicleTypr + '\'' +
				", dateTime='" + dateTime + '\'' +
				", longitude='" + longitude + '\'' +
				", latitude='" + latitude + '\'' +
				", direction='" + direction + '\'' +
				", speed='" + speed + '\'' +
				", exception=" + exception +
				", runMethod='" + runMethod + '\'' +
				", lineVersion='" + lineVersion + '\'' +
				", upDown=" + upDown +
				", stationId=" + stationId +
				", stationState=" + stationState +
				", airConditioner=" + airConditioner +
				", operationState='" + operationState + '\'' +
				", stateNumber='" + stateNumber + '\'' +
				'}';
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
