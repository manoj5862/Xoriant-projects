package com.xoriant.java8demo.lambda.enhancement4;


/**
 * The return type of a lambda expression is an interface with a method having
 * double as an argument. In this case it is Notification
 * 
 * What if we can have two more interface OtherNotification1, OtherNotification1
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
 * Lambda Expression Syntax has
 * 	1. Argument-list: It can be empty or non-empty as well.
 *  2. Arrow-token: It is used to link arguments-list and body of expression.
 *  3. Body: It contains expressions and statements for lambda expression.
 *  4. Return type
 * 
 * @author Khan_sa
 *
 */
public class ExecuteLambdaEnhancement4 {
	
	public static void main(String[] args) {

		//No argument and No return type
		OtherNotification1 notificationEmail1 = () -> {
			System.out.print("Email1 has sent...");
		};
		
		notificationEmail1.notification();
		
		//One argument and No return type
		Notification notificationEmail2 = (double balance) -> {
			System.out.print("\nEmail has sent...");
			System.out.println("The remaining balance is :" + balance);
		};
		
		notificationEmail2.notify(2000);
		
		//One argument and return type
		OtherNotification2 notificationSMS = (double balance) -> {
			System.out.print("SMS has sent...");
			return balance;
		};
		
		//Returned value
		double netAmount1=notificationSMS.notify(2000);
		System.out.println(netAmount1);
		
		//Two arguments and return type
		OtherNotification3 notificationWhatsApp = (double balance, double amount) -> {
			System.out.print("WhatsApp has sent...");
			return balance-amount;
		};
		
		//Returned value
		double netAmount2=notificationWhatsApp.notify(2000,500);
		System.out.println(netAmount2);
	}
}