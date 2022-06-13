package com.xoriant.threaddemo.executor;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorFixedThreadPoolPrimeNumberConcurrency {

	public static void main(String[] args) {

		ExecutorService executorService=Executors.newFixedThreadPool(3);
		
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
			executorService.execute(r);
		}
	}

}
