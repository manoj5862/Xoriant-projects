package com;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com")
@Scope("singleton")
@Lazy(value = false)
public class AppConfiig {
	
	double salary;
	
	public AppConfiig() {
		System.out.println(">>> AppConfig object created on "+System.identityHashCode(this));
	}
	
	@Bean
	public void f1() {
		System.out.println(">>> f1 method on "+System.identityHashCode(this));
	}
	
	@Bean
	public void f2() {
		System.out.println(">>> f2 method on "+System.identityHashCode(this));
	}
	
	@Bean
	public void f3() {
		System.out.println(">>> f3 method on "+System.identityHashCode(this));
	}
	
	
	@PostConstruct
	public void f4() {
		System.out.println(">>> f4 method PostConstruct on "+System.identityHashCode(this));
	}
	
	@PostConstruct
	public void f5() {
		System.out.println(">>> f5 method PostConstruct on "+System.identityHashCode(this));
	}
	
	@PreDestroy
	public void f6() {
		System.out.println(">>> f6 method PreDestroy on "+System.identityHashCode(this));
	}
	
	
	
	
	

}
