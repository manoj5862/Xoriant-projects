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
		
		//Department d1 = ac.getBean("d1",Department.class);
		
		emp1.setEmpId(1);
		emp1.setEmpName("Praveen");
		emp1.setSalary(10000);
		
		//emp1.setDept(d1);

		
		
		
		System.out.println(emp1);
		

		

	}

}
