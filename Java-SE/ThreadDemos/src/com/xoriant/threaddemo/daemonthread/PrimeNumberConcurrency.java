package com.xoriant.threaddemo.daemonthread;

import java.util.Scanner;

public class PrimeNumberConcurrency {

	public static void main(String[] args) {

		System.out.println("Main Started");
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the nth number to continue, 0 to exit");
			int n = sc.nextInt();
			if (n == 0)
				break;

			Runnable r = new Runnable() {

				@Override
				public void run() {
					int number = PrimeNumberUtil.claculatePrime(n);
					System.out.println("The Value of " + n + "th prime is: " + number);
				}
			};
			
			Thread thread=new Thread(r);
			thread.setDaemon(true);
			thread.start();
		}
		
		System.out.println("Main Ended");
	}

}
