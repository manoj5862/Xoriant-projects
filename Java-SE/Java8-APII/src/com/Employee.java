package com;

@FunctionalInterface
public interface Employee {

	void f1();
	

	public default void f2() {
		System.out.println(">>>> f2 method");
	}

	public static void f3() {
		System.out.println(">>>> f3 method");
	}

}
