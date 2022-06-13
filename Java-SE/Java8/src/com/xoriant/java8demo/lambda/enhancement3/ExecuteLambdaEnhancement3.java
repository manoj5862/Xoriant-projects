package com.xoriant.java8demo.lambda.enhancement3;

/**
 * The return type of a lambda expression is an interface with a method having
 * double as an argument. In this case it is Notification
 * 
 * What if we can have two more interface OtherNotification1, OtherNotification2
 * with a method having double as an argument?
 * 
 * Yes, in that case lambda expression can be assigned to any one of them.
 * 
 * What if there is more than one method writeLog() in the Notification
 * Interface?? Then lambda expression will give compilation error as it will not
 * be able to resolve which method to infer.
 * 
 * Is there a way to restrict the developer not to make this mistake? This can
 * be done by adding @FunctionalInterface annotation in Notification interface
 * 
 * @author Khan_sa
 *
 */
public class ExecuteLambdaEnhancement3 {
	
	public static void main(String[] args) {

		Notification notificationEmail = (double balance) -> {
			System.out.print("Email has sent...");
			System.out.println("The remaining balance is :" + balance);
		};

		Account account = new Account(3000);
		account.addNotification(notificationEmail);
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

	}
}