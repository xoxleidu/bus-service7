package com.zjts.buscenter.web.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.List;

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
     * 经度
     */
	@TableField("longitude")
	private Double longitude;
	/**
	 * 维度
	 */
	private Double dimension;
	/**
	 * 站点索引
	 */
	@TableField("route_index")
	private Integer routeIndex;
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

	//车辆实时信息
	private List<GpsInfo> gpsInfo;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public List<GpsInfo> getGpsInfo() {
		return gpsInfo;
	}

	public void setGpsInfo(List<GpsInfo> gpsInfo) {
		this.gpsInfo = gpsInfo;
	}

	public Integer getRouteIndex() {
		return routeIndex;
	}

	public void setRouteIndex(Integer routeIndex) {
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

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getDimension() {
		return dimension;
	}

	public void setDimension(Double dimension) {
		this.dimension = dimension;
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
