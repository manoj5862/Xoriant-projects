package com.xoriant.java8demo.conventional.enhancement1;

/**
 * Problem statement: An account user wants to do withdraw or deposit
 * 
 * Bank wants to send email notification each time he does withdraw or deposit
 * 
 * 
 * @author Khan_sa
 *
 */
public class Account {
	public double balance;

	public Account(double balance) {
		this.balance = balance;
	}

	public void deposit(double amount) {
		balance += amount;
		sendMail();
	}

	public void withdraw(double amount) {
		balance -= amount;
		sendMail();
	}

	public void sendMail() {
		System.out.print("Email has sent...");
		System.out.println("The remaining balance is :" + balance);
	}
}
