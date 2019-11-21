package com.taskDistributor.service;

import com.taskDistributor.entity.Task;

import java.util.Date;
import java.util.List;

public interface TaskService {

    List<Task> findAll();

    void save(Task task);

    List<Task> findByFilter(String assignee, Date startDate, Date endDate, String period);

}
