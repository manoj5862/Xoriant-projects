package com;

public class TaskRunner {

	private volatile static int number;
	private volatile static boolean ready;

	private static class Reader extends Thread {

		@Override
		public void run() {
			
			number++;
			
			System.out.println(Thread.currentThread().getName());
			// number=76;

			System.out.println(">>> Running - 1");

			while (!ready) {
				System.out.println(">>> Running");
				Thread.yield();

			}

			System.out.println(number);

		}
	}

	public static void main(String[] args) {
		
		ready=true;
		
		System.out.println("1: " + Thread.currentThread().getName());
		Reader r = new Reader();
		r.setName("Readrer");
		

		r.start();
		

		number = 42;
		
		//ready = false;
	}

}
