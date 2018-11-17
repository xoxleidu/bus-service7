/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zs
 * Date: 2018-10-24
 * Time: 10:19
 */
package com.zjts.buscenter.common.model.req;

import com.baomidou.mybatisplus.annotations.TableField;
import com.zjts.buscenter.common.model.req.group.bus.AddBusBasic;
import com.zjts.buscenter.common.model.req.group.bus.DeleteBusInfo;
import com.zjts.buscenter.common.model.req.group.bus.UpdateBusBasic;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;

public class BusInfoReq extends  BaseModel{

    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    @NotNull(groups={DeleteBusInfo.class})
    @ApiModelProperty(value = "车辆id")
    private Integer id;

    /**
     * 车牌号
     */
    @NotEmpty(message = "车牌号不能为空")
    @ApiModelProperty(name = "车牌号",example = "冀R88888")
    @Pattern(groups = {AddBusBasic.class},regexp = "^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$")
    private String busLicense;

    /**
     * 厂牌型号
     */
    @ApiModelProperty(value = "车厂牌号",example = "111111")
    private String brandCachet;
    /**
     * 车辆登记编号
     */
    private String registrationNumber;
    /**
     * 发动机号
     */
    private String engineNumber;
    /**
     * 车辆识别码
     */
    private String vehicleIdentification;
    /**
     * 座位数
     */
    @ApiModelProperty(value = "车内座位",example = "40")

    private String seating;
    /**
     * 登记日期
     */
    @ApiModelProperty(value = "登记日期",example = "2018-10-26")
    private String recordDate;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 验车日期
     */
    private String vehicleExamination;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
