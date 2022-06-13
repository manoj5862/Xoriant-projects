package com.xoriant.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConfigClient1Application {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClient1Application.class, args);
	}

}
