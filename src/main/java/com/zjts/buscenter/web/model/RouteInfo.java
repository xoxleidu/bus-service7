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
 * @since 2018-11-07
 */
@TableName("route_info")
public class RouteInfo extends Model<RouteInfo> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 车辆登记城市
     */
	private String city;
    /**
     * 数据源id
     */
	@TableField("data_source_id")
	private Integer dataSourceId;
    /**
     * 线路名
     */
	@TableField("route_name")
	private String routeName;
    /**
     * 线路版本号
     */
	@TableField("route_versions")
	private String routeVersions;
    /**
     * 线路id
     */
	@TableField("route_id")
	private String routeId;

    /**
     * 上行首班
     */
	@TableField("upstart_time")
	private String upstartTime;
    /**
     * 下行首班
     */
	@TableField("downstart_time")
	private String downstartTime;
    /**
     * 上行末班
     */
	@TableField("uplast_time")
	private String uplastTime;
    /**
     * 下行末班
     */
	@TableField("downlast_time")
	private String downlastTime;


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getDataSourceId() {
		return dataSourceId;
	}

	public void setDataSourceId(Integer dataSourceId) {
		this.dataSourceId = dataSourceId;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getRouteVersions() {
		return routeVersions;
	}

	public void setRouteVersions(String routeVersions) {
		this.routeVersions = routeVersions;
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public String getUpstartTime() {
		return upstartTime;
	}

	public void setUpstartTime(String upstartTime) {
		this.upstartTime = upstartTime;
	}

	public String getDownstartTime() {
		return downstartTime;
	}

	public void setDownstartTime(String downstartTime) {
		this.downstartTime = downstartTime;
	}

	public String getUplastTime() {
		return uplastTime;
	}

	public void setUplastTime(String uplastTime) {
		this.uplastTime = uplastTime;
	}

	public String getDownlastTime() {
		return downlastTime;
	}

	public void setDownlastTime(String downlastTime) {
		this.downlastTime = downlastTime;
	}

	@Override
	public String toString() {
		return "RouteInfo{" +
				"id=" + id +
				", city='" + city + '\'' +
				", dataSourceId=" + dataSourceId +
				", routeName='" + routeName + '\'' +
				", routeVersions='" + routeVersions + '\'' +
				", routeId='" + routeId + '\'' +
				", upstartTime='" + upstartTime + '\'' +
				", downstartTime='" + downstartTime + '\'' +
				", uplastTime='" + uplastTime + '\'' +
				", downlastTime='" + downlastTime + '\'' +
				'}';
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
