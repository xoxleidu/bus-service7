package com.zjts.buscenter.web.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author zs
 * @since 2018-11-06
 */
@TableName("station_index")
public class StationIndex extends Model<StationIndex> {

    private static final long serialVersionUID = 1L;

	private Integer id;

	@TableField("route_id")
	private String routeId;

	@TableField("route_name")
	private String routeName;

	private String  upindex;
	private String  downindex;


	public Integer getId() {
		return id;
	}

	public StationIndex setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public String getRouteName() {
		return routeName;
	}

	public StationIndex setRouteName(String routeName) {
		this.routeName = routeName;
		return this;
	}

	public String getUpindex() {
        //String[] upIndexArr = upindex.split(",");
        return upindex;
	}

	public void setUpindex(String upindex) {
		this.upindex = upindex;
	}

	public String getDownindex() {
        //String[] downIndexArr = downindex.split(",");
        return downindex;
	}

	public void setDownindex(String downindex) {
		this.downindex = downindex;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
