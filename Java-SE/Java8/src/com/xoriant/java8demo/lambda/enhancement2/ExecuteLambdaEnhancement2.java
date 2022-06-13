package com.xoriant.java8demo.lambda.enhancement2;

/**
 * The return type of a lambda expression is an interface with a method having
 * double as an argument. In this case it is Notification
 * 
 * What if we can have two more interface OtherNotification1, OtherNotification2 with a method having
 * double as an argument?
 * 
 * Yes, in that case lambda expression can be assigned to any one of them.
 * 
 * @author Khan_sa
 *
 */
public class ExecuteLambdaEnhancement2 {
	
	static void otherNotification1(OtherNotification1 otherNotification1) {
		otherNotification1.notify(1500);
	}
	
	static void otherNotification2(OtherNotification2 otherNotification2) {
		otherNotification2.notify(2500);
	}

	public static void main(String[] args) {

		Notification notificationEmail = (double balance) -> {
			System.out.print("Email has sent...");
			System.out.println("The remaining balance is :" + balance);
		};
		
		OtherNotification1 otherNotification1 = (double balance) -> {
			System.out.print("Other Notification1 has sent...");
			System.out.println("The remaining balance is :" + balance);
		};
		
		OtherNotification2 otherNotification2 = (double balance) -> {
			System.out.print("Other Notification2 has sent...");
			System.out.println("The remaining balance is :" + balance);
		};

		Account account = new Account(3000);
		account.addNotification(notificationEmail);//
		account.addNotification((double balance) -> {
			System.out.print("SMS has sent...");
			System.out.println("The remaining balance is :" + balance);
		});
		account.addNotification((double balance) -> {
			System.out.print("WhatsApp has sent...");
			System.out.println("The remaining balance is :" + balance);
		});
		account.deposit(1000);
		account.withdraw(500);
		
		otherNotification1(otherNotification1);//
		otherNotification2(otherNotification2);//
		
	}
}