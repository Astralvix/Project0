package com.revature.driver;

import com.revature.dao.CarLotDAOSerialization;
import com.revature.dao.CarLotDao;
import com.revature.dao.OfferListDAO;
import com.revature.dao.OfferListSerialization;
import com.revature.service.CarServiceImpl;
import com.revature.pojos.User;
import com.revature.service.CarService;
import com.revature.service.EmployeeServiceImpl;
import com.revature.service.LoginService;
import com.revature.service.LoginServiceImpl;
import com.revature.util.MenuOpt;

import static com.revature.util.MenuOpt.*;

import java.util.Scanner;
public class Driver {

	
	private static LoginService loginservice = new LoginServiceImpl();
	
	private static LoginService LS = new EmployeeServiceImpl();
	
	private static CarLotDao CLD = new CarLotDAOSerialization();
	
	private static CarService CS = new CarServiceImpl();
	
	private static OfferListDAO OFD = new OfferListSerialization();
	
	public static void main(String[] args) {
		
		User user = new User();
		Scanner sc = new Scanner(System.in);
		String chk;
		//loginservice.createUser();
		//MenuOpt.initialMenu();
		//chk = sc.nextLine();
			
		
		
		
		//LS.createUser();
		//LS.checkLogin();
		
		
		//CLD.checkLot();
		//CLD.createLot();
		
		//CLD.addCar();
		//CLD.deleteCar();
		//System.out.println(CLD.readLot());
		//CLD.viewLot();
		//CLD.viewLotCust();
		//OFD.createOfferList();
		//OFD.addOffer();
		//OFD.viewOfferList();
		//OFD.setOfferStatus();
		//OFD.viewOfferList();
		CLD.viewLot();
		CLD.setOwner();
		CLD.viewLot();
		
		
	}
}
