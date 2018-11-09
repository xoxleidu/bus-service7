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
@TableName("station_info")
public class StationInfo extends Model<StationInfo> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 所属路线
     */
	@TableField("route_name")
	private String routeName;
    /**
     * 创建时间
     */
	@TableField("creation_time")
	private String creationTime;
    /**
     * 站点名称
     */
	@TableField("station_name")
	private String stationName;
    /**
     * 站点Gps
     */
	@TableField("stiation_gps")
	private String stiationGps;

	/**
	 * 站点索引
	 */
	@TableField("route_index")
	private String routeIndex;
    /**
     * 备注
     */
	@TableField("station_remark")
	private String stationRemark;
    /**
     * 站点标志位
     */
	@TableField("station_flag")
	private String stationFlag;

	public String getRouteIndex() {
		return routeIndex;
	}

	public void setRouteIndex(String routeIndex) {
		this.routeIndex = routeIndex;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getStiationGps() {
		return stiationGps;
	}

	public void setStiationGps(String stiationGps) {
		this.stiationGps = stiationGps;
	}

	public String getStationRemark() {
		return stationRemark;
	}

	public void setStationRemark(String stationRemark) {
		this.stationRemark = stationRemark;
	}

	public String getStationFlag() {
		return stationFlag;
	}

	public void setStationFlag(String stationFlag) {
		this.stationFlag = stationFlag;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
