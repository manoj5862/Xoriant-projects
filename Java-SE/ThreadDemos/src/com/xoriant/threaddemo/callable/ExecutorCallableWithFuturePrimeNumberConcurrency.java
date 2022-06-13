package com.xoriant.threaddemo.callable;

import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorCallableWithFuturePrimeNumberConcurrency {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executorService = Executors.newCachedThreadPool();

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the nth number to continue, 0 to exit");
			int n = sc.nextInt();
			if (n == 0)
				break;

			Callable<Integer> callable = new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {

					return PrimeNumberUtil.claculatePrime(n);
				}

			};
			Future<Integer> primeNumberFuture = executorService.submit(callable);
			
			//While making a call to get method it may or may not return the value immediately
			//Hence it will block the execution of other threads if there is a delay
			//We need to add these values to a list and as and when the values are returned can be read
			//Check out the ExecutorCallableWithResultListPrimeNumberConcurrency
			Integer primeNumber = primeNumberFuture.get();
			System.out.println("The Value of " + n + "th prime is: " + primeNumber);

		}
	}

}
