package org.hglteam.service.holiday.control.easter;

import java.time.LocalDate;
import java.time.Month;

public class GaussAlgorithmEasterCalculator implements EasterCalculator {
    @Override
    public LocalDate forYear(Integer year) {
//        var a = year % 19;
//        var b = year % 4;
//        var c = year % 7;
//        var k = year / 100;
//        var p = (13 + (8 * k)) / 25;
//        var q = k / 4;
//        var M = 15 - p + k -q;
//        var N = 4 + k - q;
//        var d = (19 * a) + M;
//        var e = (2 * b) + (4 * c) + (6 * d) + (N % 7);
//
//        if(d + e < 10) {
//            // March
//            return LocalDate.of(year, Month.MARCH, d + e + 22);
//        } else {
//            var day = d + e - 9;
//
//            if(day >= 26) {
//                day = 19;
//            } else if (day == 25 && d == 28 && e == 6 && a > 10) {
//                day = 18;
//            }
//
//            return LocalDate.of(year, Month.MARCH, day);
//        }

        int a = year % 19,
                b = year / 100,
                c = year % 100,
                d = b / 4,
                e = b % 4,
                g = (8 * b + 13) / 25,
                h = (19 * a + b - d - g + 15) % 30,
                j = c / 4,
                k = c % 4,
                m = (a + 11 * h) / 319,
                r = (2 * e + 2 * j - k - h + m + 32) % 7,
                n = (h - m + r + 90) / 25,
                p = (h - m + r + n + 19) % 32;

        return LocalDate.of(year, n, p);
    }
}
