package com.example.demo.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MonthDifferenceCalculator {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2023, 8, 1); // 第一个日期
        LocalDate date2 = LocalDate.of(2024, 3, 1); // 第二个日期

        long monthsDifference = calculateMonthsDifference(date1, date2);
        long remainingDays = calculateRemainingDays(date1, date2);
        System.out.println("相差 " + monthsDifference + " 个月 " + remainingDays + " 天");
    }

    public static long calculateMonthsDifference(LocalDate date1, LocalDate date2) {
        long monthsDifference = ChronoUnit.MONTHS.between(date1, date2);
        LocalDate tempDate = date1.plusMonths(monthsDifference);
        if (date2.isAfter(tempDate)) {
            if (date2.getDayOfMonth() >= date1.getDayOfMonth()) {
                monthsDifference++;
            }
        }
        return monthsDifference;
    }

    public static long calculateRemainingDays(LocalDate date1, LocalDate date2) {
        long daysDifference = ChronoUnit.DAYS.between(date1, date2);
        long remainingDays = daysDifference - calculateMonthsDifference(date1, date2) * date1.lengthOfMonth();
        return remainingDays < 0 ? 0 : remainingDays;
    }
}
