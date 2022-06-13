package com.xoriant.threaddemo.simplethread;

import java.util.Scanner;

public class PrimeNumberConcurrency implements Runnable{

	int n;
	
	PrimeNumberConcurrency(int n){
		this.n=n;
	}
	
	public static void main(String[] args) {
		
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the nth number to continue, 0 to exit");
			int n = sc.nextInt();
			if (n == 0)
				break;
			PrimeNumberConcurrency r=new PrimeNumberConcurrency(n);
			Thread thread = new Thread(r);
			thread.start();
		}
	}

	@Override
	public void run() {
		int number = PrimeNumberUtil.claculatePrime(n);
		System.out.println("The Value of " + n + "th prime is: " + number);
		
	}

}
