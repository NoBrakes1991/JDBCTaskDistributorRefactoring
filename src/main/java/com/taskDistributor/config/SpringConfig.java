package com.taskDistributor.config;

import com.taskDistributor.dao.TaskDao;
import com.taskDistributor.dao.TaskDaoImpl;
import com.taskDistributor.service.TaskService;
import com.taskDistributor.service.TaskServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.TimeZone;

@Configuration
public class SpringConfig {

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSource());

    }

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/testbase?useSll=false&serverTimezone="+ TimeZone.getDefault().getID());
        dataSource.setUsername("root");
        dataSource.setPassword("###");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }

    @Bean
    public TaskDao getTaskDao(){
        return new TaskDaoImpl(getJdbcTemplate());
    }

    @Bean
    public TaskService getTaskService(){
        return new TaskServiceImpl();
    }

}
