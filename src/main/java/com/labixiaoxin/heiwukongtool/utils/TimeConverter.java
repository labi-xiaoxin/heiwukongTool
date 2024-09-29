package com.labixiaoxin.heiwukongtool.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author admin
 */
public class TimeConverter {
    /**
     * 将当前时间戳转换为指定格式的日期字符串
     * @return 格式化的日期字符串，如202409271546
     */
    public static String convertTimestampToDate() {
        // 获取当前时间戳
        long timestamp = System.currentTimeMillis();

        // 将时间戳转换为 LocalDateTime
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());

        // 定义格式化的日期格式：yyyyMMddHHmm
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

        // 返回格式化后的日期字符串
        return dateTime.format(formatter);
    }

}
