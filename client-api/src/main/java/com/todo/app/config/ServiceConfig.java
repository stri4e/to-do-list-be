package com.todo.app.config;

import com.todo.app.jdbc.dao.data.source.IDataSource;
import com.todo.app.jdbc.dao.tasks.IDaoTasks;
import com.todo.app.jdbc.dao.tasks.impl.DaoTasksImpl;
import com.todo.app.jdbc.dao.users.IDaoUsers;
import com.todo.app.jdbc.dao.users.impl.DaoUsersImpl;
import com.todo.app.service.tasks.IServiceTasks;
import com.todo.app.service.tasks.impl.ServiceTasksImpl;
import com.todo.app.service.users.IServiceUsers;
import com.todo.app.service.users.impl.ServiceUsersImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.todo.app.jdbc.dao.data.source", "com.todo.app.jdbc.dao.users"})
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
