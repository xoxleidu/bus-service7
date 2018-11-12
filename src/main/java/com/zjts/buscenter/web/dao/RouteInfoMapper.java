package com.zjts.buscenter.web.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zjts.buscenter.web.model.GpsInfo;
import com.zjts.buscenter.web.model.RouteInfo;
import com.zjts.buscenter.web.model.StationIndex;
import com.zjts.buscenter.web.model.StationInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zs
 * @since 2018-11-06
 */
@Repository
public interface RouteInfoMapper extends BaseMapper<RouteInfo> {

    /**根据站点名 模糊查询线路信息 */
    List<StationInfo> findRouteByStationName(@Param("stationName")String stationName);
    /**根据线路名 查询线路信息*/
    List<StationInfo> findRouteByRouteName(@Param("routeName")String routeName);

    /**根据线路名查找 站点索引（整条线路 包含上下行）*/
    //List<StationIndex> findStationIndex(@Param("routeName") String routeName);

    /** 根据最新的时间以及跑法号 查询 车辆信息*/
    List<GpsInfo> findBusByRouteID(@Param("nowTime")Long longTime, @Param("runMethod")String runMethod);

}