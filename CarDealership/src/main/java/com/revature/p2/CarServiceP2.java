package com.revature.p2;

import java.util.List;

import com.revature.pojos.Car;

public interface CarServiceP2 {

	public Car createCar();
	
	public void createCarSQL(Car c);
	
	public Car getCar(String vin);
	
	public List<Car> getAllCars();
	
	public List<Car> getMyCars(String username);
	
	public List<Car> getMostCars();
	
	public void updateOwner(String vinnum, String ownername);
	
	public void deleteCar(String vinnum);
	
}
