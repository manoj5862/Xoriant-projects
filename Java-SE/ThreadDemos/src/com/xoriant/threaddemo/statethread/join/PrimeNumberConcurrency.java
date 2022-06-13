package com.xoriant.threaddemo.statethread.join;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeNumberConcurrency {

	public static void main(String[] args) {

		List<Thread> threads = new ArrayList<>();
		Runnable stateReporter = () -> {
			try {
				while (true) {

					Thread.sleep(10000);

					printThreadStatus(threads);
				}
			} catch (InterruptedException e) {
				System.out.println("Status Report thread got interrupted");
			}
		};
		Thread reportedThread = new Thread(stateReporter);
		reportedThread.setDaemon(true);
		reportedThread.start();

		while (true) {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter the nth number to continue, 0 to exit");
			int n = sc.nextInt();
			if (n == 0) {
				try {
					System.out.println("Waiting for all the threads to complete");
					waitForThreads(threads);
					System.out.println("Done " + threads.size() + " primes calculated");
					break;
				} catch (InterruptedException e) {
					System.out.println("\nGot interrupted when waiting for threads. Quitting...");
				}
			}

			Runnable r = new Runnable() {

				@Override
				public void run() {
					int number = PrimeNumberUtil.claculatePrime(n);
					System.out.println("The Value of " + n + "th prime is: " + number);
				}
			};

			Thread thread = new Thread(r);
			threads.add(thread);
			thread.start();
		}

		System.out.println("Main Ended");
	}

	private static void waitForThreads(List<Thread> threads) throws InterruptedException {

		for (Thread thread : threads) {
			thread.join();
		}

	}

	private static void printThreadStatus(List<Thread> threads) {
		System.out.println("\n Thread Status: ");
		threads.forEach(thread -> {
			System.out.println(thread.getState() + " ");
		});

		System.out.println("");
	}

}
