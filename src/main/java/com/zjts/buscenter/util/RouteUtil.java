/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zs
 * Date: 2018-10-31
 * Time: 17:06
 */
package com.zjts.buscenter.util;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RouteUtil {


   /* public Routeinfo findMessage(String message) {
        String[] msg = message.trim().split("\\^");
        String sendtime = msg[0];
        String ordered = msg[1].split("\\|")[0];
        Routeinfo routeinfo = new Routeinfo();
        if (ordered.equals("LINE")) {
            routeinfo = analysisStationMessage(sendtime,msg[1]);
            return routeinfo;
        }else {
            return routeinfo;
        }
    }

    private Routeinfo analysisStationMessage(String sendtime,String message) {

        Routeinfo routeinfo = new Routeinfo();
        //命令发送时间
        routeinfo.setSendtime(sendtime);
        //命令子项
        routeinfo.setOrdered(message.split("\\|")[0]);
        //车辆登记城市
        String city = message.split("\\|")[2];
        routeinfo.setCity(city);
        //路线id
        String routeId = message.split("\\|")[3];
        routeinfo.setRouteId(routeId);

        String[] split = message.split("\\|")[5].split(",", 3);
        //路线名
        String routeName = split[0].substring(1);
        routeinfo.setRouteName(routeName);
        //路线版本号
        String routeVersions = split[1];
        routeinfo.setRouteVersions(routeVersions);

        //split1[0] 站点信息 split1[1] 站点索引信息 和 时间
        String[] split1 = split[2].split("],\\[", 2);
        //截取的站点信息   split2内为站点信息
        String[] split2 = split1[0].split("},\\{");
        //站点集合
        List<StationInfo> stationInfoList = new ArrayList<>();
        for (int i = 0; i < split2.length; i++) {
            if (i == 0) {//开头去 "[{" 符号
                String station = StringUtils.remove(split2[i], "[{");
                //站点对象
                StationInfo stationInfo = new StationInfo();
                //站名
                stationInfo.setName(station.split(",")[0]);
                //坐标
                stationInfo.setCenter(station.split(",", 2)[1]);
                stationInfoList.add(stationInfo);
            } else if (i == split2.length - 1 && i != 0) {//最后去 "}" 符号
                String station = StringUtils.remove(split2[i], "}");
                StationInfo stationInfo = new StationInfo();
                stationInfo.setName(station.split(",")[0]);
                stationInfo.setCenter(station.split(",", 2)[1]);
                stationInfoList.add(stationInfo);
            } else if (i != 0 && i != split2.length - 1) {

                String station = split2[i];
                StationInfo stationInfo = new StationInfo();
                stationInfo.setName(station.split(",")[0]);
                stationInfo.setCenter(station.split(",", 2)[1]);
                stationInfoList.add(stationInfo);
            }
        }
        routeinfo.setStationList(stationInfoList);
*//************以上是站点信息**************//*


*//*************以下是站点索引信息***************//*

        //站点索引集合
        List<StationIndex> indexList = new ArrayList<>();

        //判断 线路多少
        if (split1[1].indexOf("},{") != -1) {

            //截取 线路 split3 [0] 为第一条线路数据 [1]为第二条线路数据
            String[] split3 = split1[1].split("},\\{");

            //str1 为第一条索引数据
            String str1 = StringUtils.remove(split3[0], "{");
            StationIndex stationIndex1 = new StationIndex();

            if (str1.indexOf("],[")!=-1) {

                List<String> aList = new ArrayList<>();
                List<String> bList = new ArrayList<>();

                String lineId =null;
                String lineName = null;

                //str1_1 : [0]路线信息+上行索引 [1]下行索引
                String[] str1_1 = str1.split("],\\[");
                String[] indexArr1 = str1_1[0].split("\\[");
                for (int i = 0; i < indexArr1.length; i++) {
                    if (i!=indexArr1.length-1){    //-1
                        //站点id
                        lineId = indexArr1[i].split(",")[0];
                        //路线名
                        lineName =indexArr1[i].split(",")[1];
                    }else {
                        if (indexArr1[i].indexOf(",") != -1) {
                            String[] upindex = indexArr1[i].split(",");
                            for (int j = 0; j < upindex.length; j++) {
                                // 第一组 上行索引
                                aList.add(upindex[j]);
                            }
                        }
                    }
                }
                stationIndex1.setLineid(lineId);
                stationIndex1.setLinename(lineName);
                stationIndex1.setaList(aList);

                if (str1_1[1].indexOf(",")!=-1){
                    String[] indexArr2 = str1_1[1].split(",");
                    for (int i = 0; i < indexArr2.length; i++) {
                        if (i!=indexArr2.length-1){   //-1
                            //第二组 下行索引
                            bList.add(indexArr2[i]);
                        }else {
                            String index = StringUtils.remove(indexArr2[i], "]");
                            bList.add(index);
                        }
                    }
                    stationIndex1.setbList(bList);
                }
            }else {//单条索引
                List<String> aList = new ArrayList<>();

                String lineName= null;
                String lineId = null;
                String[] strIndex = str1.split(",\\[");
                for (int i = 0; i < strIndex.length; i++) {
                    if (i!=strIndex.length-1){     //-1
                        String[] routemsg = strIndex[i].split(",");
                        //站点id 路线名
                        lineId = routemsg[0];
                        lineName =routemsg[1];

                    }else {
                        if (strIndex[i].indexOf(",") != -1) {
                            String[] indexArr = strIndex[i].split(",");
                            for (int j = 0; j < indexArr.length; j++) {
                                if (i != indexArr.length-1) { //-1
                                    //第一组 如果为单条 上行索引
                                    aList.add(indexArr[j]);
                                } else {
                                    aList.add(StringUtils.remove(indexArr[j], "]"));
                                }
                            }
                            stationIndex1.setaList(aList);
                        }
                    }
                }
                stationIndex1.setLinename(lineName);
                stationIndex1.setLineid(lineId);
            }
            indexList.add(stationIndex1);
            *//********* str1  为第一条索引数据 ↑ ***********//*
            *//********* str2  为第二条索引数据+时间 ↓***********//*

            String str2 = StringUtils.remove(split3[1], "]}$");
            String[] strmag = str2.split("]}],\\[");

            //str3 为第二条索引数据
            String str3 = strmag[0];

            StationIndex stationIndex2 = new StationIndex();

            if (str3.indexOf("],[")!=-1) {
                List<String> aList = new ArrayList<>();
                List<String> bList = new ArrayList<>();

                //str2_2 : [0]路线信息+上行索引 [1]下行索引
                String[] str2_2 = str3.split("],\\[");
                String[] upIndex = str2_2[0].split(",\\[");
                for (int i = 0; i < upIndex.length; i++) {
                    if (i!=upIndex.length-1){
                        if (upIndex[i].indexOf(",")!=-1){
                            String[] index = upIndex[i].split(",");
                            for (int j = 0; j < index.length; j++) {
                                if (j!=index.length-1){
                                    aList.add(index[j]);
                                }else{
                                    String index1 = StringUtils.remove(index[j], "]");
                                    //第二组的 上行索引
                                    aList.add(index1);
                                }
                            }
                        }
                    }else {
                        //路线名 站点id
                        String lineId  = upIndex[i].split(",")[0];
                        String lineName = upIndex[i].split(",")[1];
                        stationIndex2.setLinename(lineName);
                        stationIndex2.setLineid(lineId);
                    }
                }
                stationIndex2.setaList(aList);

                if (str2_2[1].indexOf(",")!=-1) {
                    String[] donIndex = str2_2[1].split(",");
                    for (int i = 0; i < donIndex.length; i++) {
                        //第二组的 下行索引
                        bList.add(donIndex[i]);
                    }
                    stationIndex2.setbList(bList);
                }
            }else { //单条
                List<String> aList = new ArrayList<>();


                //upindex : 索引信息+路线信息
                String[] upIndex = str3.split(",\\[");
                String lineId  = null;
                String lineName = null;
                for (int i = 0; i < upIndex.length; i++) {
                    if (i!=upIndex.length-1){
                        String[] routenmas = upIndex[i].split(",");
                        //路线名 站点id
                        lineId  = routenmas[0];
                        lineName = routenmas[1];

                    }else {
                        if (upIndex[i].indexOf(",")!=-1){
                            String[] indexArr = upIndex[i].split(",");
                            for (int j = 0; j < indexArr.length; j++) {
                                aList.add(indexArr[j]);
                            }
                        }
                    }
                }
                stationIndex2.setLinename(lineName);
                stationIndex2.setLineid(lineId);
            }
            //strtime为班车时间
            String busTime = strmag[1];
            routeinfo.setWorkCycle(busTime);
            indexList.add(stationIndex2);
            routeinfo.setIndexList(indexList);
        } else {//单条路线 信息



            StationIndex stationIndex3 = new StationIndex();
            List<String> aList = new ArrayList<>();
            List<String> bList = new ArrayList<>();

            //sp3 : [0]路线索引信息+路线信息 [1] 班车时间
            String[] split3 = split1[1].split("]}],\\[");

            String routeMag = split3[0];
            String busTime = StringUtils.remove(split3[1],"]}$");

            //分解 sp3[0]
            if (routeMag.indexOf("],[")!=-1){
                //mag1 : [0]路线信息+第一组索引 [1]第二组索引
                String[] mag1 = routeMag.split("],\\[");

                String[] mag1_1 = mag1[0].split(",\\[");

                String lineId  = StringUtils.remove(mag1_1[0].split(",")[0],"{");
                String lineName = mag1_1[0].split(",")[1];

                if (mag1_1[1].indexOf(",")!=-1) {
                    String[] upIndexArr = mag1_1[1].split(",");

                    for (int i = 0; i < upIndexArr.length; i++) {
                        aList.add(upIndexArr[i]);
                    }
                    stationIndex3.setaList(aList);
                }
                stationIndex3.setLinename(lineName);
                stationIndex3.setLineid(lineId);


                if (mag1[1].indexOf(",")!=-1) {
                    String[] donIndexArr = mag1[1].split(",");
                    for (int i = 0; i < donIndexArr.length; i++) {
                        bList.add(donIndexArr[i]);
                    }
                    stationIndex3.setbList(bList);
                }
            }else {
                //mag2 [0] 路线信息 [1]索引信息
                String[] mag2 = routeMag.split(",\\[");
                String lineId  = StringUtils.remove(mag2[0].split(",")[0],"{");
                String lineName = mag2[0].split(",")[1];

                if (mag2[1].indexOf(",")!=-1) {
                    String[] upIndexArr = mag2[1].split(",");
                    for (int i = 0; i < upIndexArr.length; i++) {
                        aList.add(upIndexArr[i]);
                    }
                    stationIndex3.setaList(aList);
                }
                stationIndex3.setLinename(lineName);
                stationIndex3.setLineid(lineId);

            }
            *//** 班车时间 **//*
            routeinfo.setWorkCycle(busTime);
            indexList.add(stationIndex3);
            routeinfo.setIndexList(indexList);
        }
        System.out.println("发送时间:"+routeinfo.getSendtime());
        System.out.println("命令子项:"+routeinfo.getOrdered());
        System.out.println("车辆登记城市:"+routeinfo.getCity());
        System.out.println("路线id:"+routeinfo.getRouteId());
        System.out.println("路线名称:"+routeinfo.getRouteName());
        System.out.println("路线版本号:"+routeinfo.getRouteVersions());
        for (int i = 0; i <routeinfo.getStationList().size(); i++) {
            System.out.println("站点集合 站点名： "+routeinfo.getStationList().get(i).getName());
            System.out.println(" 经纬度："+routeinfo.getStationList().get(i).getCenter());


        }
        for (int i = 0; i <routeinfo.getIndexList().size(); i++) {
            System.out.println("站点 线路id"+routeinfo.getIndexList().get(i).getLineid());
            System.out.println("站点 线路名"+routeinfo.getIndexList().get(i).getLinename());
            for (int j = 0; j <routeinfo.getIndexList().get(i).getaList().size(); j++) {
                System.out.println("上行索引 ："+routeinfo.getIndexList().get(i).getaList().get(j));
            }
            if (routeinfo.getIndexList().get(i).getbList()!=null) {
                for (int j = 0; j < routeinfo.getIndexList().get(i).getbList().size(); j++) {
                    System.out.println("下行索引 ：" + routeinfo.getIndexList().get(i).getbList().get(j));
                }
            }
        }
            System.out.println("车辆发行时间"+routeinfo.getWorkCycle());


        return routeinfo;
    }*/
}
