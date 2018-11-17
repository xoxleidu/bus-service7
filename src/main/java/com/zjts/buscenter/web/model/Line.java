package com.zjts.buscenter.web.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  	线路实体类
 * </p>
 *
 * @author zs
 * @since 2018-11-14
 */
public class Line extends Model<Line> {

    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 线路名称
     */
	@TableField("line_name")
	private String lineName;
    /**
     * 线路版本
     */
	@TableField("line_version")
	private String lineVersion;
    /**
     * 跑法号
     */
	@TableField("run_method")
	private Integer runMethod;
    /**
     * 运营时间
     */
	private String operationTime;
    /**
     * 是否环线
     */
	private Boolean circle;
    /**
     * 上行站点索引集合
     */
	@TableField("up_list")
	private String upList;
    /**
     * 下行站点索引集合
     */
	@TableField("down_list")
	private String downList;
    /**
     * 所属公司
     */
	private Integer company;
	/**
	 * 所有站点集合
	 */
	private List<Station> stationList;

	public List<Station> getStationList() {
		return stationList;
	}

	public void setStationList(List<Station> stationList) {
		this.stationList = stationList;
	}

	public Integer getId() {
		return id;
	}

	public Line setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getLineName() {
		return lineName;
	}

	public Line setLineName(String lineName) {
		this.lineName = lineName;
		return this;
	}

	public String getLineVersion() {
		return lineVersion;
	}

	public Line setLineVersion(String lineVersion) {
		this.lineVersion = lineVersion;
		return this;
	}

	public Integer getRunMethod() {
		return runMethod;
	}

	public Line setRunMethod(Integer runMethod) {
		this.runMethod = runMethod;
		return this;
	}

	public String getOperationTime() {
		return operationTime;
	}

	public Line setOperationTime(String operationTime) {
		this.operationTime = operationTime;
		return this;
	}

	public Boolean isCircle() {
		return circle;
	}

	public Line setCircle(Boolean circle) {
		this.circle = circle;
		return this;
	}

	public String getUpList() {
		return upList;
	}

	public Line setUpList(String upList) {
		this.upList = upList;
		return this;
	}

	public String getDownList() {
		return downList;
	}

	public Line setDownList(String downList) {
		this.downList = downList;
		return this;
	}

	public Integer getCompany() {
		return company;
	}

	public Line setCompany(Integer company) {
		this.company = company;
		return this;
	}

	@Override
	public String toString() {
		return "Line{" +
				"id=" + id +
				", lineName='" + lineName + '\'' +
				", lineVersion='" + lineVersion + '\'' +
				", runMethod=" + runMethod +
				", operationTime='" + operationTime + '\'' +
				", circle=" + circle +
				", upList='" + upList + '\'' +
				", downList='" + downList + '\'' +
				", company=" + company +
				", stationList=" + stationList +
				'}';
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
