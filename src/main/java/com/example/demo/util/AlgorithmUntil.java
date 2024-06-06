package com.example.demo.util;

import com.example.demo.pojo.DistanceCalculationUnitl;
import com.example.demo.pojo.IntensityAttenuationDto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 烈度衰减算法图
 *
 * @Version 1.0
 */
public class AlgorithmUntil {

    // 1-12 烈度
    private static final List<Integer> list = Arrays.asList(12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1);


    /**
     *
     *
     * @param Ia 烈度
     * @param m  震级
     * @return
     */
    public static double getDa(double Ia, double m) {

        //算法为 Ia = 5.073 + 1.011m - 2.698log(24 + Da),求出Da的值
        double Da = Math.pow(10.0, (5.073 + 1.011 * m - Ia) / 2.698) - 24;
        BigDecimal bd = new BigDecimal(Da);
        return bd.setScale(3, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * 浙江地区烈度算法
     * @param Ib 烈度
     * @param M 震级
     * @return
     */
    public static double getDb(double Ib, double M) {

        //算法为 Ib = 3.789 + 0.942M - 2.156log(9+Db) ,求出Db的值
        double Db = Math.pow(10.0,(3.789 + 0.942 * M - Ib) / 2.156) - 9;
        BigDecimal bd = new BigDecimal(Db);
        return bd.setScale(3, RoundingMode.HALF_UP).doubleValue();
    }



    /**
     *
     *五代区划图算法
     * @param Ia 烈度
     * @param m  震级
     * @return
     */
    public static double getRa(double Ia, double m) {

        //算法为  Ia=5.7123+1.3626M-4.2903lg(R+25), 求出R的值
        double R = Math.pow(10, (Ia - 5.7123 - 1.3626 * m) / (-4.2903)) - 25.0; // 计算 R
        BigDecimal bd = new BigDecimal(R);
        return bd.setScale(3, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     *
     *五代区划图算法
     * @param Ia 烈度
     * @param m  震级
     * @return
     */
    public static double getRb(double Ia, double m) {

        //算法为 Ib=3.6588+1.3626M-3.5406lg(R+13) ,求出R的值
        double R = Math.pow(10, (Ia - 3.6588 - 1.3626 * m) / (-3.5406)) - 13.0;
        BigDecimal bd = new BigDecimal(R);
        return bd.setScale(3, RoundingMode.HALF_UP).doubleValue();
    }



    public static List<IntensityAttenuationDto> getIntensityAttenuationDto(Double m , Integer type){
        List<IntensityAttenuationDto> dtos = new ArrayList<>();
        for (Integer I : list) {
            double da = 0.0;
            double db = 0.0;
            if (type == 1){
                da = getDa(I, m);
                db = getDb(I, m);
            }
            if (type == 2){
                da = getRa(I, m);
                db =getRb(I, m);
            }

            if (da>0 && db>0){
                IntensityAttenuationDto intensityAttenuationDto = new IntensityAttenuationDto();
                intensityAttenuationDto.setM(m);
                intensityAttenuationDto.setDa(da);
                intensityAttenuationDto.setDb(db);
                intensityAttenuationDto.setIntensity(I);
                dtos.add(intensityAttenuationDto);
            }
        }
        return dtos;
    }

    public static void main(String[] args) {
        IntensityAttenuationDto intensityAttenuationDto = getIntensityAttenuationDto(121.74,23.81,120.21,
                30.24,7.3,2);
        System.out.println(intensityAttenuationDto);
    }


    /**
     *
     * @param lon1 经度
     * @param lat1 纬度
     * @param lon2 经度
     * @param lat2 纬度
     * @param m 震级
     * @param type 类型 :1.杭州 7 2.五代图  8
     */
    public static IntensityAttenuationDto getIntensityAttenuationDto(double lon1,double lat1,double lon2,double lat2,double m,Integer type){
        IntensityAttenuationDto dto = new IntensityAttenuationDto();
        double distance = DistanceCalculationUnitl.getDistance(lon1, lat1, lon2, lat2);
        List<IntensityAttenuationDto> intensityAttenuationDto = getIntensityAttenuationDto(m,type);
        for (IntensityAttenuationDto attenuationDto : intensityAttenuationDto) {
            if (distance<= attenuationDto.getDb() || (distance>= attenuationDto.getDb() && distance<= attenuationDto.getDa())){
                dto = attenuationDto;
                dto.setDistance(distance);
                break;
            }
        }
        return dto;
    }
    /**
     *
     * @param lon2 经度
     * @param lat2 纬度
     * @param type 类型 :1.杭州 7 2.五代图  8
     * @return
     */
    public static IntensityAttenuationDto getIntensityAttenuationDto(double lon2,double lat2,Integer type){
        IntensityAttenuationDto dto = new IntensityAttenuationDto();
        double distance = DistanceCalculationUnitl.getDistance(121.74, 23.81, lon2, lat2);
        List<IntensityAttenuationDto> intensityAttenuationDto = getIntensityAttenuationDto(7.3,type);
        for (IntensityAttenuationDto attenuationDto : intensityAttenuationDto) {
            if (distance<= attenuationDto.getDb() || (distance>= attenuationDto.getDb() && distance<= attenuationDto.getDa())){
                dto = attenuationDto;
                dto.setDistance(distance);
                break;
            }
        }
        return dto;
    }

    public static IntensityAttenuationDto getIntensityAttenuationByDisDto(double m, double distance,Integer type){
        IntensityAttenuationDto dto = new IntensityAttenuationDto();
        List<IntensityAttenuationDto> intensityAttenuationDto = getIntensityAttenuationDto(m,type);
        for (IntensityAttenuationDto attenuationDto : intensityAttenuationDto) {
            if (distance<= attenuationDto.getDb() || (distance>= attenuationDto.getDb() && distance<= attenuationDto.getDa())){
                dto = attenuationDto;
                break;
            }
        }
        return dto;
    }




}
