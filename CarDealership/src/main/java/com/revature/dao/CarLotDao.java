package com.revature.dao;

import com.revature.pojos.CarLot;

public interface CarLotDao {
	
	public void createLot();
	
	public CarLot readLot();
	
	public void checkLot();
	
	public CarLot addCar();

}
