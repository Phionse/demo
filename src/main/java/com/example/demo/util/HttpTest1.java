//package com.example.demo.util;
//
//import lombok.extern.slf4j.Slf4j;
//import org.geotools.data.DataStore;
//import org.geotools.data.DataStoreFinder;
//import org.geotools.data.Query;
//import org.geotools.data.shapefile.ShapefileDataStore;
//import org.geotools.data.simple.SimpleFeatureSource;
//import org.geotools.feature.FeatureCollection;
//import org.geotools.feature.FeatureIterator;
//import org.geotools.geojson.feature.FeatureJSON;
//import org.geotools.kml.KMLConfiguration;
//import org.geotools.xsd.PullParser;
//import org.opengis.feature.Property;
//import org.opengis.feature.simple.SimpleFeature;
//import org.opengis.feature.simple.SimpleFeatureType;
//import org.opengis.referencing.ReferenceIdentifier;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.*;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Objects;
//
//@Slf4j
//public class HttpTest1 {
//
//    public static void main(String[] args) throws Exception {
////        InputStream inputStream = Files.newInputStream(new File("/Users/mr.ma/Downloads/test/川气东送二线浙江段.kml").toPath());
////        System.out.printf(Objects.requireNonNull(kml2Geojson(inputStream)));
////        getShapeFile(new File("/Users/mr.ma/Downloads/A版中线/A版中线shp格式2024.07.04/A版中线2024.06.28_track.shp"));
//    }
//
//    /**
//     * kml转换为geojson
//     *
//     * @param input 输入
//     * @return {@link StringWriter}
//     * @throws IOException ioexception
//     */
////    public static String kml2Geojson(InputStreamReader input) throws IOException {
//    public static String kml2Geojson(InputStream input) throws IOException {
//        try {
//            File file = new File("/Users/mr.ma/Downloads/test/川气东送二线浙江段.kml");
//            InputStream inputStream = Files.newInputStream(file.toPath());
//            PullParser parser = new PullParser(new KMLConfiguration(), inputStream, SimpleFeature.class);
//            FeatureJSON fjson = new FeatureJSON();
//            StringWriter sw = new StringWriter();
//
//            SimpleFeature simpleFeature = (SimpleFeature) parser.parse();
//            sw.append("{    \"type\": \"FeatureCollection\",    \"features\": [");
//            while (simpleFeature != null) {
//                SimpleFeatureType featureType = simpleFeature.getFeatureType();
//                fjson.setFeatureType(featureType);
//                fjson.writeFeature(simpleFeature, sw);
//                simpleFeature = (SimpleFeature) parser.parse();
//                if (simpleFeature != null) {
//                    sw.append(",");
//                }
//            }
//            sw.append("]}");
//            sw.close();
//            return sw.toString();
//        } catch (Exception e) {
//            log.error("KML 文件解析报错：{}", e.getMessage());
//            return null;
//        } finally {
//            Objects.requireNonNull(input,"KML 文件输入流为空").close();
//        }
//    }
//
//
//
//    public static String  getShapeFile(File file) {
//        try {
//        Map<String, Object> map = new HashMap<>(1);
//        map.put("url", file.toURI().toURL());
//        DataStore dataStore = DataStoreFinder.getDataStore(map);
//        //字符转码，防止中文乱码
//        ShapefileDataStore shpStore = (ShapefileDataStore) dataStore;
//        shpStore.setCharset(StandardCharsets.UTF_8);
//        //获取shp文件坐标系
//        SimpleFeatureSource source = shpStore.getFeatureSource();
//        SimpleFeatureType schema = source.getSchema();
//        Query query = new Query(schema.getTypeName());
//        FeatureCollection<SimpleFeatureType, SimpleFeature> collection = source.getFeatures(query);
//        SimpleFeature feature = null;
//        //获取shp文件所有的地块
//        try (FeatureIterator<SimpleFeature> features = collection.features()) {
//            while (features.hasNext()) {
//                 feature = features.next();
//                String name = feature.getName().toString();
//                log.info("地块名称=【{}】", name);
//
//                //坐标系的名称
//                ReferenceIdentifier referenceIdentifier = feature.getFeatureType().getCoordinateReferenceSystem().getCoordinateSystem().getName();
//                String code = referenceIdentifier.getCode();
//                log.info("地块坐标系=【{}】", code);
//                log.info("geojson值"+feature.getAttribute("the_geom").toString());
//                //获取shp文件的属性信息
//                for (Property property : feature.getValue()) {
//                    log.info("地块属性名【{}】 地块属性值【{}】", property.getName(), property.getValue());
//                }
//            }
//            assert feature != null;
//            return feature.getAttribute("the_geom").toString();
//        }
//        }catch (Exception e) {
//        log.error(e.getMessage(), e);
//        }
//        return null;
//    }
//
//    public static File transferToFile(MultipartFile multipartFile) {
////        选择用缓冲区来实现这个转换即使用java 创建的临时文件 使用 MultipartFile.transferto()方法 。
//        File file = null;
//        try {
//            String originalFilename = multipartFile.getOriginalFilename();
//            assert originalFilename != null;
//            String[] filename = originalFilename.split("\\.");
//            file=File.createTempFile(filename[0], filename[1]);
//            multipartFile.transferTo(file);
//            file.deleteOnExit();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return file;
//    }
//
//
//
//}