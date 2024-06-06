package com.example.demo.demo;

public class MyLocationUtils {
    private static final double EARTH_RADIUS = 6378.137D;

    public MyLocationUtils() {
    }

    private static double getRadian(double d) {
        return d * 3.141592653589793D / 180.0D;
    }

    public static double getDistance(double lat1, double lng1, double lat2, double lng2) {
        double radLat1 = getRadian(lat1);
        double radLat2 = getRadian(lat2);
        double a = radLat1 - radLat2;
        double b = getRadian(lng1) - getRadian(lng2);
        double s = 2.0D * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2.0D), 2.0D)
                + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2.0D), 2.0D)));
        s *= 6378.137D;
        s = (double) Math.round(s * 10000.0D) / 10000.0D;
        s *= 1000.0D;
        return s;
    }

    public static boolean outOfChina(double lng, double lat) {
        if (lng >= 72.004D && lng <= 137.8347D) {
            return lat < 0.8293D || lat > 55.8271D;
        } else {
            return true;
        }
    }

    public static boolean outOfEarth(double lng, double lat) {
        if (lng > 0.0D && lng < 180.0D) {
            return lat <= 0.0D || lat >= 90.0D;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        double distance = getDistance(116.34, 37.16, 119.99821, 30.5425);
        System.out.println("距离" + distance + "米");
    }
}