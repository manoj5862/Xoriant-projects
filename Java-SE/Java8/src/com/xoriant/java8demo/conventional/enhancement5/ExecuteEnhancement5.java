package com.xoriant.java8demo.conventional.enhancement5;

public class ExecuteEnhancement5 {
	public static void main(String[] args) {
		Account account = new Account(3000);
		account.setNotification(new AlertEmail());
		account.deposit(1000);
        account.withdraw(500);
        
        Account account2 = new Account(3000);
		account2.setNotification(new AlertSMS());
		account2.deposit(1000);
        account2.withdraw(500);
	}
}
