package cn.ting.worktable.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HolidayUtils {


    /**
     * 节假日工作时间处理
     * 假日只处理今年的  1.1、5.1、10.1，和周末
     */


    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static List<String> holidays = new ArrayList<String>();
    private static List<String> workdays = new ArrayList<String>();

    /**
     * 静态块初始化法定节日
     */
    static {
        Calendar c = Calendar.getInstance();
        holidays.add(c.get(Calendar.YEAR) + "-09-13");
        holidays.add(c.get(Calendar.YEAR) + "-10-04");
        holidays.add(c.get(Calendar.YEAR) + "-10-05");
        holidays.add(c.get(Calendar.YEAR) + "-10-06");
        holidays.add(c.get(Calendar.YEAR) + "-10-07");
        holidays.add(c.get(Calendar.YEAR) + 1 + "-01-01");
        workdays.add(c.get(Calendar.YEAR) + "-10-12");
        workdays.add(c.get(Calendar.YEAR) + "-09-29");
    }

    /**
     * 判断当天是否是节假日 节日只包含1.1；5.1；10.1
     *
     * @param date 时间
     * @return 非工作时间：true;工作时间：false
     */
    public static boolean isHolidayOrFestival(Date date) {
        boolean result = false;
        boolean isHolidayTmp = isHoliday(date);
        if (isHolidayTmp) {
            result = true;
        } else {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            //白名单工作日
            if (isWorkday(date)) {
                return false;
            }
            //周末直接为非工作时间
            if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                result = true;
            }
        }
        return result;
    }

    /**
     * 根据判断当前时间是否是节日
     *
     * @param date 时间
     * @return
     */
    private static boolean isHoliday(Date date) {
        boolean result = false;
        String dateStr = sdf.format(date);
        if (holidays.size() > 0) {
            for (String holiday : holidays) {
                if (holiday.equals(dateStr)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 根据判断当前时间是否是节日
     *
     * @param date 时间
     * @return
     */
    private static boolean isWorkday(Date date) {
        boolean result = false;
        String dateStr = sdf.format(date);
        if (workdays.size() > 0) {
            for (String workday : workdays) {
                if (workday.equals(dateStr)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }


}
