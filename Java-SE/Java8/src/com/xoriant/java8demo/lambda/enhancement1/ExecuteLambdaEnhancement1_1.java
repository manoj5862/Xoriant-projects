package com.xoriant.java8demo.lambda.enhancement1;

public class ExecuteLambdaEnhancement1_1 {

	public static void main(String[] args) {
		
		Notification notificationEmail=(double balance) -> {
			System.out.print("Email has sent...");
			System.out.println("The remaining balance is :" + balance);
		};
		Notification notificationSMS=(double balance) -> {
			System.out.print("SMS has sent...");
			System.out.println("The remaining balance is :" + balance);
		};
	
		Notification notificationWhatsApp= (double balance) -> {
			System.out.print("WhatsApp has sent...");
			System.out.println("The remaining balance is :" + balance);
		};
		Account account = new Account(3000);
		account.addNotification(notificationEmail);
		account.addNotification(notificationSMS);
		account.addNotification(notificationWhatsApp);
		account.deposit(1000);
		account.withdraw(500);
	}
}