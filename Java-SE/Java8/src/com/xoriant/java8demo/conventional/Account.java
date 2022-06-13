package com.xoriant.java8demo.conventional;


/**
 * Problem statement: An account user wants to do withdraw or deposit
 * 
 * 
 * @author Khan_sa
 *
 */
public class Account {
	public double balance;

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) {
		balance -= amount;
	}
}
