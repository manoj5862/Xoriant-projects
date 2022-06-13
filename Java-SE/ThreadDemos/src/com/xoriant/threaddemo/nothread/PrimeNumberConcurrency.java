package com.xoriant.threaddemo.nothread;
import java.util.Scanner;

public class PrimeNumberConcurrency {
	
	
	public static void main(String[] args) {
		
		int number;
		
		while(true) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the nth number to continue, 0 to exit");
			int n=sc.nextInt();
			if(n == 0) break;
			number=PrimeNumberUtil.claculatePrime(n);
			System.out.println("The Value of "+n+"th prime is: "+number);
		}
	}

}
