package com.xoraint.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("com.xoraint.service,com.xoraint.dao")
@ComponentScans(value = {@ComponentScan("com.xoraint.service"),
		                 @ComponentScan("com.xoraint.dao")})
public class AppConfig {
	public AppConfig() {
		System.out.println("AppConfig object created..");
	}

}
