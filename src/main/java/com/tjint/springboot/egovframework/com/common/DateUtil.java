package com.tjint.springboot.egovframework.com.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String getSysDate() {
        return getSysDate("yyyyMMdd");
    }

    public static String getSysDate(String pattern) {
        return getDateString(new Date(), pattern);
    }

    public static String getDateString(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static String getDateString(long time, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date d = new Date(time);
        return sdf.format(d);
    }
}
