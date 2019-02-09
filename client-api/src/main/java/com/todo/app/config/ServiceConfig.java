package com.todo.app.config;

import com.todo.app.jdbc.dao.data.source.IDataSource;
import com.todo.app.service.tasks.IServiceTasks;
import com.todo.app.service.tasks.impl.ServiceTasksImpl;
import com.todo.app.service.users.IServiceUsers;
import com.todo.app.service.users.impl.ServiceUsersImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan({"com.todo.app.jdbc.dao.data.source",
        "com.todo.app.jdbc.dao.users",
        "com.todo.app.jdbc.dao.tasks"})
public class ServiceConfig {

    @Autowired
    private IDataSource source;

    @Bean
    public IServiceUsers usersService() {
        return new ServiceUsersImpl(source);
    }

    @Bean
    public IServiceTasks tasksService() {
        return new ServiceTasksImpl(source);
    }

}
