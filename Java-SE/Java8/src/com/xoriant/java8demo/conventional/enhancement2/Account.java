package com.xoriant.java8demo.conventional.enhancement2;

/**
 * Problem statement: An account user wants to do withdraw or deposit
 * 
 * Bank wants to send email notification each time an account holder does
 * withdraw or deposit
 * 
 * Is it logically correct to keep the notification functionality along with the
 * Transactions?? No, A class should have only one reason to change only when
 * deposit or withdraw logic changes but not when any new notification is added
 * as it is a violation of SRP (Single Responsibility design principle)
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
