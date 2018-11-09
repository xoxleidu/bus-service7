/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zs
 * Date: 2018-11-06
 * Time: 14:08
 */
package com.zjts.buscenter.common.model.req;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

public class GpsInfoReq {
    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */

    private Integer id;
    /**
     * 城市
     */
    private String city;
    /**
     * 线路id
     */
    private String lineId;
    /**
     * 车辆标识
     */
    private String vehicleId;
    /**
     * 车牌号
     */
    private String vehicleNumber;
    /**
     * 车辆类型
     */
    private String vehicleTypr;
    /**
     * 创建时间
     */
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
    private String runMethod;
    /**
     * 线路版本
     */
    private String lineVersion;
    /**
     * 上下行
     */
    private Boolean upDown;
    /**
     * 站点序号
     */
    private Integer stationId;
    /**
     * 站内站外,1位站外
     */
    private Boolean stationState;
    /**
     * 是否空调车
     */
    private Boolean airConditioner;
    /**
     * 运行状态
     */
    private String operationState;
    /**
     * 站点id,草案预留
     */
    private String stateNumber;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleTypr() {
        return vehicleTypr;
    }

    public void setVehicleTypr(String vehicleTypr) {
        this.vehicleTypr = vehicleTypr;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public Boolean getException() {
        return exception;
    }

    public void setException(Boolean exception) {
        this.exception = exception;
    }

    public String getRunMethod() {
        return runMethod;
    }

    public void setRunMethod(String runMethod) {
        this.runMethod = runMethod;
    }

    public String getLineVersion() {
        return lineVersion;
    }

    public void setLineVersion(String lineVersion) {
        this.lineVersion = lineVersion;
    }

    public Boolean getUpDown() {
        return upDown;
    }

    public void setUpDown(Boolean upDown) {
        this.upDown = upDown;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Boolean getStationState() {
        return stationState;
    }

    public void setStationState(Boolean stationState) {
        this.stationState = stationState;
    }

    public Boolean getAirConditioner() {
        return airConditioner;
    }

    public void setAirConditioner(Boolean airConditioner) {
        this.airConditioner = airConditioner;
    }

    public String getOperationState() {
        return operationState;
    }

    public void setOperationState(String operationState) {
        this.operationState = operationState;
    }

    public String getStateNumber() {
        return stateNumber;
    }

    public void setStateNumber(String stateNumber) {
        this.stateNumber = stateNumber;
    }
}
