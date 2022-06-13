package com.xoriant.threaddemo.semaphore;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class SemaphoreWithFairPrimeNumberConcurrency {

	public static void main(String[] args) {

		//Semaphore(int permits, boolean fair) is useful when we need the waiting threads 
		//which needs to be taken as per the order they have been created
		Semaphore semaphore = new Semaphore(3, true);

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the nth number to continue, 0 to exit");
			int n = sc.nextInt();
			if (n == 0)
				break;

			Runnable r = new Runnable() {

				@Override
				public void run() {
					try {
						semaphore.acquire();
						System.out.println("Now calculating for "+ n);
						int number = PrimeNumberUtil.claculatePrime(n);
						System.out.println("The Value of " + n + "th prime is: " + number);
					} catch (InterruptedException e) {

					} finally {
						semaphore.release();
					}

				}
			};

			Thread thread = new Thread(r);
			thread.start();
		}
	}

}
