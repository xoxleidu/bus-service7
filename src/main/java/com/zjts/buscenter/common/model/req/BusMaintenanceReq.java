/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zs
 * Date: 2018-10-29
 * Time: 10:47
 */
package com.zjts.buscenter.common.model.req;

import com.zjts.buscenter.common.model.req.group.bus.AddBusMaintenance;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class BusMaintenanceReq {

    private static final long serialVersionUID = 1L;

    /**
     * 保养日期
     */
    @NotEmpty(message = "保养日期不能为空")
    @ApiModelProperty(name = "保养日期",example = "2018-10-26")
    private Date maintenanceDate;
    /**
     * 保养厂信息
     */
    @ApiModelProperty(name = "保养厂信息",example = "公交4s店")
    private String maintenanceFactory;
    /**
     * 保养内容
     */
    @ApiModelProperty(name = "保养内容",example = "换胎")
    private String maintenanceContent;
    /**
     * 下次保养日期
     */
    @ApiModelProperty(name = "下次保养信息",example = "2019-3-26")
    private Date nextMaintenanceDate;

    /**
     * 保养车牌号
     */
    @NotEmpty(groups = {AddBusMaintenance.class},message = "保养车牌号不能为空")
    @ApiModelProperty(name = "车牌号",example = "冀R88888")
    private String licenseNumber;

    public Date getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(Date maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    public String getMaintenanceFactory() {
        return maintenanceFactory;
    }

    public void setMaintenanceFactory(String maintenanceFactory) {
        this.maintenanceFactory = maintenanceFactory;
    }

    public String getMaintenanceContent() {
        return maintenanceContent;
    }

    public void setMaintenanceContent(String maintenanceContent) {
        this.maintenanceContent = maintenanceContent;
    }

    public Date getNextMaintenanceDate() {
        return nextMaintenanceDate;
    }

    public void setNextMaintenanceDate(Date nextMaintenanceDate) {
        this.nextMaintenanceDate = nextMaintenanceDate;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
}
