package com.revature.dao;

import com.revature.pojos.CarLot;

public interface CarLotDao {
	
	public void createLot();
	
	public CarLot readLot();
	
	public boolean checkLot();
	
	public void addCar();
	
	public void deleteCar();
	
	public void viewLot();
	
	public void viewLotCust();
	
	public void setOwner();

}
