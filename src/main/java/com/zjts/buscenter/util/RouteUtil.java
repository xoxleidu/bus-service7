/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zs
 * Date: 2018-10-31
 * Time: 17:06
 *//*


package com.zjts.buscenter.util;


import com.google.common.base.Joiner;
import com.zjts.buscenter.web.model.RouteInfo;
import com.zjts.buscenter.web.model.StationIndex;
import com.zjts.buscenter.web.model.StationInfo;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RouteUtil {


    public RouteInfo findMessage(String message) {
        String[] msg = message.trim().split("\\^");
        String sendtime = msg[0];
        String ordered = msg[1].split("\\|")[0];
        RouteInfo routeinfo = new RouteInfo();
        if (ordered.equals("LINE")) {
            //routeinfo = analysisStationMessage(sendtime,msg[1]);
            return routeinfo;
        } else {
            return routeinfo;
        }
    }

    //private RouteInfo analysisStationMessage(String sendtime, String message) {
    public static void main(String[] args) {
        String s = "2018-09-19 22:59:57,908 ^LINE||LangFang|1||{2路,1507030930,[{廊坊北站东广场,116.700997,39.512219},{市医院,116.702871,39.515945},{明珠大厦,116.702665,39.518478},{市水务局,116.704449,39.519668},{石油通信大厦,116.710571,39.520318},{建筑机械化研究所,116.717086,39.520960},{儿童乐园,116.720251,39.521259},{市公安局,116.721768,39.522890},{特价商城,116.721375,39.526683},{国际饭店,116.720767,39.531165},{移动通信大厦,116.720103,39.536613},{市邮政局,116.720900,39.538330},{第九中学,116.724421,39.538562},{户屯,116.727124,39.541741},{金泰小区,116.726137,39.547816},{金泰小区北门,116.728613,39.551668},{阳光佳和,116.732594,39.552621},{梨园南,116.735471,39.553107},{美好水业,116.739428,39.553932},{小长亭西,116.744684,39.555050},{小长亭东,116.750866,39.556077},{友谊路口,116.756929,39.558087},{憩园新区西门,116.755800,39.562067},{憩园新区,116.757198,39.563638},{新世纪中学,116.759334,39.566152},{开发区供电中心,116.757443,39.570164},{云鹏道派出所,116.755475,39.577293},{四海路北口,116.754005,39.583019},{开发区汽车站北,116.761324,39.588028},{开发区汽车站,116.762988,39.586700},{利仁电器,116.763462,39.582617},{邮政培训中心,116.763868,39.578638},{新奥集团,116.765545,39.577972},{开发区工商局,116.770624,39.578811},{公交四公司腾讯基地,116.770627,39.583268},{开发区高速路口,116.769265,39.588354},{小甸屯,116.777364,39.590488},{南营,116.785741,39.591516},{南营,116.785828,39.591394},{小甸屯,116.778821,39.590803},{开发区高速路口,116.768992,39.588093},{公交四公司腾讯基地,116.770918,39.580829},{开发区工商局,116.770472,39.578922},{新奥集团,116.764997,39.578026},{邮政培训中心,116.764021,39.579190},{利仁电器,116.763704,39.582174},{开发区汽车站,116.763262,39.586203},{开发区汽车站北,116.762222,39.588356},{四海路北口,116.753718,39.583558},{云鹏道派出所,116.755513,39.577016},{开发区供电中心,116.757435,39.570212},{新世纪中学,116.759787,39.565812},{憩园新区,116.757087,39.563883},{憩园新区西门,116.755620,39.561908},{友谊路口,116.755862,39.557191},{小长亭东,116.748763,39.555939},{小长亭西,116.745553,39.555287},{美好水业,116.740531,39.554362},{梨园南,116.736175,39.553451},{阳光佳和,116.732313,39.552717},{金泰小区北门,116.728452,39.551794},{金泰小区,116.726112,39.547382},{户屯,116.726914,39.542174},{第九中学,116.725352,39.538840},{市邮政局,116.721703,39.538585},{移动通信大厦,116.720076,39.535748},{国际饭店,116.720745,39.530352},{特价商城,116.721205,39.525942},{市公安局,116.721660,39.522603},{儿童乐园,116.719751,39.521355},{建筑机械化研究所,116.716555,39.520996},{石油通信大厦,116.710214,39.519907},{市水务局,116.704900,39.519950},{明珠大厦,116.702452,39.518318},{市医院,116.702710,39.515806},{廊坊北站东广场,116.701535,39.512315}],[{21,2路,[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37],[38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75]}],[05:00,23:30,05:00,23:30]}$";
        String sendtime = "ceshi:";
        String message = s.trim().split("\\^")[1];
        RouteInfo routeinfo = new RouteInfo();
        //命令发送时间
        // routeinfo.setSendtime(sendtime);
        //命令子项
        //routeinfo.setOrdered(message.split("\\|")[0]);

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
                stationInfo.setStationName(station.split(",")[0]);
                //坐标
                stationInfo.setStiationGps(station.split(",", 2)[1]);
                stationInfoList.add(stationInfo);
            } else if (i == split2.length - 1 && i != 0) {//最后去 "}" 符号
                String station = StringUtils.remove(split2[i], "}");
                StationInfo stationInfo = new StationInfo();
                stationInfo.setStationName(station.split(",")[0]);
                stationInfo.setStiationGps(station.split(",", 2)[1]);
                stationInfoList.add(stationInfo);
            } else if (i != 0 && i != split2.length - 1) {

                String station = split2[i];
                StationInfo stationInfo = new StationInfo();
                stationInfo.setStationName(station.split(",")[0]);
                stationInfo.setStiationGps(station.split(",", 2)[1]);
                stationInfoList.add(stationInfo);
            }
        }
        routeinfo.setStationIdList(stationInfoList);
