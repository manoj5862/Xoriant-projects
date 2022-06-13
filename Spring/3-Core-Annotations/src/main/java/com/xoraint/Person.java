package com.xoraint;

import org.springframework.stereotype.Component;

@Component
public class Person {

	public Person() {
		System.out.println(">> Person class object created...");
	}

	public void f2() {
		System.out.println(">>> Person :: f2 method");
	}

}
