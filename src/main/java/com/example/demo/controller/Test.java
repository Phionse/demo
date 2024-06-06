package com.example.demo.controller;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test {


    public static void main(String[] args) {
        try {
            System.out.printf(httpGet("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_day.geojson"));
        }catch (Exception e){
        }
    }
    //将map型转为请求参数型
    public static String getUrlData(Map<Object, Object> data) throws Exception{
        StringBuffer sb = new StringBuffer();
        try {
            Set<Map.Entry<Object, Object>> entries = data.entrySet();
            Iterator<Map.Entry<Object, Object>> iterators = entries.iterator();
            while(iterators.hasNext()){
                Map.Entry<Object, Object> next = iterators.next();
                sb.append(next.getKey().toString().trim()).append("=").append(URLEncoder.encode(next.getValue() + "", "UTF-8").trim()).append("&");
            }
            sb.deleteCharAt(sb.length() - 1);
        } catch (Exception e) {
            sb.append(e.toString());
        }
        return sb.toString();
    }

    //strUrl截止到?，例：http://127.0.0.1:8080/api/method?
    public static String httpGet(String strUrl) throws Exception {
        Map<Object, Object> params = new HashMap<Object, Object>();
//        params.put("key1", "value1");
//        params.put("key2", "value2");
        String url=strUrl + getUrlData(params);

        StringBuilder result = new StringBuilder();
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        finally {
            if (in != null){ try { in.close(); }catch(Exception e2){} }
        }
        return result.toString();
    }



}