//***********以上是站点信息*************


//************以下是站点索引信息**************

        //站点索引集合
        List<StationIndex> indexList = new ArrayList<>();

        //判断 线路多少
        if (split1[1].indexOf("},{") != -1) {

            //截取 线路 split3 [0] 为第一条线路数据 [1]为第二条线路数据
            String[] split3 = split1[1].split("},\\{");

            //str1 为第一条索引数据
            String str1 = StringUtils.remove(split3[0], "{");
            StationIndex stationIndex1 = new StationIndex();

            if (str1.indexOf("],[") != -1) {

                List<String> aList = new ArrayList<>();

                List<String> bList = new ArrayList<>();


                String lineId = null;
                String lineName = null;

                //str1_1 : [0]路线信息+上行索引 [1]下行索引
                String[] str1_1 = str1.split("],\\[");
                String[] indexArr1 = str1_1[0].split("\\[");
                for (int i = 0; i < indexArr1.length; i++) {
                    if (i != indexArr1.length - 1) {    //-1
                        //站点id
                        lineId = indexArr1[i].split(",")[0];
                        //路线名
                        lineName = indexArr1[i].split(",")[1];
                    } else {
                        if (indexArr1[i].indexOf(",") != -1) {
                            String[] upindex = indexArr1[i].split(",");
                            for (int j = 0; j < upindex.length; j++) {
                                // 第一组 上行索引
                                aList.add(upindex[j]);
                            }
                        }
                    }
                }
                stationIndex1.setRouteId(lineId);
                stationIndex1.setRouteName(lineName);
                String upIndex = Joiner.on(",").join(aList);
                stationIndex1.setUpindex(Joiner.on(",").join(aList));
                System.err.println("---------" + stationIndex1.getUpindex());

                if (str1_1[1].indexOf(",") != -1) {
                    String[] indexArr2 = str1_1[1].split(",");
                    for (int i = 0; i < indexArr2.length; i++) {
                        if (i != indexArr2.length - 1) {   //-1
                            //第二组 下行索引
                            bList.add(indexArr2[i]);
                        } else {
                            String index = StringUtils.remove(indexArr2[i], "]");
                            bList.add(index);
                        }
                    }
                    String downIndex = Joiner.on(",").join(bList);
                    stationIndex1.setDownindex(downIndex);
                }
            } else {//单条索引
                List<String> aList = new ArrayList<>();

                String lineName = null;
                String lineId = null;
                String[] strIndex = str1.split(",\\[");
                for (int i = 0; i < strIndex.length; i++) {
                    if (i != strIndex.length - 1) {     //-1
                        String[] routemsg = strIndex[i].split(",");
                        //站点id 路线名
                        lineId = routemsg[0];
                        lineName = routemsg[1];

                    } else {
                        if (strIndex[i].indexOf(",") != -1) {
                            String[] indexArr = strIndex[i].split(",");
                            for (int j = 0; j < indexArr.length; j++) {
                                if (i != indexArr.length - 1) { //-1
                                    //第一组 如果为单条 上行索引
                                    aList.add(indexArr[j]);
                                } else {
                                    aList.add(StringUtils.remove(indexArr[j], "]"));
                                }
                            }
                            String upIndex = Joiner.on(",").join(aList);
                            stationIndex1.setUpindex(upIndex);
                            System.err.println("---------" + stationIndex1.getUpindex());
                        }
                    }
                }
                stationIndex1.setRouteName(lineName);
                stationIndex1.setRouteId(lineId);
            }
            indexList.add(stationIndex1);
            //******** str1  为第一条索引数据 ↑ **********
            //******** str2  为第二条索引数据+时间 ↓**********

            String str2 = StringUtils.remove(split3[1], "]}$");
            String[] strmag = str2.split("]}],\\[");

            //str3 为第二条索引数据
            String str3 = strmag[0];

            StationIndex stationIndex2 = new StationIndex();

            if (str3.indexOf("],[") != -1) {
                List<String> aList = new ArrayList<>();
                List<String> bList = new ArrayList<>();

                //str2_2 : [0]路线信息+上行索引 [1]下行索引
                String[] str2_2 = str3.split("],\\[");
                String[] upIndex = str2_2[0].split(",\\[");
                for (int i = 0; i < upIndex.length; i++) {
                    if (i != upIndex.length - 1) {
                        if (upIndex[i].indexOf(",") != -1) {
                            String[] index = upIndex[i].split(",");
                            for (int j = 0; j < index.length; j++) {
                                if (j != index.length - 1) {
                                    aList.add(index[j]);
                                } else {
                                    String index1 = StringUtils.remove(index[j], "]");
                                    //第二组的 上行索引
                                    aList.add(index1);
                                }
                            }
                        }
                    } else {
                        //路线名 站点id
                        String lineId = upIndex[i].split(",")[0];
                        String lineName = upIndex[i].split(",")[1];
                        stationIndex2.setRouteName(lineName);
                        stationIndex2.setRouteId(lineId);
                    }
                }
                String upIndex1 = Joiner.on(",").join(aList);
                stationIndex2.setUpindex(upIndex1);
                System.err.println("---------" + stationIndex2.getUpindex());

                if (str2_2[1].indexOf(",") != -1) {
                    String[] donIndex = str2_2[1].split(",");
                    for (int i = 0; i < donIndex.length; i++) {
                        //第二组的 下行索引
                        bList.add(donIndex[i]);
                    }
                    String downIndex = Joiner.on(",").join(bList);
                    stationIndex2.setDownindex(downIndex);
                }
            } else { //单条
                List<String> aList = new ArrayList<>();


                //upindex : 索引信息+路线信息
                String[] upIndex = str3.split(",\\[");
                String lineId = null;
                String lineName = null;
                for (int i = 0; i < upIndex.length; i++) {
                    if (i != upIndex.length - 1) {
                        String[] routenmas = upIndex[i].split(",");
                        //路线名 站点id
                        lineId = routenmas[0];
                        lineName = routenmas[1];

                    } else {
                        if (upIndex[i].indexOf(",") != -1) {
                            String[] indexArr = upIndex[i].split(",");
                            for (int j = 0; j < indexArr.length; j++) {
                                aList.add(indexArr[j]);
                            }
                        }
                    }
                }
                stationIndex2.setRouteName(lineName);
                stationIndex2.setRouteId(lineId);
                String upIndex1 = Joiner.on(",").join(aList);
                stationIndex2.setUpindex(upIndex1);
                System.err.println("---------" + stationIndex2.getUpindex());
            }
            //strtime为班车时间
            String[] busTimeList = strmag[1].split(",");
            //上行首班
            routeinfo.setUpstartTime(busTimeList[0]);
            //上行末班
            routeinfo.setDownstartTime(busTimeList[1]);
            //下行首班
            routeinfo.setUplastTime(busTimeList[2]);
            //下行末班
            routeinfo.setDownlastTime(busTimeList[3]);
            indexList.add(stationIndex2);
            routeinfo.setStationindexIdList(indexList);
        } else {//单条路线 信息

            StationIndex stationIndex3 = new StationIndex();
            List<String> aList = new ArrayList<>();
            List<String> bList = new ArrayList<>();

            //sp3 : [0]路线索引信息+路线信息 [1] 班车时间
            String[] split3 = split1[1].split("]}],\\[");

            String routeMag = split3[0];
            String busTime = StringUtils.remove(split3[1], "]}$");

            //分解 sp3[0]
            if (routeMag.indexOf("],[") != -1) {
                //mag1 : [0]路线信息+第一组索引 [1]第二组索引
                String[] mag1 = routeMag.split("],\\[");

                String[] mag1_1 = mag1[0].split(",\\[");

                String lineId = StringUtils.remove(mag1_1[0].split(",")[0], "{");
                String lineName = mag1_1[0].split(",")[1];

                if (mag1_1[1].indexOf(",") != -1) {
                    String[] upIndexArr = mag1_1[1].split(",");

                    for (int i = 0; i < upIndexArr.length; i++) {
                        aList.add(upIndexArr[i]);
                    }
                    stationIndex3.setUpindex(Joiner.on(",").join(aList));
                    // System.err.println("--1-------"+stationIndex3.getUpindex());
                }
                stationIndex3.setRouteName(lineName);
                stationIndex3.setRouteId(lineId);

                if (mag1[1].indexOf(",") != -1) {
                    String[] donIndexArr = mag1[1].split(",");
                    for (int i = 0; i < donIndexArr.length; i++) {
                        bList.add(donIndexArr[i]);
                    }
                    String downIndex = Joiner.on(",").join(bList);
                    stationIndex3.setDownindex(downIndex);
                }
            } else {
                //mag2 [0] 路线信息 [1]索引信息
                String[] mag2 = routeMag.split(",\\[");
                String lineId = StringUtils.remove(mag2[0].split(",")[0], "{");
                String lineName = mag2[0].split(",")[1];

                if (mag2[1].indexOf(",") != -1) {
                    String[] upIndexArr = mag2[1].split(",");
                    for (int i = 0; i < upIndexArr.length; i++) {
                        aList.add(upIndexArr[i]);
                    }
                    String upIndex = Joiner.on(",").join(aList);
                    stationIndex3.setUpindex(upIndex);
                    //System.err.println("---------"+stationIndex3.getUpindex().toString());
                }
                stationIndex3.setRouteName(lineName);
                stationIndex3.setRouteId(lineId);

            }
            // * 班车时间 *

            String[] busTimeList = busTime.split(",");
            //上行首班
            routeinfo.setUpStartTime(busTimeList[0]);
            //上行末班
            routeinfo.setDownStartTime(busTimeList[1]);
            //下行首班
            routeinfo.setUpLastTime(busTimeList[2]);
            //下行末班
            routeinfo.setDownLastTime(busTimeList[3]);
            indexList.add(stationIndex3);
            routeinfo.setStationindexIdList(indexList);
        }
        System.out.println("发送时间:" + routeinfo.getSendtime());
        System.out.println("命令子项:" + routeinfo.getOrdered());

        System.out.println("车辆登记城市:" + routeinfo.getCity());
        System.out.println("路线id:" + routeinfo.getRouteId());

        System.out.println("路线名称:" + routeinfo.getRouteName());
        System.out.println("路线版本号:" + routeinfo.getRouteVersions());
        for (int i = 0; i < routeinfo.getStationIdList().size(); i++) {
            System.out.println("站点集合 站点名： " + routeinfo.getStationIdList().get(i).getStationName());
            System.out.println(" 经纬度：" + routeinfo.getStationIdList().get(i).getStiationGps());


        }
        for (int i = 0; i < routeinfo.getStationindexIdList().size(); i++) {
            System.out.println("站点 线路id" + routeinfo.getStationindexIdList().get(i).getRouteId());
            System.out.println("站点 线路名" + routeinfo.getStationindexIdList().get(i).getRouteName());
            System.out.println("上行索引 ：" + routeinfo.getStationindexIdList().get(i).getUpindex());
            System.out.println("下行索引 ：" + routeinfo.getStationindexIdList().get(i).getDownindex());
            for (int j = 0; j < routeinfo.getStationindexIdList().get(i).getUpindexList().size(); j++) {
                System.out.println("上行索引 ：" + routeinfo.getStationindexIdList().get(i).getUpindexList().get(j));
            }
            if (routeinfo.getStationindexIdList().get(i).getDownindexList() != null) {
                for (int j = 0; j < routeinfo.getStationindexIdList().get(i).getDownindexList().size(); j++) {
                    System.out.println("下行索引 ：" + routeinfo.getStationindexIdList().get(i).getDownindexList().get(j));
                }
            }

        }
        System.out.println("车辆发行时间： 上行首班：" + routeinfo.getUpStartTime() + "  上行末班：" + routeinfo.getDownStartTime() + "  下行首班：" + routeinfo.getUpLastTime() + " 下行末班：" + routeinfo.getDownLastTime());


        //return routeinfo;
    }
}
*/
