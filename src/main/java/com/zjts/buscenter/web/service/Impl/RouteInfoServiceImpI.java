/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zs
 * Date: 2018-11-01
 * Time: 8:19
 */
package com.zjts.buscenter.web.service.Impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import com.zjts.buscenter.web.dao.RouteInfoMapper;
import com.zjts.buscenter.web.model.GpsInfo;
import com.zjts.buscenter.web.model.RouteInfo;
import com.zjts.buscenter.web.model.StationIndex;
import com.zjts.buscenter.web.model.StationInfo;
import com.zjts.buscenter.web.service.IRouteInfoService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Override
    public List<StationInfo> findStationInfo(String routeName) {
        List<StationInfo> stationInfoList = routeInfoMapper.findStationInfo(routeName);
        return stationInfoList;
    }

    //获取站点信息
    @Override
    public JSONObject findStationName(String routeName) {
        //上行索引
        String[] upIndexArr = null;
        //下索引
        String[] downIndexArr = null;
        JSONObject jsonObject = new JSONObject();
        StationIndex stationIndex = new StationIndex();
        //获取索引对象
        List<StationIndex> stationIndexList = routeInfoMapper.findStationIndex(routeName);

        //基本上就是1-2条
        for (int i = 0; i < stationIndexList.size(); i++) {
            //System.out.println("------"+stationIndexList.get(i));
            stationIndex.setRouteName(stationIndexList.get(i).getRouteName());
            if (stationIndexList.get(i).getUpindex() != null) {
                upIndexArr = stationIndexList.get(i).getUpindex().split(",");
                stationIndex.setRouteId(stationIndexList.get(i).getRouteId());
                jsonObject.put("upState",stationIndex.getRouteId());
            }
            if (stationIndexList.get(i).getDownindex() != null) {
                downIndexArr = stationIndexList.get(i).getDownindex().split(",");
                stationIndex.setRouteId(stationIndexList.get(i).getRouteId());
                jsonObject.put("downState",stationIndex.getRouteId());
            }
        }
        jsonObject.put("name", stationIndex.getRouteName());
        //取出上行索引
        if (upIndexArr[0].equals(upIndexArr[upIndexArr.length - 1])) {
            jsonObject.put("upStartIndex", upIndexArr[0]);
            jsonObject.put("upLastIndex", upIndexArr[upIndexArr.length - 1]);
        } else {
            jsonObject.put("upStartIndex", upIndexArr[0]);
            jsonObject.put("upLastIndex", upIndexArr[upIndexArr.length]);
        }

        //取出下行索引
        if (downIndexArr[0].equals(downIndexArr[downIndexArr.length - 1])) {
            jsonObject.put("downStartIndex", downIndexArr[0]);
            jsonObject.put("downLastIndex", downIndexArr[downIndexArr.length - 1]);
        } else {
            jsonObject.put("downStartIndex", downIndexArr[0]);
            jsonObject.put("downLastIndex", downIndexArr[downIndexArr.length]);
        }

        return jsonObject;
    }

    @Override
    public List<StationInfo> findStationInfo(String routeName, String state) {
        //上行索引
        int[] upIndexArr = upIndexArr(routeName);
        //下索引
        int[] downIndexArr = downIndexArr(routeName);

        List<StationInfo> stationInfoList = routeInfoMapper.findStationInfo(routeName);

        List<StationInfo> list = new ArrayList<>();

        String routeId = state.substring(state.length() - 1, state.length());

        //上行站点
        if (routeId.equals("1")) {
            for (int i = 0; i < upIndexArr.length; i++) {
                for (int j = 0; j < stationInfoList.size(); j++) {
                    if (upIndexArr[i] == j) {
                        list.add(stationInfoList.get(j));
                    }
                }
            }
        }
        //获取下行站点
        if (routeId.equals("2")){
            for (int i = 0; i < downIndexArr.length; i++) {
                for (int j = 0; j < stationInfoList.size(); j++) {
                    if (downIndexArr[i] == j) {
                        list.add(stationInfoList.get(j));
                    }
                }
            }
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String strTime = sdf.format(new Date().getTime());
        Long longTime = Long.parseLong(strTime)-1;
        Long a = 20180919201341L;

        List<GpsInfo> realTimeBus = routeInfoMapper.findBusByRouteID(a, state);
        for (int i = 0; i <realTimeBus.size() ; i++) {
            for (int j = 0; j <list.size() ; j++) {
                if (realTimeBus.get(i).getStationId()==list.get(j).getRouteIndex()) {
                    List<GpsInfo> gpsInfos = new ArrayList<>();
                    gpsInfos.add(realTimeBus.get(i));
                    list.get(j).setGpsInfo(gpsInfos);
                }
            }
        }
        return list;


    }

    @Override
    public List<GpsInfo> findBusByRouteID(String routeId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String strTime = sdf.format(new Date().getTime());
        Long longTime = Long.parseLong(strTime)-1;
        Long a = 20180919201341L;
        List<GpsInfo> realTimeBus = routeInfoMapper.findBusByRouteID(a, routeId);

        for (int i = 0; i < realTimeBus.size(); i++) {

            System.out.println(realTimeBus.get(i).toString());
        }
        return realTimeBus;
    }


    //上行索引
    private int[] upIndexArr(String routeName) {
        List<StationIndex> stationIndexList = routeInfoMapper.findStationIndex(routeName);
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
        List<StationIndex> stationIndexList = routeInfoMapper.findStationIndex(routeName);
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

