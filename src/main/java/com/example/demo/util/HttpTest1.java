package com.example.demo.util;

import lombok.extern.slf4j.Slf4j;
import org.geotools.geojson.feature.FeatureJSON;
import org.geotools.kml.KMLConfiguration;
import org.geotools.xsd.PullParser;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;

import java.io.*;
import java.nio.file.Files;
import java.util.Objects;

@Slf4j
public class HttpTest1 {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Files.newInputStream(new File("/Users/mr.ma/Downloads/test/川气东送二线浙江段.kml").toPath());
        System.out.printf(Objects.requireNonNull(kml2Geojson(inputStream)));
    }

    /**
     * kml转换为geojson
     *
     * @param input 输入
     * @return {@link StringWriter}
     * @throws IOException ioexception
     */
//    public static String kml2Geojson(InputStreamReader input) throws IOException {
    public static String kml2Geojson(InputStream input) throws IOException {
        try {
            File file = new File("/Users/mr.ma/Downloads/test/川气东送二线浙江段.kml");
            InputStream inputStream = Files.newInputStream(file.toPath());
            PullParser parser = new PullParser(new KMLConfiguration(), inputStream, SimpleFeature.class);
            FeatureJSON fjson = new FeatureJSON();
            StringWriter sw = new StringWriter();

            SimpleFeature simpleFeature = (SimpleFeature) parser.parse();
            sw.append("{    \"type\": \"FeatureCollection\",    \"features\": [");
            while (simpleFeature != null) {
                SimpleFeatureType featureType = simpleFeature.getFeatureType();
                fjson.setFeatureType(featureType);
                fjson.writeFeature(simpleFeature, sw);
                simpleFeature = (SimpleFeature) parser.parse();
                if (simpleFeature != null) {
                    sw.append(",");
                }
            }
            sw.append("]}");
            sw.close();
            return sw.toString();
        } catch (Exception e) {
            log.error("KML 文件解析报错：{}", e.getMessage());
            return null;
        } finally {
            Objects.requireNonNull(input,"KML 文件输入流为空").close();
        }
    }


}