/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zs
 * Date: 2018-10-24
 * Time: 10:19
 */
package com.zjts.buscenter.common.model.req;

import com.zjts.buscenter.common.model.req.group.bus.AddBusBasic;
import com.zjts.buscenter.common.model.req.group.bus.UpdateBusBasic;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;

public class BusInfoReq {

    private static final long serialVersionUID = 1L;

    /**
     * 车辆类型
     */
    @NotEmpty(groups = {AddBusBasic.class},message = "请出入车辆类型")
    @ApiModelProperty(value = "车辆类型",example = "城市公交")
    private String vehicleType;
    /**
     * 车牌号
     */
    @NotEmpty(message = "车牌号不能为空")
    @ApiModelProperty(name = "车牌号",example = "冀R88888")
    @Pattern(groups = {AddBusBasic.class},regexp = "^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$")
    private String licenseNumber;
    /**
     * 车长
     */

    @ApiModelProperty(value = "车身长度/mm",example = "11530.01")
    private Double busLength;
    /**
     * 车身宽
     */

    @ApiModelProperty(value = "车身宽度/mm",example = "2500.01")
    private Double busWide;
    /**
     * 车身高
     */

    @ApiModelProperty(value = "车身高度/mm",example = "3040.01")
    private Double busHigh;
    /**
     * 座位
     */

    @ApiModelProperty(value = "车内座位",example = "40")
    private Integer seating;
    /**
     * 厂牌号
     */

    @ApiModelProperty(value = "车厂牌号",example = "111111")
    private Integer factoryBrand;
    /**
     * 路线id
     */
    @NotNull(groups = {UpdateBusBasic.class},message = "请选择路线")
    @ApiModelProperty(value = "路线ID",example = "1")
    private Integer pathId;
    /**
     * 站点id（0：未知）
     */
    @ApiModelProperty(value = "站点ID（0：未知）",example = "0")
    private Integer stationId;
    /**
     * 运营状态（0：运营中  -1：非运营）
     */
    @NotNull(message = "请选择运营状态，不能为空")
    @ApiModelProperty(value = "运营状态（0：运营中  -1：非运营）",example = "-1")
    private Integer operationState;
    /**
     * 进出站状态（0：站外 1：站内）
     */
    @NotNull(message = "请出入进出状态，不能为空")
    @ApiModelProperty(value = "进出状态（0：站外 1：站内）",example = "1")
    private Integer stationStatus;
    /**
     * 上下行状态（0：上行  1：下行）
     */
    @ApiModelProperty(value = "上下行状态（0：上行  1：下行）",example = "0")
    private Integer upDownStream;
    /**
     * 经纬度id
     */
    @ApiModelProperty(value = "经纬度ID",example = "1")
    private Integer GSPId;
    /**
     * 车辆登记编号
     */

    @ApiModelProperty(value = "车辆登记号",example = "22222")
    private Integer registrationNumber;
    /**
     * 发动机号
     */

    @ApiModelProperty(value = "发动机号",example = "33333")
    private Integer engineNo;
    /**
     * 车辆识别码
     */
    @ApiModelProperty(value = "车辆识别码",example = "44444")
    private String identificationCode;
    /**
     * 登记日期
     */

    @ApiModelProperty(value = "登记日期",example = "2018-10-26")
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registrationDate;
    /**
     * 验车信息
     */
    @ApiModelProperty(value = "验车信息",example = "已检验")
    private String maintenanceid;
    /**
     * 所属公司
     */
    @NotEmpty(groups = {AddBusBasic.class},message = "请出入车辆所属公司")
    @ApiModelProperty(value = "所属公司",example = "中交天枢")
    private String affiliationCompany;
    /**
     * 油耗
     */
    @ApiModelProperty(value = "油耗",example = "30L")
    private String fuelConsumption;
    /**
     * 空调车标记（0：默认  1：空调车  2：非空调车）
     */

    @ApiModelProperty(value = "空调车标记",example = "0")
    private Integer airConditioned;
    /**
     * 出厂日期
     */
    @ApiModelProperty(value = "出厂日期",example = "2018-10-26")
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date manufactureDate;
    /**
     * 行驶公里
     */
    @ApiModelProperty(value = "行驶公里",example = "55555")
    private Double drivingKm;
    /**
     * 车辆备注
     */
    @ApiModelProperty(value = "车辆备注",example = "测试信息66666")
    private String busNote;

    /**
     * 车辆事故信息
     * @return
     */
    @ApiModelProperty(value = "事故id",example = "1")
    private String faultid;

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getFaultid() {
        return faultid;
    }

    public void setFaultidl(String faultid) {
        this.faultid = faultid;
    }
}
