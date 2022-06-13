package com;
class Rbi{
	
	public void commonInfo() {
		System.out.println(">>> RBI common guidelines");
	}	
}

class Sbi extends Rbi{

	
	void custData() {
		System.out.println("SBI Cust Data");
	}
	
}
public class UseClass {

	public static void main(String[] args) {
		
	//	Sbi i=new Sbi();
		//i.commonInfo();
		//i.custData();
		
		Rbi r=new Sbi();
		r.commonInfo();
		//r.
		

	}

}
