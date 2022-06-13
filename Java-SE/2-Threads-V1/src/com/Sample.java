package com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Demo implements Runnable {
	@Override
	public void run() {
		//System.out.println("run:: >>>> "+Thread.currentThread().getName());
		f1();
	}
	
	void f1() {
		for(int i=1;i<=5;i++) {
			System.out.println("I = "+i+" by "+Thread.currentThread().getName());
		}
	}
}

public class Sample {

	public static void main(String[] args) {
		System.out.println(">>>> main <<<<");
		
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		service.execute(new Demo());
		service.execute(new Demo());
		service.execute(new Demo());
		service.execute(new Demo());
		service.execute(new Demo());

	}

}
