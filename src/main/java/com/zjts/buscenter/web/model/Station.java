package com.zjts.buscenter.web.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 		站点 实体类
 * </p>
 *
 * @author zs
 * @since 2018-11-14
 */
public class Station extends Model<Station> {

    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
	private Integer id;
    /**
     * 站点名称
     */
	@TableField("site_name")
	private String siteName;
    /**
     * 站点经度
     */
	private Double lat;
    /**
     * 站点纬度
     */
	private Double lon;

    /**
	 * 跑法号
	 * @return
	 */
	@TableField("run_method")
	private Integer runMethod;

	private List<GpsInfo> busGps;

	public List<GpsInfo> getBusGps() {
		return busGps;
	}

	public void setBusGps(List<GpsInfo> busGps) {
		this.busGps = busGps;
	}

	public Integer getRunMethod() {
		return runMethod;
	}

	public void setRunMethod(Integer runMethod) {
		this.runMethod = runMethod;
	}

	public Integer getId() {
		return id;
	}

	public Station setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getSiteName() {
		return siteName;
	}

	public Station setSiteName(String siteName) {
		this.siteName = siteName;
		return this;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	@Override
	public String toString() {
		return "Station{" +
				"id=" + id +
				", siteName='" + siteName + '\'' +
				", lat='" + lat + '\'' +
				", lon='" + lon + '\'' +
				", runMethod=" + runMethod +
				'}';
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
