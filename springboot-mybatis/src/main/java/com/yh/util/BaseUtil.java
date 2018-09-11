package com.yh.util;

import org.apache.commons.collections.map.HashedMap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by HR on 2018/5/16.
 */
public class BaseUtil {

    public static Map<Integer, String> CHINESE = new LinkedHashMap<>();
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static SimpleDateFormat SIMPLE_FORMAT = new SimpleDateFormat(DATE_FORMAT);


    static {
        CHINESE.put(0, "待定");
        CHINESE.put(1, "一");
        CHINESE.put(2, "二");
        CHINESE.put(3, "三");
        CHINESE.put(4, "四");
        CHINESE.put(5, "五");
        CHINESE.put(6, "六");
        CHINESE.put(7, "七");
        CHINESE.put(8, "八");
        CHINESE.put(9, "九");
        CHINESE.put(10, "十");
        CHINESE.put(11, "十一");
        CHINESE.put(12, "十二");
        CHINESE.put(13, "十三");
        CHINESE.put(14, "十四");
        CHINESE.put(15, "十五");
    }

    /**
     * 中文班级转换
     *
     * @param enrollmentYear
     * @param classNo
     * @return
     */
    public static String classToChinese(Integer enrollmentYear, Integer classNo) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        if (month > 7) {
            //System.out.println(CHINESE.get(year - enrollmentYear + 1) + "年级" + CHINESE.get(classNo) + "班");
            return CHINESE.get(year - enrollmentYear + 1) + "年级" + CHINESE.get(classNo) + "班 Grade "+(year - enrollmentYear +1)+" Class "+ classNo;
        }
        return CHINESE.get(year - enrollmentYear) + "年级" + CHINESE.get(classNo) + "班 Grade "+(year - enrollmentYear)+" Class "+ classNo;
    }

    /**
     * 年级转换
     *
     * @param enrollmentYear
     * @return
     */
    public static Integer gradeToChinese(Integer enrollmentYear) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        //System.out.println("月份："+month);
        if (month > 7) {
            return year - enrollmentYear + 1;
        }
        return year - enrollmentYear;
    }

    public static Date stringToDate(String dateString) throws ParseException {
        return SIMPLE_FORMAT.parse(dateString);
    }

    public static String dateToString(Date date) {
        return SIMPLE_FORMAT.format(date);
    }

    public static Map<String, Integer> YEAR_MONTH_DAY() {

        Calendar calendar = Calendar.getInstance();
        Map<String, Integer> dateMap = new HashedMap();

        dateMap.put("year", calendar.get(Calendar.YEAR));
        dateMap.put("month", calendar.get(Calendar.MONTH) + 1);
        dateMap.put("day", calendar.get(Calendar.DAY_OF_MONTH));
        return dateMap;
    }

    public static Integer YEAR_WEEK(){

        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR) * 100 + calendar.get(Calendar.WEEK_OF_YEAR);
    }

}
