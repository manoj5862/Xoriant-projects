package com;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Demo {

	public static void main(String[] args) {
		
		String s1="abc";
		String s2="abc";
		
		Predicate<Object> p1=(obj)->{
			return obj.equals("Hello");
		};
		
		Predicate<Integer> p2=(obj)->{
			return obj==100;
		};
		
		
		System.out.println("--------------");
		Supplier<Integer> supplier = () -> new Integer((int) (Math.random() * 1000D));
		
		Consumer<Integer> consumer = (value) -> System.out.println(value);
		
		Integer i1 = supplier.get();
		System.out.println(i1);
		
		consumer.accept(1000);



	}

}
