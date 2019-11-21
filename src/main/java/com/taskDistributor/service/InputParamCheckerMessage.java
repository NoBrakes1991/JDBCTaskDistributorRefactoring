package com.taskDistributor.service;

import java.util.Date;

public class InputParamCheckerMessage {

    public static String checkInputs(Date startDate, Date endDate, String assignee, String summary) {
        if (startDate == null || endDate == null || assignee.isEmpty() || summary.isEmpty() || startDate.after(endDate)) {
            return "You choose incorrect parameters! Please, check: 1)All fields is not Empty; 2) End date >= Start date.";
        } else
            return null;
    }
}