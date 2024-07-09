package com.example.demo.util;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class AddressUntilsTwo {




        public static JSONObject getLocationInfo(String lat, String lng) throws IOException {
            String urlString = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_day.geojson";
            System.out.println("请求url:" + urlString);
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            String line;
            StringBuilder res = new StringBuilder();

            while ((line = in.readLine()) != null) {
                res.append(line).append("\n");
            }
            in.close();
            return JSONObject.parseObject(res.toString());
        }





        public static void main(String[] args) throws IOException {
            System.out.println(getLocationInfo("30.2084", "120.21201"));
            System.out.println("结束");
        }

}