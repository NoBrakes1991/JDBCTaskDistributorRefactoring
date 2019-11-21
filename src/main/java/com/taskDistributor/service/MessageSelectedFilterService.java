package com.taskDistributor.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageSelectedFilterService {
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
    public static String getMessageSelectedFilter(String assignee, Date startDate, Date endDate){
        String messageSelectedFilter = "";
        if (startDate != null && endDate != null){
            messageSelectedFilter= "Selected parameters: Start date: " + sdf.format(startDate) + " End date: " + sdf.format(endDate) + " Assignee: " + assignee;
        }
        else if ((startDate != null && endDate == null) ||(startDate == null && endDate != null)){
            messageSelectedFilter= "You must Enter -Start date- and -End date- or Choose dropList -Period- or leave this fields empty";
        }
        else{
            messageSelectedFilter= "Selected parameters: startDate:  - " + "     endDate: - " + " Assignee: " + assignee;
        }

        return messageSelectedFilter;
    }

}
