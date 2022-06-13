package com;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		System.out.println(">>> main <<<");

		// spring context creation phase

		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

		// Employee emp= (Employee) ac.getBean("e1");
		// Employee emp = ac.getBean(Employee.class);

		//Employee emp1 = ac.getBean(Employee.class);
		// Employee emp2 = ac.getBean(Employee.class);

		//Department d1 = ac.getBean(Department.class);
		//d1.setDeptId(100);
		//d1.setDeptName("HR");

		//emp1.setEmpId(1);
		//emp1.setEmpName("Praveen");
		//emp1.setSalary(10000);

		// emp1.setDept(d1);

		//System.out.println(emp1);

		// emp1.f1();

		ac.close(); // destroy ac

		// System.out.println(emp1);

	}

}
