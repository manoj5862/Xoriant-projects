package com.xoriant.java8demo.conventional.enhancement3;

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
 * Let's create a class called Alert and add this sendMail() in that
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
		Alert.sendMail(balance);
	}

	public void withdraw(double amount) {
		balance -= amount;
		Alert.sendMail(balance);
	}
}
