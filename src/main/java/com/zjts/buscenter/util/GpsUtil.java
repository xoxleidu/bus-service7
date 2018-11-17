/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zs
 * Date: 2018-11-13
 * Time: 17:21
 */
package com.zjts.buscenter.util;

public class GpsUtil {
    /**
     * 计算两地之间的距离（给定经纬度）
     *
     * @param lat1 出发地维度
     * @param lng1 出发地经度
     * @param lat2 目的地纬度
     * @param lng2 目的地经度
     * @return double 两点之间的距离
     */
    private static double EARTH_RADIUS = 6378.137;    //定义地球的半径
    private static double rad(double d) {
        return d * Math.PI / 180.0;  //弧度转为角度
    }
    public static double GetDistance(Object lat1, Object lng1, Object lat2, Object lng2) {
        Double dlat1=Double.parseDouble(lat1.toString());
        Double dlng1=Double.parseDouble(lng1.toString());
        Double dlat2=Double.parseDouble(lat2.toString());
        Double dlng2=Double.parseDouble(lng2.toString());
        System.err.println("lat1:"+dlat1);
        System.err.println("lng1:"+dlng1);
        System.err.println("lat2:"+dlat2);
        System.err.println("lng2:"+dlng2);

        double radLat1 = rad(dlat1);
        double radLat2 = rad(dlat2);
        double a =radLat1 - radLat2;
        double b = rad(dlng1) - rad(dlng2);
        System.err.println("a:"+a);
        System.err.println("b:"+b);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) +
                Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000;
        System.err.println("两点距离：" +s);
        return s;
    }
      /**
       * @param long1 经度1
       * @param lat1  维度1
       * @param long2 经度2
       * @param lat2  维度2
       * @return
       * */
    public static double Distance(Object long1, Object lat1, Object long2, Object lat2) {
        Double dlat1=Double.parseDouble(lat1.toString());
        Double dlng1=Double.parseDouble(long1.toString());
        Double dlat2=Double.parseDouble(lat2.toString());
        Double dlng2=Double.parseDouble(long2.toString());

        double a, b, R;
        R = 6378137; // 地球半径（米）
        dlat1 = dlat1 * Math.PI / 180.0;
        dlat2 = dlat2 * Math.PI / 180.0;
        a = dlat1 - dlat2;
        b = (dlng1 - dlng2) * Math.PI / 180.0;
        double d;
        double sa2, sb2;
        sa2 = Math.sin(a / 2.0);
        sb2 = Math.sin(b / 2.0);
        d = 2
                * R
                * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(sa2)
                * Math.cos(dlat2) * sb2 * sb2));
        return d;
    }

    public static void main(String[] args) {
       /* double distance = Distance(116.70926, 39.555515, 116.71135, 39.554268);
        System.err.println((distance/(30*1000))*60);*/
    }
}
