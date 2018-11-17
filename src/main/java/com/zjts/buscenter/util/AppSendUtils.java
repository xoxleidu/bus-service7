/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zs
 * Date: 2018-11-14
 * Time: 11:18
 */
package com.zjts.buscenter.util;

import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 调用百度地图接口 转换坐标
 *  lat 维度 例如 ：39.547764
 *  lon 经度 例如 ：116.684494
 *
 */

public class AppSendUtils {
    private static final Logger Log = Logger.getLogger(AppSendUtils.class);

    public static JSONObject connectURL(double lon, double lat, String commString) {
        String coords = lon+","+lat;
        String dest_url = "http://api.map.baidu.com/geoconv/v1/?coords="+coords+"&from=1&to=5&output=json&ak=EiuobblspxsKE1I3PNhkbyeITvNSg4NW";
        String rec_string = "";
        URL url = null;
        HttpURLConnection urlconn = null;
        OutputStream out = null;
        BufferedReader rd = null;
        try {
            url = new URL(dest_url);
            urlconn = (HttpURLConnection) url.openConnection();
            urlconn.setReadTimeout(1000 * 30);
            //urlconn.setRequestProperty("content-type", "text/html;charset=UTF-8");
            urlconn.setRequestMethod("POST");
            urlconn.setDoInput(true);
            urlconn.setDoOutput(true);
            out = urlconn.getOutputStream();
            out.write(commString.getBytes("UTF-8"));
            out.flush();
            out.close();
            rd = new BufferedReader(new InputStreamReader(urlconn.getInputStream()));
            StringBuffer sb = new StringBuffer();
            int ch;
            while ((ch = rd.read()) > -1)
                sb.append((char) ch);
            rec_string = sb.toString();
        } catch (Exception e) {
            Log.error(e, e);
            return JSONObject.fromObject("");
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (urlconn != null) {
                    urlconn.disconnect();
                }
                if (rd != null) {
                    rd.close();
                }
            } catch (Exception e) {
                Log.error(e, e);
            }
        }
        JSONObject jsStr = JSONObject.fromObject(rec_string);
        String s = jsStr.get("result").toString();
        String replace = s.replace("[{", "");
        String replace1 = replace.replace("}]", "");
        String[] split = replace1.split(",");
        lon = Double.parseDouble(split[0].split(":")[1]);
        lat = Double.parseDouble(split[1].split(":")[1]);
        jsStr.put("x",lon);
        jsStr.put("y",lat);
        return jsStr;
    }

    public static void main(String[] args) {
        JSONObject jsonObject = connectURL( 116.684494,39.547764, "");
        System.err.println(jsonObject.get("x")+"`````"+jsonObject.get("y"));

    }
}
