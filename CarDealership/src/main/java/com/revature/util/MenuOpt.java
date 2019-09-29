package com.revature.util;

public class MenuOpt {
	
	
	public void initialMenu() {
		System.out.println("Intial Menu");
		System.out.println("1.Create User");
		System.out.println("2.Login");
	}
	
	public void customerMenu() {
		System.out.println("Customer Menu");
		System.out.println("1.View Cars On Lot");
		System.out.println("2.View Owned Cars");
		System.out.println("3.View remaining payments");
		System.out.println("4.Make An Offer");
	}

	public void employeeMenu() {
		System.out.println("Employee Menu");
		System.out.println("1.Add Car To Lot");
		System.out.println("2. Reject Or Accept Offer");
		System.out.println("3.Remove Car From Lot");
		System.out.println("4.View All Payments");
	}
}
