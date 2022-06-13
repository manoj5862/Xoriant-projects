package com;

public class UseClass {

	public static void main(String[] args) {

		Sample sample = () -> {
			return "Hello";
		};
		System.out.println(sample.f1());

		Product p = (int x) -> {
			return x * x;
		};

		Product p1 = (x) -> {
			return x * x;
		};

		Product p2 = x -> x*x;

		System.out.println(p2.f1(10));

		Sum sum = (int x, int y) -> {
			return x + y;
		};
		
		Sum sum1=(x,y)->x+y;

		System.out.println(sum1.f1(10, 30));
		
		//Operation ops=(x)->x*x;
		
		
		
		
		
		
		
		

	}

}
