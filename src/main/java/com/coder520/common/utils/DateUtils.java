package com.coder520.common.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author : Hellxz
 * @Description: 时间处理工具类
 * @Date : 2018/3/8 8:52
 */
public class DateUtils {

    //日期对象
    private static Calendar calendar = Calendar.getInstance();
    /**
     * @Author: Hellxz
     * @Description: 获取指定时间的Date对象
     * @Date: 2018/3/8 8:54
     */
    public static Date getDate(int hour, int minute){
        calendar.set(Calendar.HOUR_OF_DAY,hour);
        calendar.set(Calendar.MINUTE,minute);
        return calendar.getTime();
    }

    /**
     * @Author: Hellxz
     * @Description: 获取当前日期的星期数
     * @Date: 2018/3/8 9:11
     */
    public static int getWeek(){
        //国外以星期日作为每周的第一天也就是0，中国以星期一为第一天，周日为第七天
        int week = calendar.get(Calendar.DAY_OF_WEEK)-1;
        if(week<=0) week = 7; //周日的情况
        return week;
    }

    /**
     * @Author: Hellxz
     * @Description: 返回两个时间中相差的分钟数
     * @Date: 2018/3/8 9:17
     */
    public static int getMinute(Date startDate, Date endDate){
        long startTime = startDate.getTime();
        long endTime = endDate.getTime();
        //换算成分钟，取绝对值，防止两个时间写反出现负数
        return Math.abs((int)(endTime - startTime)/(1000*60));

    }

}
