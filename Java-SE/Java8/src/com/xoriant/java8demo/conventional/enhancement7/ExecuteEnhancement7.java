package com.xoriant.java8demo.conventional.enhancement7;

public class ExecuteEnhancement7 {
	public static void main(String[] args) {
		Account account = new Account(3000);
		account.addNotification(new AlertEmail());
		account.addNotification(new AlertSMS());
		account.addNotification(new AlertWhatsApp());
		account.deposit(1000);
        account.withdraw(500);
	}
}
