package com.xoriant.java8demo.lambda.enhancement3;


@FunctionalInterface
public interface Notification {
	void notify(double balance);
	// uncomment and check, as @FunctionalInterface is being used, it will allow
	// only one abstract method into it
	// void log(double balance);
}
