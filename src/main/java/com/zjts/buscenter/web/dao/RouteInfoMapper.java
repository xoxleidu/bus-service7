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

    List<StationInfo> findStationInfo(@Param("routeName") String routeName);

    List<StationIndex> findStationIndex(@Param("routeName") String routeName);

    List<GpsInfo> findBusByRouteID(@Param("nowTime")Long nowTime,@Param("routeId")String routeId);
}