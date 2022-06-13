package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		System.out.println(">>> main <<<");

		// spring context creation phase

		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

		// Employee emp= (Employee) ac.getBean("e1");
		// Employee emp = ac.getBean(Employee.class);

		Employee emp1 = ac.getBean(Employee.class);
		Employee emp2 = ac.getBean(Employee.class);

		emp1.setSalary(100000);
		System.out.println(emp2.getSalary());
		System.out.println(emp1.getSalary());

	}

}
