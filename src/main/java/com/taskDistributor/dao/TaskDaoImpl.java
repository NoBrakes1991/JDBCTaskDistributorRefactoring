package com.taskDistributor.dao;

import com.taskDistributor.entity.Task;
import com.taskDistributor.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;

public class TaskDaoImpl implements TaskDao {

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public TaskDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Task> findAll() {
        String sql = "SELECT * FROM task";
        return jdbcTemplate.query(sql, new TaskMapper());
    }

    @Override
    public List<Task> findByAssignee(String assignee) {
        String sql = "SELECT * FROM task where assignee=?";
        return jdbcTemplate.query(sql, new TaskMapper(), assignee);
    }

    @Override
    public void save(Task task) {
        String sql = "INSERT INTO task (assignee,summary,startDate,endDate) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql,task.getAssignee(),task.getSummary(),task.getStartDate(),task.getEndDate());
    }

    @Override
    public List<Task> findByStartDateAndEndDate(Date startDate, Date endDate) {
        String sql = "SELECT * FROM task where startDate <=? and endDate >=?";
        return jdbcTemplate.query(sql, new TaskMapper(), endDate,startDate);
    }

    @Override
    public List<Task> findByAssigneeStartDateAndEndDate(String assignee, Date startDate, Date endDate) {
        String sql = "SELECT * FROM task where startDate <=? and endDate >=? and assignee=?";
        return jdbcTemplate.query(sql, new TaskMapper(), endDate,startDate,assignee);
    }
}
