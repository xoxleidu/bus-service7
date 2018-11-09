package com.zjts.buscenter.web.service;

import com.baomidou.mybatisplus.service.IService;
import com.zjts.buscenter.web.dao.RouteInfoMapper;
import com.zjts.buscenter.web.model.GpsInfo;
import com.zjts.buscenter.web.model.RouteInfo;
import com.zjts.buscenter.web.model.StationIndex;
import com.zjts.buscenter.web.model.StationInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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

    //根据路线名查找所有站点
    List<StationInfo> findStationInfo (String routeName);

    //根据线路名查找所有站点索引
    JSONObject findStationName(String routeName);

    //获取站点
    List<StationInfo> findStationInfo(String routeName,String state);

    List<GpsInfo> findBusByRouteID(String routeId);

}
