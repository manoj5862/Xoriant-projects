package com;

import java.util.List;
import java.util.Arrays;

public class StreamDemo {

	public static void main(String[] args) {

		List<Integer> nums = Arrays.asList(103, 20, 541, 23, 1263, 988, 327);

		nums.forEach(num -> {
			System.out.println(num);
		});

		System.out.println("--------------------");

		// Stream API

		nums.stream()
		.filter(num -> num >20)
		.filter(num-> num%2== 0)
		.limit(2)
		.forEach(num -> {
			System.out.println(num);
		});

	}

}
