//package com.example.demo.controller;
//
//import org.gdal.gdal.gdal;
//import org.gdal.ogr.*;
//import org.gdal.osr.SpatialReference;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @Author zsf
// * @Date 2022-11-9 14:00
// * @Version 1.0
// */
//public class shpController {
//    public static void main(String[] args) {
//
//        // 指定文件的名字和路径
//        String strVectorFile = "/Users/mr.ma/Downloads/项目文档/地震项目/对接文件/地震数据示例/杭州市房屋抗震能力判别（局部）/浙江省杭州市房屋抗震能力分区.shp";
//// 注册所有的驱动
//        ogr.RegisterAll();
//// 为了支持中文路径，请添加下面这句代码
//        gdal.SetConfigOption("GDAL_FILENAME_IS_UTF8", "YES");
//// 为了使属性表字段支持中文，请添加下面这句
//        gdal.SetConfigOption("SHAPE_ENCODING", "CP936");
//
//        // 读取数据，这里以ESRI的shp文件为例
//        String strDriverName = "ESRI Shapefile";
//// 创建一个文件，根据strDriverName扩展名自动判断驱动类型
//
//        org.gdal.ogr.Driver oDriver = ogr.GetDriverByName(strDriverName);
//
//        if (oDriver == null) {
//            System.out.println(strDriverName + " 驱动不可用！\n");
//            return;
//        }
//        DataSource dataSource = oDriver.Open(strVectorFile);
//        //Layer layer = dataSource.GetLayer("test");
//        Layer layer = dataSource.GetLayer(0);
//
//        for(int i = 0;i<dataSource.GetLayerCount();i++) {
//            Layer layerIdx = dataSource.GetLayer(i);
//            System.out.println("图层名称：<==>" + layerIdx.GetName());
//        }
//
//        String layerName = layer.GetName();
//        System.out.println("图层名称：" + layerName);
//        SpatialReference spatialReference = layer.GetSpatialRef();
//       //System.out.println(spatialReference);
//        System.out.println("空间参考坐标系：" + spatialReference.GetAttrValue("AUTHORITY", 0)
//                + spatialReference.GetAttrValue("AUTHORITY", 1));
//
//        double[] layerExtent = layer.GetExtent();
//
//        System.out.println("图层范围：minx:" + layerExtent[0] + ",maxx:" + layerExtent[1] + ",miny:" + layerExtent[2] + ",maxy:" + layerExtent[3]);
//
//        FeatureDefn featureDefn = layer.GetLayerDefn();
//
//        int fieldCount = featureDefn.GetFieldCount();
//
//        Map<String,String> fieldMap = new HashMap<String,String>();
//        for (int i = 0; i < fieldCount; i++) {
//            FieldDefn fieldDefn = featureDefn.GetFieldDefn(i);
//            // 得到属性字段类型
//            int fieldType = fieldDefn.GetFieldType();
//            String fieldTypeName = fieldDefn.GetFieldTypeName(fieldType);
//            // 得到属性字段名称
//            String fieldName = fieldDefn.GetName();
//            fieldMap.put(fieldTypeName, fieldName);
//        }
//
//        System.out.println(fieldMap);
//        System.out.println(layer.GetFeature(1).GetGeometryRef().ExportToJson());
//        System.out.println(layer.GetFeature(2).GetGeometryRef().ExportToJson());
//        System.out.println(layer.GetFeature(3).GetGeometryRef().ExportToJson());
//
////        for (int i = 0; i < featureCount; i++) {
////            Feature feature = layer.GetFeature(i);
////            Object[] arr = fieldMap.values().toArray();
////            for (int k = 0; k < arr.length; k++) {
////                String fvalue = feature.GetFieldAsString(arr[k].toString());
////                System.out.println(" 属性名称:" + arr[k].toString() + ",属性值:" + fvalue);
////            }
////        }
//
//
//    }
//
//
//}
