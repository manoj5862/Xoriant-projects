package com.xoriant.threaddemo.forkjoin;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ForkJoinCallableWithCompletableFuturePrimeNumberConcurrency {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the nth number to continue, 0 to exit");
			int n = sc.nextInt();
			if (n == 0)
				break;

			//CompletableFuture.supplyAsync(() -> PrimeNumberUtil.claculatePrime(n)/*,Fork & Join*/)
			//		.thenAccept((Integer returnValue) -> System.out.println(returnValue));
			
			//Internally it uses fork and join Thread pool
			CompletableFuture.supplyAsync(() -> PrimeNumberUtil.claculatePrime(n)/*,Fork & Join*/)
			.thenAccept(System.out::println);

		}
	}

}
