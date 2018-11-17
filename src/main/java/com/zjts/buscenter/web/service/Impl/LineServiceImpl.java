package com.zjts.buscenter.web.service.Impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zjts.buscenter.common.constant.CodeEnum;
import com.zjts.buscenter.common.model.APIResponse;
import com.zjts.buscenter.util.AppSendUtils;
import com.zjts.buscenter.util.GpsUtil;
import com.zjts.buscenter.web.dao.LineMapper;
import com.zjts.buscenter.web.model.GpsInfo;
import com.zjts.buscenter.web.model.Line;
import com.zjts.buscenter.web.model.Station;
import com.zjts.buscenter.web.service.ILineService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zs
 * @since 2018-11-14
 */
@Service
@Transactional
public class LineServiceImpl extends ServiceImpl<LineMapper, Line> implements ILineService {

    @Autowired
    private LineMapper lineMapper;

    //插入line数据用
    @Override
    public APIResponse insertLine(List<Line> lineList) {
        int i;
        int b = 0;
        int a = 0;
        for (Line line : lineList) {
            if (line != null) {
                if (line.isCircle()) {
                    i = 0;
                } else {
                    i = 1;
                }
                a = lineMapper.insertLine(line.getLineName(), line.getLineVersion(), line.getRunMethod(), line.getOperationTime(), i, line.getUpList(), line.getDownList());
                for (Station station : line.getStationList()) {
                    System.err.println(station);
                    b = lineMapper.insertStation(station.getSiteName(), station.getLat(), station.getLon(), station.getRunMethod());
                }
            }
        }
        if (b > 0 && a > 0) {
            return APIResponse.success("成功 请查询数据库");
        }
        return APIResponse.error(CodeEnum.SAVE_ERROR);
    }

    /**
     * 根据线路名/站点名 查询所有路线
     *
     * @param strName
     * @return
     */
    @Override
    public List<JSONObject> findLineBylineName(String strName) {
        String str = strName.replace("\"", "").trim();
        //首先判断客户端客户输入的是 站名还是 线路名
        Boolean flag = false;
        if (str.endsWith("路")) {
            str = str.substring(0, str.length() - 1);
            flag = true;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                flag = false;
            } else {
                flag = true;
            }
        }
        List<JSONObject> jsonList = new ArrayList<>();

