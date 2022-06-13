package com.xoriant.java8demo.lambda.enhancement5;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * The return type of a lambda expression is an interface with a method having
 * double as an argument. In this case it is Notification
 * 
 * What if we can have two more interface OtherNotification1, OtherNotification1
 * with a method having double as an argument?
 * 
 * Yes, in that case lambda expression can be assigned to any one of them.
 * 
 * What if there is more than one method writeLog() in the Notification
 * Interface?? Then lambda expression will give compilation error as it will not
 * be able to resolve which method to infer.
 * 
 * Is there a way to restrict the developer not to make this mistake? This can
 * be done by adding @FunctionalInterface annotation in Notification interface
 * 
 * Lambda Expression Syntax has 1. Argument-list: It can be empty or non-empty
 * as well. 2. Arrow-token: It is used to link arguments-list and body of
 * expression. 3. Body: It contains expressions and statements for lambda
 * expression. 4. Return type
 * 
 * In a Lambda expression the below parameters are automatic inference no need
 * of explicit declaration. 1. The data type of arguments 2. use of return
 * keyword, in case there is only return statement present in the Lambda body 3.
 * No need of parentheses if only one statement is present in Lambda body
 * 
 * What if the same double balance as argument for lambda at the same time it is
 * the only data to be printed then method reference can be used. like (p)->
 * System.out.println(p) then we can also write System.out::println which is
 * also called as Method Reference
 * 
 * Types of Method References
 * 1. Reference to a static method.
 * 2. Reference to an instance method.
 * 3. Reference to a constructor.
 * 
 * @author Khan_sa
 *
 */
public class ExecuteLambdaEnhancement5_1 {

	public static void main(String[] args) {
		
		Notification notificationEmail = balance -> System.out
				.println("Email has sent...The remaining balance is :" + balance);

		Notification notificationSMS = balance -> System.out
				.println("SMS has sent...The remaining balance is :" + balance);
		/*
		 * Use of Method reference
		 * Reference to an instance method.
		 */
		Notification notificationWhatsApp = System.out::println;

		//Reference to a default constructor.
		System.out.println("===========Reference to a default constructor Called=========");
		AccountWithNoArgument a = Account::new;
		Account account=a.getAccount();
		account.addNotification(notificationEmail);
		account.addNotification(notificationSMS);
		account.addNotification(notificationWhatsApp);
		//account.deposit(1000);
		//account.withdraw(500);
		
		//Reference to a parameterized constructor.
		System.out.println("===========Reference to a parameterized constructor Called======");
		AccountWithArgument a1 = Account::new;
		Account account1=a1.getAccount(3000);
		account1.addNotification(notificationEmail);
		account1.addNotification(notificationSMS);
		account1.addNotification(notificationWhatsApp);
		//account1.deposit(1000);
		//account1.withdraw(500);
		
		//Reference to a instance method
		System.out.println("==========Reference to a instance method Called=========");
		ReferenceGetInterface getMethodReference = account1::getBalance; 
		System.out.println("Balance : "+getMethodReference.instanceMethodGetBalance());
		ReferenceSetInterface setMethodReference =account1::setBalance;
		setMethodReference.instanceMethodSetBalance(5000);
		System.out.println(account1.getBalance());
		
		//Reference to a static method
		System.out.println("==========Reference to a static method Called=========");
		ReferenceStaticInterface staticMethodReference=Account::display;
		staticMethodReference.staticMethodDisplay(account1);
	}
}