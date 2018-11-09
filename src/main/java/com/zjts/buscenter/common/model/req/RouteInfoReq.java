/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zs
 * Date: 2018-11-06
 * Time: 18:34
 */
package com.zjts.buscenter.common.model.req;

public class RouteInfoReq {

    /**
     * 车辆登记城市
     */
    private String city;
    /**
     * 数据源id
     */
    private Integer dataSourceId;
    /**
     * 线路名
     */
    private String routeName;
    /**
     * 线路版本号
     */
    private String routeVersions;
    /**
     * 线路id
     */
    private String routeId;

    /**
     * 上行首班
     */
    private String upstartTime;
    /**
     * 下行首班
     */
    private String downstartTime;
    /**
     * 上行末班
     */
    private String uplastTime;
    /**
     * 下行末班
     */
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
}
