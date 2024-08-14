package com.example.EmployeeManagementSystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.sql.DataSource;

@Configuration
public class PrimaryTransactionManagerConfig {
	 @Autowired
	    private DataSource primaryDataSource;

	    @Bean
	    @Primary
	    public DataSourceTransactionManager primaryTransactionManager() {
	        return new DataSourceTransactionManager(primaryDataSource);
	    }
}
