package com.xoriant.java8demo.lambda.enhancement1;

public class ExecuteLambdaEnhancement1 {

	public static void main(String[] args) {
		Account account = new Account(3000);
		account.addNotification((double balance) -> {
			System.out.print("Email has sent...");
			System.out.println("The remaining balance is :" + balance);
		});
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