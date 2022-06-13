package com.xoriant.java8demo.conventional.enhancement4;

public class Alert {

	public static void sendMail(double balance) {
		System.out.print("Email has sent...");
		System.out.println("The remaining balance is :" + balance);
	}

	public static void sendSMS(double balance) {
		System.out.print("SMS has sent...");
		System.out.println("The remaining balance is :" + balance);
	}

}
