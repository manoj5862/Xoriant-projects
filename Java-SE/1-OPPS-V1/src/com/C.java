package com;

 class A {

	double salary;

	void getSalary() {
		// logic to process salary of an employee by HR
		System.out.println("A::Salary");
		System.out.println("Salary:: " + salary);
	}

	void f2() {
		System.out.println("A::f2");
	}

}

class B extends A {
	@Override
	void getSalary() {
		// logic to process salary of an employee by HR
		salary = 15000 * 18;
		System.out.println("B::Salary");
		System.out.println("Salary:: " + salary);
	}


	void f3() {
		System.out.println("B::f3");
	}

}

public class C {
	public static void main(String[] args) {

		//B aobj = new B();
		A aobj=new B();
		aobj.getSalary();

	}

}
