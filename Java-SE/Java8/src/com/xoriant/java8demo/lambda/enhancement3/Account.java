package com.xoriant.java8demo.lambda.enhancement3;

import java.util.ArrayList;
import java.util.List;

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
 * Yes, let's create a Notification Interface and define an implementations such
 * as AlertEmail and AlertSMS which will decide what kind of notification to be
 * sent without changing any code in Account class
 * 
 * But if you can observe here only one type of notification we can set here
 * either email or SMS. What if we want both type of notification to subscribe?
 * 
 * Yes, it is possible to use List<Notification>
 * 
 * What if now bank needs to send one type of notification as what'sapp message
 * 
 * For this we need to create one more implementation class AlertWhatsApp. But
 * do you think this time it is required to change any code in the Account
 * class. No, not required. This is called decoupling/loose coupling using an
 * interface.
 * 
 * But don't you think adding new implementations for the Notification is going
 * to add to maintenance cost?? There is a solution to the same. Let's use
 * anonymous inner class. Delete all the Notification implemented classes, they
 * are no more required now
 * 
 * But using Anonymous class looks not as an elegant code. Is there any other
 * alternate way for the same? Yes, the answer is Lambda expression, which
 * represents a block of code that can be passed as an argument to a method
 * which is called Behavior parameterization. Unlike an Object which refers to
 * both state and behavior, Lambda represents only the functionality. So what
 * did we achieve in Java8 is functional programming.
 * 
 * What is the return type of the lambda expression we have used?
 * Let's check the comments on ExecuteLambdaEnhancement3.java
 * 
 * @author Khan_sa
 *
 */
public class Account {
	public double balance;
	private List<Notification> notifications = new ArrayList<>();

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void addNotification(Notification notification) {
		this.notifications.add(notification);
	}

	public Account(double balance) {
		this.balance = balance;
	}

	public void deposit(double amount) {
		balance += amount;
		if (null != notifications) {
			for (Notification notification : notifications) {
				notification.notify(balance);
			}
		}
	}

	public void withdraw(double amount) {
		balance -= amount;
		if (null != notifications) {
			for (Notification notification : notifications) {
				notification.notify(balance);
			}

		}
	}

}
