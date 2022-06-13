package com;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

//@Component
@Service
//@Repository
//@Configuration
//@Controller
@Scope(value = "singleton")
@Lazy(value = false)
public class Employee {

	private int empId;
	private String empName;
	private double salary;

	@Autowired // setter based injection
	private Department dept;

	@Bean
	public void f1() {
		System.out.println(">>> f1 method of employee class on "+this.hashCode());
	}
	
	@Bean
	public void f11() {
		System.out.println(">>> f1-v1 method of employee class on "+this.hashCode());
	}
	@Bean
	public void f12() {
		System.out.println(">>> f1-v2 method of employee class on "+this.hashCode());
	}


	@PostConstruct
	public void f3() {
		System.out.println(">>> f3 method of employee class on "+this.hashCode());
	}

	@PostConstruct
	public void f2() {
		System.out.println(">>> f2 method of employee class on "+this.hashCode());
	}

	@PreDestroy
	public void f4() {
		System.out.println(">>> logic of employee before employee object destroyed for "+this.hashCode());
	}
	
	@PreDestroy
	public void f5() {
		System.out.println(">>> logic-v1 of employee before employee object destroyed..");
	}

	public Employee() {
		System.out.println(">>> employee object created on "+System.identityHashCode(this));
	}

	
	//@Autowired
	public Employee(Department dept) {
		this.dept = dept;
	}

	public Employee(int empId, String empName, double salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", dept=" + dept + "]";
	}

}
