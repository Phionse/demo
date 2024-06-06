//package com.example.demo.controller;
//
//import org.osgeo.proj4j.*;
//
//public class CoordinateTransformExample {
//    public static void main(String[] args) {
//        // 创建一个CoordinateTransformFactory实例
//        CoordinateTransformFactory ctFactory = new CoordinateTransformFactory();
//
//        // 定义源坐标系为WGS84 (EPSG:4326)
//        CoordinateReferenceSystem sourceCRS = ctFactory.createTransform("EPSG:4326");
//
//        // 定义目标坐标系为Web Mercator (EPSG:3857)
//        CoordinateReferenceSystem targetCRS = ctFactory.createTransform("EPSG:3857");
//
//        // 创建一个CoordinateTransform对象
//        CoordinateTransform transform = ctFactory.createTransform(sourceCRS, targetCRS);
//
//        // 定义要转换的点的坐标（经度和纬度）
//        double longitude = 126.1261
//        double latitude = 7.1859;
//
//        // 创建一个源坐标对象
//        ProjCoordinate srcCoord = new ProjCoordinate(longitude, latitude);
//
//        // 创建一个目标坐标对象
//        ProjCoordinate targetCoord = new ProjCoordinate();
//
//        // 执行坐标系转换
//        transform.transform(srcCoord, targetCoord);
//
//        // 输出转换后的目标坐标（平面坐标）
//        System.out.println("转换后的坐标：");
//        System.out.println("X坐标：" + targetCoord.x);
//        System.out.println("Y坐标：" + targetCoord.y);
//    }
//}