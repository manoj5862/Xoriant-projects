package com.xoriant.java8demo.conventional.enhancement8;

public class ExecuteEnhancement8 {

	public static void main(String[] args) {
		Account account = new Account(3000);
		account.addNotification(new Notification() {
			@Override
			public void notify(double balance) {
				System.out.print("Email has sent...");
				System.out.println("The remaining balance is :" + balance);

			}
		});
		account.addNotification(new Notification() {

			@Override
			public void notify(double balance) {
				System.out.print("SMS has sent...");
				System.out.println("The remaining balance is :" + balance);

			}
		});
		account.addNotification(new Notification() {

			@Override
			public void notify(double balance) {
				System.out.print("WhatsApp has sent...");
				System.out.println("The remaining balance is :" + balance);

			}
		});
		account.deposit(1000);
		account.withdraw(500);
	}
}
