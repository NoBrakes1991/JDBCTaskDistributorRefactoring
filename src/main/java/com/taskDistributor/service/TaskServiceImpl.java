package com.taskDistributor.service;

import com.taskDistributor.dao.TaskDao;
import com.taskDistributor.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    public TaskDao taskDao;

    @Override
    public void save(Task task) {
        taskDao.save(task);
    }

    @Override
    public List<Task> findAll() {
        return taskDao.findAll();
    }

    @Override
    public List<Task> findByFilter(String assignee, Date startDate, Date endDate, String period) {
        if (!period.equals("")) {
            startDate = StartDayReplaceService.getDate(period);
            endDate = EndDayReplaceService.getDate(period);
        }

        if (startDate == null && endDate == null && !assignee.isEmpty()) {
            return taskDao.findByAssignee(assignee);
        } else if (startDate != null && endDate != null && !assignee.isEmpty()) {
            return taskDao.findByAssigneeStartDateAndEndDate(assignee, startDate, endDate);
        } else if (startDate != null && endDate != null && assignee.isEmpty()) {
            return taskDao.findByStartDateAndEndDate(startDate, endDate);
        } else {
            return taskDao.findAll();
        }
    }

}
