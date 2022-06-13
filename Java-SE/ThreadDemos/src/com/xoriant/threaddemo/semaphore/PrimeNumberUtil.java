package com.xoriant.threaddemo.semaphore;

public class PrimeNumberUtil {

	public static int claculatePrime(int n) {

		int number = 1;
		int numberOfPrimesFound = 0;
		int i;

		while (numberOfPrimesFound < n) {
			number++;
			for (i = 2; i <= number && number % i != 0; i++) {
			}

			if (i == number) {
				numberOfPrimesFound++;
			}
		}

		return number;
	}

}