        String start = null;
        String end = null;
        String middle = null;
        if (flag) {//线路名
            List<Line> lineList = lineMapper.findLineBylineName(str + "路");
            for (int i = 0; i < lineList.size(); i++) {
                //根据跑法号查询站点
                List<Station> stationList = lineMapper.findStationByRunMethod(lineList.get(i).getRunMethod());
                for (int j = 0; j < stationList.size(); j++) {
                    if (lineList.get(i).isCircle()) {//如果是环线
                        if (j == 0) {
                            //起始站点
                            start = stationList.get(j).getSiteName();
                        } else if (j == stationList.size() - 1) {
                            //终点站
                            end = stationList.get(j).getSiteName();
                        }
                    } else {//不是环线
                        if (j == 0){
                            start = stationList.get(j).getSiteName();
                        }
                        if (j == stationList.size() - 1){
                            end = stationList.get(j).getSiteName();
                        }
                        String[] upArr = lineList.get(i).getUpList().split(",");
                        middle = stationList.get(upArr.length).getSiteName();
                    }

                }
                JSONObject json = new JSONObject();
                if (lineList.get(i).isCircle()) {
                    //如果是环线 判断上下行
                    if (!lineList.get(i).getUpList().equals("")) {
                        json.put("lineName", lineList.get(i).getLineName());
                        json.put("operationTime", lineList.get(i).getOperationTime());
                        json.put("runMethod",lineList.get(i).getRunMethod());
                        json.put("AB", "A");
                        json.put("startStation", start);
                        json.put("endStation", end);
                    }
                    if (!lineList.get(i).getDownList().equals("")) {
                        json.put("lineName", lineList.get(i).getLineName());
                        json.put("operationTime", lineList.get(i).getOperationTime());
                        json.put("runMethod",lineList.get(i).getRunMethod());
                        json.put("AB", "B");
                        json.put("startStation", start);
                        json.put("endStation", end);
                    }
                } else {
                    //不是环线 设置线路中间点
                    json.put("lineName", lineList.get(i).getLineName());
                    json.put("operationTime", lineList.get(i).getOperationTime());
                    json.put("runMethod",lineList.get(i).getRunMethod());
                    json.put("AB", "");
                    json.put("startStation", start);
                    json.put("middle", middle);
                    json.put("endStation", end);
                }
                jsonList.add(json);
            }
        } else { //站点名
            //根据站点名 查询所有符合的站点
            List<Station> stationNameList = lineMapper.findStationByStatonName(str);
            for (int i = 0; i < stationNameList.size(); i++) {
                //根据站点名查找 该站点的线路信息
                List<Line> lineList = lineMapper.findLineByStationName(stationNameList.get(i).getSiteName());
                for (int j = 0; j < lineList.size(); j++) {
                    JSONObject json = new JSONObject();
                    json.put("stationName", stationNameList.get(i).getSiteName());
                    json.put("operationTime", lineList.get(j).getOperationTime());
                    json.put("lineName", lineList.get(j).getLineName());
                    json.put("runMethod",lineList.get(j).getRunMethod());
                    //根据线路名,跑法号 查询该线路的所有站点信息
                    List<Station> stationList = lineMapper.findStationByLineName(lineList.get(j).getLineName(),lineList.get(j).getRunMethod());
                    for (int k = 0; k < stationList.size(); k++) {
                        //如果是环线
                        if (lineList.get(j).isCircle()){
                            if (k==0){
                                start=stationList.get(k).getSiteName();
                            }
                            if (k==stationList.size()-1){
                                end=stationList.get(k).getSiteName();
                            }
                        }else {
                            if (k==0){
                                start = stationList.get(k).getSiteName();
                            }else if (k==stationList.size()-1){
                                end = stationList.get(k).getSiteName();
                            }
                            String[] upArr = lineList.get(j).getUpList().split(",");
                            middle = stationList.get(upArr.length).getSiteName();
                        }
                    }
                    if (lineList.get(j).isCircle()){
                        if (!lineList.get(j).getUpList().equals("")) {
                            json.put("AB", "A");
                            json.put("startStation", start);
                            json.put("endStation", end);
                        }
                        if (!lineList.get(j).getDownList().equals("")) {
                            json.put("AB", "B");
                            json.put("startStation", start);
                            json.put("endStation", end);
                        }
                    }else {
                        json.put("AB", "");
                        json.put("startStation", start);
                        json.put("middle", middle);
                        json.put("endStation", end);
                    }
                    jsonList.add(json);
                }
            }
        }
        return jsonList;
    }

    /**
     * 根据跑法号 查询所有站点 以及车辆实时数据绑定
     * @param runMethod
     * @return
     */
    @Override
    public List<Station> findAllStationAndBus(String runMethod) {
        runMethod=runMethod.replace("\"", "").trim();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, -30);
        Date date = calendar.getTime();
        String sdf = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
        //等有数据的时候再放longTime
        Long longTime = Long.parseLong(sdf);
        Long a = 20180919205056L;
        //根据跑法号 查询该线路所有站点信息
        List<Station> stationList = lineMapper.findStationByRunMethod(Integer.valueOf(runMethod));
        List<GpsInfo> busGpsList = lineMapper.findBusByRunMethod(a,Integer.valueOf(runMethod));
        for (int i = 0; i <stationList.size() ; i++) {
            for (int j = 0; j < busGpsList.size(); j++) {
                List<GpsInfo> bus = new ArrayList<>();
                if (busGpsList.get(j).getStationId()==(i)){
                    //计算到下一站还有多长时间
                    //站点坐标转换
                    JSONObject jsonStation = AppSendUtils.connectURL(stationList.get(i).getLon(), stationList.get(i).getLat(), "");
                    //车辆坐标转换
                    JSONObject jsonBus = AppSendUtils.connectURL(busGpsList.get(j).getLongitude(), busGpsList.get(j).getLatitude(), "");
                    //计算两点距离
                    double distance = GpsUtil.Distance(jsonStation.get("x"),jsonStation.get("y"),jsonBus.get("x"), jsonBus.get("y"));
                    distance=distance/(30*1000)*60;
                    BigDecimal bd=new BigDecimal(distance).setScale(0, BigDecimal.ROUND_HALF_UP);
                    int time = Integer.parseInt(String.valueOf(bd));
                    if (time<1) {
                        time = 1;
                    }
                    busGpsList.get(j).setNextTime(time);
                    bus.add(busGpsList.get(j));
                    stationList.get(i).setBusGps(bus);
                }
            }
        }

        return stationList;
    }
}
