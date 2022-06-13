package com;

class Reservation implements Runnable {
	private int noOfSeats = 1;
	private int wanted;

	public Reservation(int wanted) {
		super();
		this.wanted = wanted;
	}
	@Override
	public void run() {
		bookTicket();
	}

	public void bookTicket() { //

		String tname = Thread.currentThread().getName();
		System.out.println("Avaibale Seats for  "+tname+" is :"+ noOfSeats);
		
		synchronized (this) {
			
		}
		
		synchronized (this) {
			
		}

		synchronized (this) {
		
			if (noOfSeats >= wanted) {
				System.out.println("Trying to book " + wanted + " seats for " + tname);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				noOfSeats = noOfSeats - wanted;
				System.out.println("Booked " + wanted + " Seats for " + tname);
				System.out.println("Avaiable Seats: " + noOfSeats);
			} else {
				System.out.println("No more seats avaible for " + tname);
			}
		}

	}
}

public class RedBus {
	public static void main(String[] args) {

		Reservation r1 = new Reservation(1);

		Thread p1 = new Thread(r1, "Passenger-1");
		Thread p2 = new Thread(r1, "Passenger-2");

		p1.start();
		p2.start();

	}

}
