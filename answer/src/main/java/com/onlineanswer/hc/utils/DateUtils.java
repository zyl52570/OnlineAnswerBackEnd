package com.onlineanswer.hc.utils;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期处理
 * 
 */
public class DateUtils {
    /** 时间格式(yyyy-MM-dd) */
    public final static String DATE_PATTERN = "yyyy-MM-dd";
    /** 时间格式(yyyy-MM-dd HH:mm:ss) */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    /*上传文件名*/
    public final static String FULL_DATE_TIME = "YYYYMMddHHmmssSSS";
    /** 时间格式(yyyyMMddHHmmss) */
    public static final String DATE_TIME_FORMAT_ALL = "yyyyMMddHHmmss";
    /**时间格式（HH:mm:ss）*/
    public final static String DATE_HOUR_PATTERN = "HH:mm:ss";

    /**
     * 日期格式化 日期格式为：yyyy-MM-dd
     * @param date  日期
     * @return  返回yyyy-MM-dd格式日期
     */
    public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    /**
     * 日期格式化 日期格式为：yyyy-MM-dd
     * @param date  日期
     * @param pattern  格式，如：DateUtils.DATE_TIME_PATTERN
     * @return  返回yyyy-MM-dd格式日期
     */
    public static String format(Date date, String pattern) {
        if(date != null){
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }

    /**
     * 字符串转换成日期
     * @param strDate 日期字符串
     * @param pattern 日期的格式，如：DateUtils.DATE_TIME_PATTERN
     */
    public static Date stringToDate(String strDate, String pattern) {
        if (StringUtils.isBlank(strDate)){
            return null;
        }

        DateTimeFormatter fmt = DateTimeFormat.forPattern(pattern);
        return fmt.parseLocalDateTime(strDate).toDate();
    }

    /**
     * 根据周数，获取开始日期、结束日期
     * @param week  周期  0本周，-1上周，-2上上周，1下周，2下下周
     * @return  返回date[0]开始日期、date[1]结束日期
     */
    public static Date[] getWeekStartAndEnd(int week) {
        DateTime dateTime = new DateTime();
        LocalDate date = new LocalDate(dateTime.plusWeeks(week));

        date = date.dayOfWeek().withMinimumValue();
        Date beginDate = date.toDate();
        Date endDate = date.plusDays(6).toDate();
        return new Date[]{beginDate, endDate};
    }

    /**
     * 对日期的【秒】进行加/减
     *
     * @param date 日期
     * @param seconds 秒数，负数为减
     * @return 加/减几秒后的日期
     */
    public static Date addDateSeconds(Date date, int seconds) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusSeconds(seconds).toDate();
    }

    /**
     * 对日期的【分钟】进行加/减
     *
     * @param date 日期
     * @param minutes 分钟数，负数为减
     * @return 加/减几分钟后的日期
     */
    public static Date addDateMinutes(Date date, int minutes) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusMinutes(minutes).toDate();
    }

    /**
     * 对日期的【小时】进行加/减
     *
     * @param date 日期
     * @param hours 小时数，负数为减
     * @return 加/减几小时后的日期
     */
    public static Date addDateHours(Date date, int hours) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusHours(hours).toDate();
    }

    /**
     * 对日期的【天】进行加/减
     *
     * @param date 日期
     * @param days 天数，负数为减
     * @return 加/减几天后的日期
     */
    public static Date addDateDays(Date date, int days) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusDays(days).toDate();
    }

    /**
     * 对日期的【周】进行加/减
     *
     * @param date 日期
     * @param weeks 周数，负数为减
     * @return 加/减几周后的日期
     */
    public static Date addDateWeeks(Date date, int weeks) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusWeeks(weeks).toDate();
    }

    /**
     * 对日期的【月】进行加/减
     *
     * @param date 日期
     * @param months 月数，负数为减
     * @return 加/减几月后的日期
     */
    public static Date addDateMonths(Date date, int months) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusMonths(months).toDate();
    }

    /**
     * 对日期的【年】进行加/减
     *
     * @param date 日期
     * @param years 年数，负数为减
     * @return 加/减几年后的日期
     */
    public static Date addDateYears(Date date, int years) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusYears(years).toDate();
    }

    // add by xuyq 20180915
    /**
     * 得到数据库系统时间Date类型
     */
    public static Date getCurrentDate() {
        return new Date();
    }
    /**
     * 上传文件，命名
     */
    public static String getDateTime(){
        DateTime  dt = new DateTime(new Date());
        return dt.toString(FULL_DATE_TIME);
    }

    /**
     * 获取两个日期之间的所有日期（包含起始日期）
     * @param minDate
     * @param maxDate
     * @return
     */
    public static List<String> getDaysBetweenDateStr(String minDate, String maxDate) throws ParseException {
        List<String> listDate = new ArrayList<String>();
        if(minDate.equals(maxDate)){
            listDate.add(minDate);
            return listDate;
        }
        listDate.add(minDate);
        Calendar startCalendar = Calendar.getInstance();
        Calendar endCalendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = df.parse(minDate);
        startCalendar.setTime(startDate);
        Date endDate = df.parse(maxDate);
        endCalendar.setTime(endDate);
        while(true){
            startCalendar.add(Calendar.DAY_OF_MONTH, 1);
            if(startCalendar.getTimeInMillis() < endCalendar.getTimeInMillis()){
                listDate.add(df.format(startCalendar.getTime()));
            }else{
                break;
            }
        }
        listDate.add(maxDate);
        return listDate;
    }

    /**
     * 日期转星期
     *
     * @param datetime
     * @return
     */
    public static String dateToWeek(String datetime) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        Date datet = null;
        try {
            datet = f.parse(datetime);
            cal.setTime(datet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    /**
     * 时间戳转换成日期格式字符串
     * @param seconds 精确到秒的字符串
     * @param format
     * @return
     */
    public static String timeStamp2Date(String seconds,String format) {
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){
            return "";
        }
        if(format == null || format.isEmpty()) format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds)));
    }

    /**
     * 获取某月最后一日
     * @param date
     * @return
     */
    public static String getLastDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DATE));
        return  new   SimpleDateFormat( DATE_PATTERN).format(cal.getTime());
    }

    /**
     * 获取某月第一日
     * @param date
     * @return
     */
    public static String getFirstDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH,cal.getMinimum(Calendar.DATE));
        return   new SimpleDateFormat( DATE_PATTERN).format(cal.getTime());
    }

    /**
     * 获取当年的最后一天
     * @param year
     * @return
     */
    public static Date getCurrYearLast(){
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        return getYearLast(currentYear);
    }
    /**
        * 获取某年最后一天日期
        * @param year 年份
        * @return Date
       */
    public static Date getYearLast(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR,year);
        calendar.roll(Calendar.DAY_OF_YEAR,-1);
        Date currYearList = calendar.getTime();
        return currYearList;
    }

    public static void main(String args[]){
        System.out.println(timeStamp2Date("153832320",DATE_PATTERN));
    }
}
