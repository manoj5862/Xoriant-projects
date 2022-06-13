package com.xoriant.java8demo.conventional;

public class ExecuteConventional {

	public static void main(String[] args) {
		Account account = new Account();
		account.deposit(1000);
		System.out.println(account.balance);
		account.withdraw(500);
		System.out.println(account.balance);
	}
}
