package com.xoriant.threaddemo.synchronization;

class SyncCounter implements Runnable {

	private int value = 0;

	public void increment() {

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
		value++;
	}

	public void decrement() {
		value--;
	}

	public int getValue() {
		return value;
	}

	@Override
	public void run() {
		synchronized (this) {
			this.increment();
			System.out.println(Thread.currentThread().getName() + " increments: " + this.getValue());
			this.decrement();
			System.out.println(Thread.currentThread().getName() + " decrements: " + this.getValue());
		}
	}

}

public class SynchronizedCounter {

	public static void main(String[] args) {
		SyncCounter counter = new SyncCounter();
		new Thread(counter, "One").start();
		new Thread(counter, "Two").start();
		new Thread(counter, "Three").start();
		new Thread(counter, "Four").start();
		
		//SyncCounter counter2=new SyncCounter();
		//new Thread(counter2, "Thread of Other object").start();
	}

}
