package com.xoraint.emp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScans({ @ComponentScan("com.xoraint.emp.service"),
				  @ComponentScan("com.xoraint.emp.dao"),
				  @ComponentScan("com.xoraint.emp.aop") })
@EnableAspectJAutoProxy
@PropertySource("application.properties")
public class AppConfig {

	@Value("${name}") // spEL
	private String employeeName;
	
	@Autowired
	private Environment env;
	

	//@Bean
	public void f1() {
		System.out.println(">>>> name is " + employeeName);
		System.out.println(">>> name - v1::: "+env.getProperty("name"));
	}

}
