package com;

public class Employee {

	private double salary;

	public Employee() {
		System.out.println(">> Employee class object created on " + System.identityHashCode(this));
	}

	public void f1() {
		System.out.println(">>> Employee :: f1 method on " + System.identityHashCode(this));
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
