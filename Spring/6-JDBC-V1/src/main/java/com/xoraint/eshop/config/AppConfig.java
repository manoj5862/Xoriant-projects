package com.xoraint.eshop.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScans({ @ComponentScan("com.xoraint.eshop.service"), @ComponentScan("com.xoraint.eshop.dao") })
@PropertySource(value = { "application.properties" })
@EnableTransactionManagement
public class AppConfig {
	@Autowired
	private Environment env;

	// 1. Data-source
	@Bean
	public DataSource mySQLDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		//dataSource.setDriverClassName(env.getProperty("db-driver"));
		dataSource.setUrl(env.getProperty("db-url"));
		dataSource.setUsername(env.getProperty("db-user"));
		dataSource.setPassword(env.getProperty("db-password"));

		return dataSource;
	}

	// 2. transaction manager
	@Bean(name="platformTransactionManager")
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(mySQLDataSource());
		return transactionManager;
	}

}
