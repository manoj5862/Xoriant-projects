package com.xoriant.java8demo.conventional.enhancement5;

public class AlertSMS implements Notification{
	@Override
	public void notify(double balance) {
		System.out.print("SMS has sent...");
		System.out.println("The remaining balance is :" + balance);
	}
}
