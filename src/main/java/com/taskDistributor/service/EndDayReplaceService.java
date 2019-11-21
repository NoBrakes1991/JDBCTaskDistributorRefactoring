package com.taskDistributor.service;

import java.util.Calendar;
import java.util.Date;

public class EndDayReplaceService {

    public static Date getDate(String period) {
        Date endDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.AM_PM,1);
        calendar.set(Calendar.HOUR,11);
        calendar.set(Calendar.HOUR_OF_DAY ,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        calendar.set(Calendar.MILLISECOND,calendar.getActualMaximum(Calendar.MILLISECOND));
        switch (period) {
            case "lastQuarter": {
                calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) / 3 * 3 - 1);
                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
                endDate = calendar.getTime();
            }
            break;
            case "lastMonth": {
                calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)-1);
                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
                endDate = calendar.getTime();
            }
            break;
            case "lastWeek": {
                calendar.set(Calendar.WEEK_OF_YEAR, calendar.get(Calendar.WEEK_OF_YEAR)-1);
                calendar.set(Calendar.DAY_OF_WEEK, 8);
                endDate = calendar.getTime();
            }
            break;
            case "currentQuarterToDate": {
                endDate = calendar.getTime();
            }
            break;
            case "currentMonthToDate": {
                endDate = calendar.getTime();
            }
            break;
            case "currentWeekToDate": {
                endDate = calendar.getTime();
            }
            break;
        }
        return endDate;
    }}