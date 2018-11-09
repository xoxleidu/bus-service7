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

    @Override
    public JSONObject findStationName(String routeName) {
        //上行索引
        String[] upIndexArr = null;
        //下索引
        String[] downIndexArr = null;
        JSONObject jsonObject = new JSONObject();
        StationIndex stationIndex = new StationIndex();
        List<StationIndex> stationIndexList = routeInfoMapper.findStationIndex(routeName);

        for (int i = 0; i < stationIndexList.size(); i++) {

            //System.out.println("------"+stationIndexList.get(i));
            stationIndex.setRouteName(stationIndexList.get(i).getRouteName());
            if (stationIndexList.get(i).getUpindex() != null) {
                upIndexArr = stationIndexList.get(i).getUpindex().split(",");
            }
            if (stationIndexList.get(i).getDownindex() != null) {
                downIndexArr = stationIndexList.get(i).getDownindex().split(",");
            }
        }
        jsonObject.put("name", stationIndex.getRouteName());
        //取出上行索引

        if (upIndexArr[0].equals(upIndexArr[upIndexArr.length-1])) {

            jsonObject.put("upStartIndex", upIndexArr[0]);
            jsonObject.put("upLastIndex", upIndexArr[upIndexArr.length - 2]);
        } else {
            jsonObject.put("upStartIndex", upIndexArr[0]);
            jsonObject.put("upLastIndex", upIndexArr[upIndexArr.length]);
        }


        //取出下行索引
        if (downIndexArr[0].equals(downIndexArr[downIndexArr.length-1])) {
            jsonObject.put("downStartIndex", downIndexArr[0]);
            jsonObject.put("downLastIndex", downIndexArr[downIndexArr.length - 2]);
        } else {
            jsonObject.put("downStartIndex", downIndexArr[0]);
            jsonObject.put("downLastIndex", downIndexArr[downIndexArr.length]);
        }
        return jsonObject;
    }

    @Override
    public List<StationInfo> findStationInfo(String routeName, String state) {

        List<StationIndex> stationIndexList = routeInfoMapper.findStationIndex(routeName);

        //上行索引
        String [] strupIndexArr = null;
        //下索引
        String[] strdownIndexArr = null;
        for (int i = 0; i < stationIndexList.size(); i++) {
            if (stationIndexList.get(i).getUpindex() != null) {
                strupIndexArr =stationIndexList.get(i).getUpindex().split(",");
            }
            if (stationIndexList.get(i).getDownindex() != null) {
                strdownIndexArr = stationIndexList.get(i).getDownindex().split(",");
            }
        }
        //转换类型做判断
        int[] upIndexArr = new int[strupIndexArr.length];
        int[] downIndexArr =new int[strdownIndexArr.length];
        for (int i = 0; i < strupIndexArr.length; i++) {
            upIndexArr[i]=Integer.parseInt(strupIndexArr[i]);
        }
        for (int i = 0; i <strdownIndexArr.length ; i++) {
            downIndexArr[i] = Integer.parseInt(strdownIndexArr[i]);
        }
        List<StationInfo> stationInfoList = routeInfoMapper.findStationInfo(routeName);

        List<StationInfo> list = new ArrayList<>();

        for (int i = 0; i < stationInfoList.size(); i++) {
            //获取上行站点
            if (state.equals("0")) {
                for (int j = 0; j < upIndexArr.length; j++) {
                    if (upIndexArr[j]==i) {
                        list.add(stationInfoList.get(i));
                    }
                }
            }else if (state.equals("1")){ //获取下行站点
                for (int j = 0; j < downIndexArr.length; j++) {
                    if (downIndexArr[j]==i){
                        list.add(stationInfoList.get(i));
                    }
                }
            }
        }
        return list;
    }

    @Override
    public List<GpsInfo> findBusByRouteID(String routeId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String strTime = sdf.format(new Date().getTime());
        Long longTime = Long.parseLong(strTime);
        Long a = 20180919201341L;
        List<GpsInfo> realTimeBus = routeInfoMapper.findBusByRouteID(a,routeId);

        for (int i = 0; i < realTimeBus.size(); i++) {

            System.out.println(realTimeBus.get(i).toString());
        }

        return realTimeBus;
    }

}
