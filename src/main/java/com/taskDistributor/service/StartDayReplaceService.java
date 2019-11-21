package com.taskDistributor.service;

import java.util.Calendar;
import java.util.Date;

public class StartDayReplaceService {

    public static Date getDate(String period) {
        Date startDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.AM_PM,0);
        calendar.set(Calendar.HOUR,0);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,calendar.getActualMinimum(Calendar.MILLISECOND));
        switch (period) {
            case "lastQuarter": {
                calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) / 3 * 3 - 3);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                startDate = calendar.getTime();
            }
            break;
            case "lastMonth": {
                calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)-1);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                startDate = calendar.getTime();
            }
            break;
            case "lastWeek": {
                calendar.set(Calendar.WEEK_OF_YEAR, calendar.get(Calendar.WEEK_OF_YEAR)-1);
                calendar.set(Calendar.DAY_OF_WEEK, 2);
                startDate = calendar.getTime();
            }
            break;
            case "currentQuarterToDate": {
                calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) / 3 * 3);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                startDate = calendar.getTime();
            }
            break;
            case "currentMonthToDate": {
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                startDate = calendar.getTime();
            }
            break;
            case "currentWeekToDate": {
                calendar.set(Calendar.DAY_OF_WEEK, 2);
                startDate = calendar.getTime();
            }
            break;
        }
        return startDate;
    }}
