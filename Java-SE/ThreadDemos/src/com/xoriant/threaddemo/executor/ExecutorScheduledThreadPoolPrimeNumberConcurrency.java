package com.xoriant.threaddemo.executor;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorScheduledThreadPoolPrimeNumberConcurrency {

	public static void main(String[] args) {
		
		//ExecutorService executorService=Executors.newFixedThreadPool(3);
		ThreadPoolExecutor executorService=(ThreadPoolExecutor)Executors.newFixedThreadPool(3);
		
		//ExecutorService scheduledExecutor=Executors.newScheduledThreadPool(1);
		ScheduledExecutorService scheduledExecutor=Executors.newScheduledThreadPool(1);
		Runnable reportRunnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("Running report");
				System.out.println("Active Threads: "+executorService.getActiveCount());
				System.out.println("Active Threads: "+executorService.getCompletedTaskCount());
			}
		};
		
		scheduledExecutor.scheduleAtFixedRate(reportRunnable, 1, 5, TimeUnit.SECONDS);

		
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
