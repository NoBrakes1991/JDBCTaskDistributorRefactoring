package com.taskDistributor.service;

import com.taskDistributor.entity.Task;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqAssigneeService {

    public static Set<String> getUniqAssignee(List<Task> tasks) {
        Set<String> uniqAssignee = new HashSet<>();
        for (int i = 0; i < tasks.size(); i++) {
            uniqAssignee.add(tasks.get(i).getAssignee());
        }
        return uniqAssignee;
    }
}
