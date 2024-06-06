package com.example.demo.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
 
import java.time.LocalDate;
import java.time.Period;
 
@Slf4j
public class dateUtils {
 
    /**
     * 计算两个日期相差 多少年、多少月、多少日
     */
    @Test
    public void getYMD(){
        String srcDate = "2024-02-01";
        String nowDate = "2024-03-01";
 
        Period period = Period.between(LocalDate.parse(srcDate), LocalDate.parse(nowDate));

        String sb = period.getYears() + "年" +
                period.getMonths() + "月" +
                period.getDays() + "日";
        log.info("相差: {}", sb);
    }
}