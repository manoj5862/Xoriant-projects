package com.xoriant.threaddemo.callable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorCallableWithResultListPrimeNumberConcurrency {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		List<Future<Integer>> futures = new ArrayList<Future<Integer>>();

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
			futures.add(primeNumberFuture);

		}
		Iterator<Future<Integer>> iterator = futures.iterator();
		while (iterator.hasNext()) {
			Future<Integer> future = iterator.next();
			if (future.isDone()) {
				System.out.println(future.get());
				iterator.remove();
			}
		}
		
		if (executorService.awaitTermination(5, TimeUnit.SECONDS)) {
			System.out.println("task completed");
		} else {
			System.out.println("Forcing shutdown...");
			executorService.shutdownNow();
		}
	}

}
