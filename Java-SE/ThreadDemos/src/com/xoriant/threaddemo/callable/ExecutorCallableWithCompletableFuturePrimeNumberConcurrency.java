package com.xoriant.threaddemo.callable;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ExecutorCallableWithCompletableFuturePrimeNumberConcurrency {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executorService = Executors.newCachedThreadPool();

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the nth number to continue, 0 to exit");
			int n = sc.nextInt();
			if (n == 0)
				break;

			//CompletableFuture.supplyAsync(() -> PrimeNumberUtil.claculatePrime(n), executorService)
			//		.thenAccept((Integer returnValue) -> System.out.println(returnValue));
			
			CompletableFuture.supplyAsync(() -> PrimeNumberUtil.claculatePrime(n), executorService)
			.thenAccept(System.out::println);

		}
	}

}
