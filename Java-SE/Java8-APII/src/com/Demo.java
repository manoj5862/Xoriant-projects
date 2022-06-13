package com;

public class Demo {

	public static void main(String[] args) {
		
		Comparable<String> comp=(str)->{
			return str.compareTo("HYD-1");
		};
		
	    int x=comp.compareTo("HYD");
	    if(x==0) {
	    	System.out.println("Equals");
	    }else {
	    	System.out.println("Not Equals");
	    }

	}

}
