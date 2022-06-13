package com.xoriant.java8demo.conventional.enhancement4;

/**
 * Problem statement: An account user wants to do withdraw or deposit
 * 
 * Bank wants to send email notification each time he does withdraw or deposit
 * 
 * Is it logically correct to keep the notification functionality along with the
 * Transactions?? No, A class should have only one reason to change only when
 * deposit or withdraw logic changes but not when any new notification is added
 * as it is a violation of SRP (Single Responsibility design principle)
 * 
 * Let's create a class called Alert and add this sendMail() in that
 * 
 * What if bank wants to send mail as well as SMS?? Again we need to change the
 * code in Account class. What can be a better solution here??
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
		Alert.sendSMS(balance);
	}

	public void withdraw(double amount) {
		balance -= amount;
		Alert.sendMail(balance);
		Alert.sendSMS(balance);
	}
}
