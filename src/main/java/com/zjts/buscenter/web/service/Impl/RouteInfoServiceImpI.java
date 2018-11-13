/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zs
 * Date: 2018-11-01
 * Time: 8:19
 */
package com.zjts.buscenter.web.service.Impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import com.zjts.buscenter.web.dao.RouteInfoMapper;
import com.zjts.buscenter.web.dao.StationIndexMapper;
import com.zjts.buscenter.web.model.GpsInfo;
import com.zjts.buscenter.web.model.RouteInfo;
import com.zjts.buscenter.web.model.StationIndex;
import com.zjts.buscenter.web.model.StationInfo;
import com.zjts.buscenter.web.service.IRouteInfoService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 * 路线 服务实现类
 * </p>
 *
 * @author zs
 * @since 2018-10-30
 */
@Service
@Transactional
public class RouteInfoServiceImpI extends ServiceImpl<RouteInfoMapper, RouteInfo> implements IRouteInfoService {


    @Autowired
    private RouteInfoMapper routeInfoMapper;
    @Autowired
    private StationIndexMapper stationIndexMapper;

    @Override
    public JSONObject findRoute(String Name) {
        String strName = Name.replace("\"", "").trim();
        //首先判断客户端客户输入的是 站名还是 线路名
        Boolean flag = false;
        for (int i = 0; i < strName.length(); i++) {
            if (!Character.isDigit(strName.charAt(i))) {
                flag = false;
            } else {
                flag = true;
            }
        }
        if (strName.endsWith("路")) {
            strName=strName.substring(0,strName.length()-1);
            flag = true;
        }
        System.err.println(flag);
        JSONObject json = new JSONObject();
        //线路名
        if (flag) {
            int[] upIndexArr = upIndexArr(strName + "路");
            int[] downIndexArr = downIndexArr(strName + "路");
            List<StationInfo> routeByRouteName = routeInfoMapper.findRouteByRouteName(strName);

            for (int i = 0; i < routeByRouteName.size(); i++) {
                //线路名
                json.put("routeName", routeByRouteName.get(i).getRouteName());
                //上行起始站
                json.put("upStartName", routeByRouteName.get(upIndexArr[0]).getStationName());
                //上行终点站
                json.put("upEndName", routeByRouteName.get(upIndexArr[upIndexArr.length - 1]).getStationName());
                //下行起始站
                json.put("downStartName", routeByRouteName.get(downIndexArr[0]).getStationName());
                //下行终点站
                json.put("downEndName", routeByRouteName.get(downIndexArr[downIndexArr.length - 1]).getStationName());
            }

        } else {
            List<StationInfo> upStationList = new ArrayList<>();
            List<StationInfo> downStationList = new ArrayList<>();
            //站点名
            List<StationInfo> routeByStationName = routeInfoMapper.findRouteByStationName(strName);
            List<JSONObject> stationInfos = new ArrayList<>();

            // Map<String, List<String>> stationMap = new HashMap<>();
            for (int i = 0; i < routeByStationName.size(); i++) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("routName", routeByStationName.get(i).getRouteName());
                jsonObject.put("stationName", routeByStationName.get(i).getStationName());
                jsonObject.put("stationIndex", routeByStationName.get(i).getRouteIndex());
                stationInfos.add(jsonObject);
            }
             /*
            int[] upIndexArr = null;
            int[] downIndexArr = null;
            for (StationInfo statrion: stationInfos) {
                upIndexArr = upIndexArr(statrion.getRouteName());
                downIndexArr = downIndexArr(statrion.getRouteName());
            }
            for (int i = 0; i < upIndexArr.length; i++) {
                for (int j = 0; j <stationInfos.size() ; j++) {
                    if (upIndexArr[i]==stationInfos.get(j).getRouteIndex()){
                        upStationList.add(stationInfos.get(j));
                    }
                }
            }
            for (int i = 0; i <downIndexArr.length ; i++) {
                for (int j = 0; j <stationInfos.size() ; j++) {
                    if (downIndexArr[i]==stationInfos.get(j).getRouteIndex()){
                        downStationList.add(stationInfos.get(j));
                    }
                }
            }
            */
            //json.put("upStationList",upStationList);
            //json.put("downStationList",downStationList);
            json.put("stationInfos", stationInfos);
        }

