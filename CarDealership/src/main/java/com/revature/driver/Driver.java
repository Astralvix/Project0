package com.revature.driver;

import com.revature.dao.CarLotDAOSerialization;
import com.revature.dao.CarLotDao;
import com.revature.dao.CarServiceImpl;
import com.revature.pojos.User;
import com.revature.service.CarService;
import com.revature.service.EmployeeServiceImpl;
import com.revature.service.LoginService;
import com.revature.service.LoginServiceImpl;

public class Driver {

	
	private static LoginService loginservice = new LoginServiceImpl();
	
	private static LoginService LS = new EmployeeServiceImpl();
	
	private static CarLotDao CLD = new CarLotDAOSerialization();
	
	private static CarService CS = new CarServiceImpl();
	public static void main(String[] args) {
		
		//User user = new User();
		
		//loginservice.createUser();
		
		//loginservice.checkLogin();
		
		//LS.createUser();
		//LS.checkLogin();
		
		CLD.checkLot();
		CLD.createLot();
		
		CLD.addCar();
		CLD.readLot();
		
		
	}
}
