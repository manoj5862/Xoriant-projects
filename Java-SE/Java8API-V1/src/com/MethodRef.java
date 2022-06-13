package com;

import java.util.List;
import java.util.Arrays;

public class MethodRef {

	public static void main(String[] args) {

		List<Integer> nums = Arrays.asList(10, 20, 54, 23, 12, 98, 32);

		for (int num : nums) {
			System.out.println(num);
		}
		System.out.println("--------------------");

		nums.forEach(num -> {
			System.out.println(num);
		});

		System.out.println("--------------------");
		nums.forEach(System.out::println);

	}

}
