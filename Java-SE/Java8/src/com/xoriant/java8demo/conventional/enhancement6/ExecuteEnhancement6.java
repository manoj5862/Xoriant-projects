package com.xoriant.java8demo.conventional.enhancement6;

public class ExecuteEnhancement6 {
	public static void main(String[] args) {
		Account account = new Account(3000);
		account.addNotification(new AlertEmail());
		account.addNotification(new AlertSMS());
		account.deposit(1000);
        account.withdraw(500);
	}
}
