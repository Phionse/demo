package com.example.demo.util;

import com.alibaba.fastjson.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class AddressUntils {
        static String secretKey = "ED7BZ-JU2O5-7AZIO-Q3Y24-NO4JT-MCB6H";

        /**
         * @param lat 纬度
         * @param lng 经度
         * @return
         */
        public static JSONObject getAddress(String lat, String lng) throws IOException {
            JSONObject obj = getLocationInfo(lat, lng).getJSONObject("result");
            return obj;
        }


        public static JSONObject getLocationInfo(String lat, String lng) throws IOException {
            String urlString = "https://apis.map.qq.com/ws/geocoder/v1/?location=" + lat + "," + lng + "&key=" + secretKey;
            System.out.println("请求经纬度url:" + urlString);
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            StringBuilder res = new StringBuilder();

            while ((line = in.readLine()) != null) {
                res.append(line).append("\n");
            }
            in.close();
            return JSONObject.parseObject(res.toString());
        }


        public static void main(String[] args) throws IOException {
            System.out.println(getAddress("30.2084", "120.21201"));
            System.out.println("结束");
        }

}