        return json;
    }

    @Override
    public JSONObject findStationInfo(String strName, String state) {
        JSONObject json = new JSONObject();
        List<StationInfo> routeByRouteName = routeInfoMapper.findRouteByRouteName(strName.substring(0, 1));
        int[] upIndexArr = upIndexArr(strName);
        int[] downIndexArr = downIndexArr(strName);
        List<StationInfo> upStationList = new ArrayList<>();
        List<StationInfo> downStationList = new ArrayList<>();

        //上行所有站点对象
        for (int i = 0; i < upIndexArr.length; i++) {
            for (int j = 0; j < routeByRouteName.size(); j++) {
                if (upIndexArr[i] == j) {
                    upStationList.add(routeByRouteName.get(j));
                }
            }
        }
        //下行所有站点对象
        for (int i = 0; i < downIndexArr.length; i++) {
            for (int j = 0; j < routeByRouteName.size(); j++) {
                if (downIndexArr[i] == j) {
                    downStationList.add(routeByRouteName.get(j));
                }
            }
        }

        //添加车辆信息
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, -30);
        Date date = calendar.getTime();
        String sdf = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
        //等有数据的时候再放longTime
        Long longTime = Long.parseLong(sdf);
        //List<StationIndex> stationIndexList = routeInfoMapper.findStationIndex(strName);
        List<StationIndex> stationIndexList = stationIndexMapper.selectList(new EntityWrapper<StationIndex>().eq("route_name", strName));
        String routeId = null;
        for (int i = 0; i < stationIndexList.size(); i++) {
            routeId = stationIndexList.get(i).getRouteId();
        }
        List<RouteInfo> routeInfoList = routeInfoMapper.selectList(new EntityWrapper<RouteInfo>().eq("route_id", routeId));

        Long a = 20180919201345L;
        List<GpsInfo> realTimeBus = routeInfoMapper.findBusByRouteID(a, routeId);

        //获取上行站点
        for (int i = 0; i < realTimeBus.size(); i++) {
            for (int j = 0; j < upStationList.size(); j++) {
                if (realTimeBus.get(i).getStationId().equals(upStationList.get(j).getRouteIndex())) {
                    List<GpsInfo> gpsInfos = new ArrayList<>();
                    gpsInfos.add(realTimeBus.get(i));
                    upStationList.get(j).setGpsInfo(gpsInfos);
                }
            }
        }
        //获取下行站点
        for (int i = 0; i < realTimeBus.size(); i++) {
            for (int j = 0; j < downStationList.size(); j++) {
                if (realTimeBus.get(i).getStationId().equals(downStationList.get(j).getRouteIndex())) {
                    List<GpsInfo> gpsInfos = new ArrayList<>();
                    gpsInfos.add(realTimeBus.get(i));
                    downStationList.get(j).setGpsInfo(gpsInfos);
                }
            }
        }

        if (state.equals("0")) {
            for (RouteInfo routeInfo : routeInfoList) {
                json.put("startTime", routeInfo.getUpstartTime());
                json.put("lastTime", routeInfo.getUplastTime());
            }
            json.put("stationList", upStationList);
            System.err.println(json.get("upStationList"));
        } else if (state.equals("1")) {
            for (RouteInfo routeInfo : routeInfoList) {
                json.put("startTime", routeInfo.getDownstartTime());
                json.put("lastTime", routeInfo.getUplastTime());
            }
            json.put("stationList", downStationList);
            System.err.println(json.get("downStationList"));
        }

        return json;

    }

    @Override
    public JSONObject findUpDownStation(String routeName, String stationIndex) {
        int[] upIndexArr = upIndexArr(routeName);
        int[] downIndexArr = downIndexArr(routeName);
        JSONObject json = new JSONObject();
        List<StationInfo> routeByRouteName = routeInfoMapper.findRouteByRouteName(routeName.substring(0, 1));

        for (int i = 0; i < routeByRouteName.size(); i++) {
            //线路名
            json.put("routeName", routeByRouteName.get(i).getRouteName());
            //上行起始站
            json.put("upStartName", routeByRouteName.get(upIndexArr[0]).getStationName());
            //上行终点站
            json.put("upEndName", routeByRouteName.get(upIndexArr[upIndexArr.length - 1]).getStationName());
            //下行起始站
            json.put("downStartName", routeByRouteName.get(downIndexArr[0]).getStationName());
            //下行终点站
            json.put("downEndName", routeByRouteName.get(downIndexArr[downIndexArr.length - 1]).getStationName());
        }

        return json;
    }


    //上行索引
    private int[] upIndexArr(String routeName) {
        //List<StationIndex> stationIndexList = routeInfoMapper.findStationIndex(routeName);
        List<StationIndex> stationIndexList = stationIndexMapper.selectList(new EntityWrapper<StationIndex>().eq("route_name", routeName));

        String[] strupIndexArr = null;
        for (int i = 0; i < stationIndexList.size(); i++) {
            if (stationIndexList.get(i).getUpindex() != null) {
                strupIndexArr = stationIndexList.get(i).getUpindex().split(",");
            }

        }
        //转换类型做判断
        int[] upIndexArr = new int[strupIndexArr.length];
        for (int i = 0; i < strupIndexArr.length; i++) {
            upIndexArr[i] = Integer.parseInt(strupIndexArr[i]);
        }
        return upIndexArr;
    }

    //下索引
    private int[] downIndexArr(String routeName) {
        // List<StationIndex> stationIndexList = routeInfoMapper.findStationIndex(routeName);
        List<StationIndex> stationIndexList = stationIndexMapper.selectList(new EntityWrapper<StationIndex>().eq("route_name", routeName));
        String[] strdownIndexArr = null;
        for (int i = 0; i < stationIndexList.size(); i++) {
            if (stationIndexList.get(i).getDownindex() != null) {
                strdownIndexArr = stationIndexList.get(i).getDownindex().split(",");
            }
        }
        //转换类型做判断
        int[] downIndexArr = new int[strdownIndexArr.length];
        for (int i = 0; i < strdownIndexArr.length; i++) {
            downIndexArr[i] = Integer.parseInt(strdownIndexArr[i]);
        }
        return downIndexArr;
    }
}

