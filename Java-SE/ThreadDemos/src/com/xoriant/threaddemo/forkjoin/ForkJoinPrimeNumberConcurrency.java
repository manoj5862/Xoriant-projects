package com.xoriant.threaddemo.forkjoin;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

//Accept in input array of numbers
//Calculate the nth prime(where n is the value of that is stored in a arr[i])
//Add all the nth primes
public class ForkJoinPrimeNumberConcurrency {

	public void runForkJoin() {
		int[] inputNumbers = { 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
		CalculatePrimeTask calculatePrimeTask = new CalculatePrimeTask(inputNumbers, 0, inputNumbers.length - 1);
		Integer result = forkJoinPool.invoke(calculatePrimeTask);
		System.out.println("The sum of primes is: " + result);
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		new ForkJoinPrimeNumberConcurrency().runForkJoin();

	}
}
