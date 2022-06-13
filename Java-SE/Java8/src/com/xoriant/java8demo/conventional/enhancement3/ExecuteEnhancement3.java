package com.xoriant.java8demo.conventional.enhancement3;

public class ExecuteEnhancement3 {
	public static void main(String[] args) {
		Account account = new Account(3000);
		account.deposit(1000);
        account.withdraw(500);
	}
}
