package com.xoriant.java8demo.conventional.enhancement4;

public class ExecuteEnhancement4 {
	public static void main(String[] args) {
		Account account = new Account(3000);
		account.deposit(1000);
        account.withdraw(500);
	}
}
