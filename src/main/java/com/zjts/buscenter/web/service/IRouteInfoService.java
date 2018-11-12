package com.zjts.buscenter.web.service;

import com.baomidou.mybatisplus.service.IService;
import com.zjts.buscenter.web.model.RouteInfo;
import com.zjts.buscenter.web.model.StationInfo;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zs
 * @since 2018-11-06
 */
@Service
public interface IRouteInfoService extends IService<RouteInfo> {

  /*  //根据路线名查找所有站点
    List<StationInfo> findStationInfo (String routeName);

    //根据线路名查找所有站点索引
    JSONObject findStationName(String routeName);

    //获取站点
    List<StationInfo> findStationInfo(String routeName,String state);

    List<GpsInfo> findBusByRouteID(String routeId);*/
/**===================================================*/
    //根据站点名或是线路名 查询线路信息
    JSONObject findRoute(String strName);
    //根据前台返回的状态 查询固定线路
    JSONObject findStationInfo(String routeName, String state);

    //根据线路名和索引返回上下行终点站
    JSONObject findUpDownStation(String routeName,String stationIndex);

}
