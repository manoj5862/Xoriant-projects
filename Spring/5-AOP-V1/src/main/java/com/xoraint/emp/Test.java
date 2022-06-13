package com.xoraint.emp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.xoraint.emp.config.AppConfig;
import com.xoraint.emp.model.Employee;
import com.xoraint.emp.service.EmployeeService;

public class Test {

	public static void main(String[] args) {

		AbstractApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		EmployeeService es = ac.getBean(EmployeeService.class);

		//es.welcome();
		//es.findAll();
		//es.deleteEmployee(100);
		
		Employee emp = es.getEmployeeById(12);
		
		//Employee emp1 = es.getEmployeeByName("Bucky");

		
		System.out.println("MAIN:: "+emp);
	//	System.out.println("MAIN - V1 :: "+emp1);


		ac.close();

	}

}
