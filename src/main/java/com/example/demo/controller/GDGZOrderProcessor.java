package com.example.demo.controller;

import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

public class GDGZOrderProcessor {
    private static final String url = "http://10.33.253.142:8080/jopens-sss/sss/retr;staList=ZJ.HL|ZJ.BY;chanMask=0x00400710";
    private static final String urlLogin = "http://10.33.253.142:8080/jopens-sss/sss/login;user=root;pass=rootme";
    private static final RestTemplate restTemplate = new RestTemplate();
    public static String processorStream(String url, String param) {
        System.out.println("========");
        PrintWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        try {
            URL realUrl = new URL(url);
// 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
// 设置通用的请求属性
            conn.setRequestProperty("cookie","ss");
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
// conn.setRequestProperty("user-agent",
// "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
    // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
    // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
    // 发送请求参数
            out.print(param);
    // flush输出流的缓冲
            out.flush();
    // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
//使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
//        GDGZOrderProcessor.processorStream( );
    }

}