/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zs
 * Date: 2018-10-29
 * Time: 8:42
 */
package com.zjts.buscenter.common.model.req;

import com.zjts.buscenter.common.model.req.group.bus.AddBusBasic;
import com.zjts.buscenter.common.model.req.group.bus.AddBusFault;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class BusFaultReq {
    private static final long serialVersionUID = 1L;

    /**
     * 故障时间
     */
    @NotEmpty(groups = {AddBusFault.class},message = "故障时间不能为空")
    @ApiModelProperty(name = "故障时间",example = "2018-10-28")
    private Date faultTime;
    /**
     * 故障内容
     */
    @NotEmpty(groups = {AddBusFault.class},message ="故障内容不能为空" )
    @ApiModelProperty(name = "故障内容",example = "爆胎")
    private String faultContent;

    /**
     * 解决方案
     */
    @ApiModelProperty(name = "解决方案",example = "等待救援")
    private String solution;
    /**
     * 故障次数
     */
    @ApiModelProperty(name = "故障次数",example = "1")
    private Integer failureFrequency;

    /**
     * 故障车牌号
     */
    @NotEmpty(message = "车牌号不能为空")
    @ApiModelProperty(name = "车牌号",example = "冀R88888")
    @Pattern(groups = {AddBusBasic.class},regexp = "^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$")
    private String licenseNumber;

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getFaultTime() {
        return faultTime;
    }

    public void setFaultTime(Date faultTime) {
        this.faultTime = faultTime;
    }

    public String getFaultContent() {
        return faultContent;
    }

    public void setFaultContent(String faultContent) {
        this.faultContent = faultContent;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public Integer getFailureFrequency() {
        return failureFrequency;
    }

    public void setFailureFrequency(Integer failureFrequency) {
        this.failureFrequency = failureFrequency;
    }
}
