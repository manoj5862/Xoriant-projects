package com;

public class Test {

	public static void main(String[] args) {
		
		
		// 1. Traditional way of implementation

		/*
		Employee e1 = new Employee() {

			@Override
			public void f1() {
				System.out.println(">>> f1 method of Employee");

			}
		};
		
		e1.f1();
		e1.f2();
		Employee.f3();
		
		*/

		// 2. using lambda expression
		Employee e2 = () -> {
			System.out.println(">>> f1 method of Employee interface");
		};
		
		Runnable r=()->{
			System.out.println("Name: "+Thread.currentThread().getName());
		};
		
		
		r.run();
		
       
		e2.f1();
		e2.f2();
		//e2.f3();
		Employee.f3();
		

	}

}
