package com.example.demo.pojo;


import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 *
 * @Author zsf
 * @Date 2023-5-25 9:57
 * @Version 1.0
 */
public class DistanceCalculationUnitl {
    /**
     * 地球半径，单位m
     */
    private static final double EARTH_RADIUS = 6378137;

    /**
     * 根据经纬度，计算两点间的距离
     *
     * @param longitude1 第一个点的经度
     * @param latitude1  第一个点的纬度
     * @param longitude2 第二个点的经度
     * @param latitude2  第二个点的纬度
     * @return 返回距离，单位m
     */
    public static double getDistance(double longitude1, double latitude1, double longitude2, double latitude2) {
        // 纬度
        double lat1 = Math.toRadians(latitude1);
        double lat2 = Math.toRadians(latitude2);
        // 经度
        double lng1 = Math.toRadians(longitude1);
        double lng2 = Math.toRadians(longitude2);
        // 纬度之差
        double a = lat1 - lat2;
        // 经度之差
        double b = lng1 - lng2;
        // 计算两点距离的公式
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) +
                Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(b / 2), 2)));
        // 弧长乘地球半径, 返回单位: 米
        s =  s * EARTH_RADIUS;

        //保留小数点后两位
        BigDecimal bd = new BigDecimal(s/1000);
        double result = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return result;
    }


    // 计算百分比并保留指定小数位数
    public static double calculatePercentageWithDecimal(int numerator, int denominator, int decimalPlaces) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        double percentage = ((double) numerator / denominator) * 100;
        // 使用 StringUtils.repeat() 方法重复字符串
        DecimalFormat df = new DecimalFormat("#." + StringUtils.repeat("0", decimalPlaces));
        return Double.parseDouble(df.format(percentage));
    }

}
