package com.revature.driver;

import com.revature.dao.CarLotDAOSerialization;
import com.revature.dao.CarLotDao;
import com.revature.pojos.User;
import com.revature.service.EmployeeServiceImpl;
import com.revature.service.LoginService;
import com.revature.service.LoginServiceImpl;

public class Driver {

	
	private static LoginService loginservice = new LoginServiceImpl();
	
	private static LoginService LS = new EmployeeServiceImpl();
	
	private static CarLotDao CLD = new CarLotDAOSerialization();
	public static void main(String[] args) {
		
		//User user = new User();
		
		//loginservice.createUser();
		
		//loginservice.checkLogin();
		
		//LS.createUser();
		//LS.checkLogin();
		
		
	}
}
