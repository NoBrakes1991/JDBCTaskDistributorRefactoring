package com.taskDistributor.service;

import com.taskDistributor.entity.Task;

import java.util.List;

public class NotFoundMessageService {
    public static String getNotFoundMessage(List<Task> tasks) {
        if (tasks.iterator().hasNext()) {
            return "Not found by your filter";
        } else return "";
    }
}
