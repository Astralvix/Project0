package com.revature.service;

import static com.revature.util.LoggerUtil.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.revature.util.ConnectionFactory;
import com.revature.p2.CarServiceP2;
import com.revature.pojos.Car;

public class CarServicePostgres implements CarServiceP2 {
	
private Connection conn = ConnectionFactory.getConnection();
	
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void createCarSQL(Car c) {
		// TODO Auto-generated method stub
		
		String sql = "insert into cardealer.car (vinnum, make, model, color, yearnum, cartype, price, ownername) values('"
		+ c.getVinNo()+"','"+c.getMake()+"','"+ c.getModel()+"','"+c.getColor()+"','"+c.getYear()+"','"
		+c.getCarType()+"',"+c.getPrice()+",'"+c.getOwner()+"');";
		try {
			conn.createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Car getCar(String vin) {
		// TODO Auto-generated method stub
		
		String sql = "select * from cardealer.car where vinnum = ?";
		PreparedStatement stmt;
		Car car = new Car();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vin);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				car.setVinNo(rs.getString(1));
				car.setMake(rs.getString(2));
				car.setModel(rs.getString(3));
				car.setColor(rs.getString(4));
				car.setYear(rs.getString(5));
				car.setCarType(rs.getString(6));
				car.setPrice(rs.getDouble(7));
				car.setOwner(rs.getString(8));
			}
	}catch (SQLException e) {
		e.printStackTrace();
	}
		return car;
	}

	@Override
	public List<Car> getAllCars() {
		// TODO Auto-generated method stub
		
		List<Car> listOfCar = new ArrayList<>();
		PreparedStatement stmt;
		String sql = "select * from cardealer.car;";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Car car = new Car();
				car.setVinNo(rs.getString(1));
				car.setMake(rs.getString(2));
				car.setModel(rs.getString(3));
				car.setColor(rs.getString(4));
				car.setYear(rs.getString(5));
				car.setCarType(rs.getString(6));
				car.setPrice(rs.getDouble(7));
				car.setOwner(rs.getString(8));
				listOfCar.add(car);
			}
		
		
	}catch (SQLException e) {
		e.printStackTrace();
	}
		return listOfCar;
	}

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
		
		//keyboard.close();
		trace("Car has been made");
		return c;
	}

@Override
public List<Car> getMyCars(String username) {
	List<Car> listOfCar = new ArrayList<>();
	PreparedStatement stmt;
	String sql = "select * from cardealer.car where car.ownername=?;";
	try {
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, username);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Car car = new Car();
			car.setVinNo(rs.getString(1));
			car.setMake(rs.getString(2));
			car.setModel(rs.getString(3));
			car.setColor(rs.getString(4));
			car.setYear(rs.getString(5));
			car.setCarType(rs.getString(6));
			car.setPrice(rs.getDouble(7));
			car.setOwner(rs.getString(8));
			listOfCar.add(car);
		}
	
	
}catch (SQLException e) {
	e.printStackTrace();
}
	return listOfCar;
}

@Override
public List<Car> getMostCars() {
	List<Car> listOfCar = new ArrayList<>();
	PreparedStatement stmt;
	String sql = "select * from cardealer.car where car.ownername='';";
	try {
		stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Car car = new Car();
			car.setVinNo(rs.getString(1));
			car.setMake(rs.getString(2));
			car.setModel(rs.getString(3));
			car.setColor(rs.getString(4));
			car.setYear(rs.getString(5));
			car.setCarType(rs.getString(6));
			car.setPrice(rs.getDouble(7));
			car.setOwner(rs.getString(8));
			listOfCar.add(car);
		}
	
	
}catch (SQLException e) {
	e.printStackTrace();
}
	return listOfCar;
	}

@Override
public void updateOwner(String vinnum, String ownername) {
	// TODO Auto-generated method stub
	String sql = "update cardealer.car set ownername = ? where vinnum = ?;"; 
	try {
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, ownername);
		stmt.setString(2, vinnum);
		stmt.executeUpdate();
		trace("Car owner has been updated");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	
	}

@Override
public void deleteCar(String vinnum) {
	// TODO Auto-generated method stub
	String sql = "delete from car where car.vinnum = ?";
	try {
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, vinnum);
		stmt.executeUpdate();
		info("Car has been deleted");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
