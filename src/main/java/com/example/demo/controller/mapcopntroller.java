package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * @ClassName:mapcopntroller
 * @Auther: MR.ma
 */
public class mapcopntroller {

    /**
     * @Author: yansf
     * @Description:根据经纬度获取地址
     * @Date:Creat in 20:20 2019/12/11
     * @Modified By:
     */
       static   String secretKey = "ED7BZ-JU2O5-7AZIO-Q3Y24-NO4JT-MCB6H";

        /**
         * @param lat 纬度
         * @param lng 经度
         * @return
         */
        public static String getAddress(String lat, String lng) throws IOException {
            JSONObject obj = getLocationInfo(lat, lng).getJSONObject("result");
            System.out.println(obj);
//             JsonUtil.fromJson(obj.toString(), Result.class);
            return obj.toJSONString();
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
            String res = "";
            while ((line = in.readLine()) != null) {
                res += line + "\n";
            }
            in.close();
            JSONObject jsonObject = JSONObject.parseObject(res);
            return jsonObject;
        }


        public static void main(String[] args) throws IOException {
            System.out.println(getAddress("24.08", "122.389999"));
        }

    }
