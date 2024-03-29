package com.revature.service;
import static com.revature.util.LoggerUtil.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.pojos.Car;
import com.revature.pojos.CarLot;
import com.revature.service.CarService;

public class CarServiceImpl implements CarService {

	public Car createCar() {
		
		Car c = new Car();
		Scanner keyboard = new Scanner (System.in);
		 String model;
		 String year;
		 String check;
		 String vinNo;
		 String color;
		 String make;
		 String carType;
		 double price;
		 String owner;
		System.out.println("Car Model:");
		model = keyboard.nextLine();
		c.setModel(model);
		System.out.println("Car Make:");
		make = keyboard.nextLine();
		c.setMake(make);
		System.out.println("Car Year:");
		year = keyboard.nextLine();
		c.setYear(year);
		System.out.println("Car vinNo:");
		vinNo = keyboard.nextLine();
		c.setVinNo(vinNo);
		System.out.println("Car color:");
		color = keyboard.nextLine();
		c.setColor(color);
		System.out.println("Car Type:");
		carType = keyboard.nextLine();
		c.setCarType(carType);
		System.out.println("Car Price:");
		price = keyboard.nextDouble();
		c.setPrice(price);
		keyboard.nextLine();
		System.out.println("Does this car have an owner?: yes/no");
		check = keyboard.nextLine().toLowerCase();
		while(!check.equals("yes") && !check.equals("no")) {
			System.out.println("Invalid choice!");
			System.out.println("Does this car have an owner?: yes/no");
			check = keyboard.next().toLowerCase();
		}
		if(check.equals("no")) {
			trace("No owner has been set");
			c.setOwner("");
		}
		if(check.equals("yes")){
		System.out.println("Owner:");
		owner = keyboard.nextLine();
		c.setOwner(owner);
		trace("Owner has been set by name: "+ c.getOwner());
		}
		
		keyboard.close();
		trace("Car has been made");
		return c;
	}

}
