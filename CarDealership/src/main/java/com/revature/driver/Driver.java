package com.revature.driver;

import com.revature.dao.CarLotDAOSerialization;
import com.revature.dao.CarLotDao;
import com.revature.dao.OfferListDAO;
import com.revature.p2.CarServiceP2;
import com.revature.p2.OfferServiceP2;
import com.revature.p2.UserServiceP2;
import com.revature.service.CarServiceImpl;
import com.revature.service.CarServicePostgres;
import com.revature.pojos.Car;
import com.revature.pojos.User;
import com.revature.service.CarService;
import com.revature.service.LoginService;
import com.revature.service.UserServicePostgres;
import com.revature.util.MenuOpt;
import static com.revature.util.LoggerUtil.*;
import static com.revature.util.MenuOpt.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Driver {

	
	private static CarServiceP2 CS = new CarServicePostgres();
	
	private static UserServiceP2 OS = new UserServicePostgres();
	
	public static void main(String[] args) {
		List<Car> carList = new ArrayList<>();	
		
		  Scanner sc = new Scanner(System.in); 
		  String chk; 
		  boolean toggle = true;
		  
		 rgr:while(toggle) {
			  MenuOpt.initialMenu();
			  String in = sc.nextLine();
			  switch(in) {
			  case "1":
				  System.out.println("Create");
				  	User user = OS.createUser();
					OS.createUserSQL(user);
				  break;
			  case "2":
				  System.out.println("Login");
				  System.out.println("Enter username: ");
				  chk = sc.nextLine();
				  User user1 = OS.getUser(chk);
				  if(user1.getUserName()==(null)) {
					  System.out.println("No user!");
					  continue rgr;
				  }
				  else {
					  info("It does match!");
					  System.out.println("Enter password: ");
					  chk = sc.nextLine();
					  if(user1.getPassWord().equals(chk)) {
						  System.out.println("Password is correct!");
						  info("Passwords matched!");
					  	}else {
					  		System.out.println("Password does not match!");
					  		continue rgr;
					  	}
					  if(user1.getRole().equals("customer")) {
							  while(toggle) {
							  MenuOpt.customerMenu();
							  String in2 = sc.nextLine();
							  switch(in2) {
							  
							  case "1":
								  carList = CS.getMostCars(); 
								  for(int x = 0; x < carList.size(); x++) { 
								  Car carloop = carList.get(x); 
								  System.out.println("Car VinNo: " + carloop.getVinNo()); 
								  System.out.println("Car Make: " +carloop.getMake());
								  System.out.println("Car Model: " + carloop.getModel());
								  System.out.println("Car Year: " + carloop.getYear());
								  System.out.println("Color: " + carloop.getColor());
								  System.out.println("Price: " + carloop.getPrice());
								  System.out.println("CarType: " + carloop.getCarType());
								  System.out.println("Owner: " + carloop.getOwner());
								  System.out.println("---------------------------");} 
								  break;
							  case "2":
								  String u = user1.getUserName();
								  carList = CS.getMyCars(u);
								  for(int x = 0; x < carList.size(); x++) { 
									  Car carloop = carList.get(x); 
									  System.out.println("Car VinNo: " + carloop.getVinNo()); 
									  System.out.println("Car Make: " +carloop.getMake());
									  System.out.println("Car Model: " + carloop.getModel());
									  System.out.println("Car Year: " + carloop.getYear());
									  System.out.println("Color: " + carloop.getColor());
									  System.out.println("Price: " + carloop.getPrice());
									  System.out.println("CarType: " + carloop.getCarType());
									  System.out.println("Owner: " + carloop.getOwner());
									  System.out.println("---------------------------");} 
								  break;
							  case "3":
								  break;
							  case "4":
								  break;
							  case "5":
								  System.out.println("Exit");
									 // toggle = false;
									  continue rgr;
								  default:
									  System.out.println("Invalid Choice!");
									  break;
							  		}
							  }
						  }else if(user1.getRole().equals("employee")) {  
							  while(toggle) {
								  MenuOpt.employeeMenu();
								String in2 = sc.nextLine();
								  switch(in2) {
								 
								  case "1":
									 Car car = CS.createCar(); 
									 CS.createCarSQL(car); 
									  break;
								  case "2":
									  break;
								  case "3":
									  System.out.println("Enter VinNo Of Car To Be Deleted: ");
									  String delete = sc.nextLine();
									  CS.deleteCar(delete);
									  System.out.println("Car Successfully Removed!");
									  break;
								  case "4":
									  break;
								  case "5":
									  /*Steps to print all cars*/
										
										  carList = CS.getAllCars(); 
										  for(int x = 0; x < carList.size(); x++) { 
										  Car carloop = carList.get(x); 
										  System.out.println("Car VinNo: " + carloop.getVinNo()); 
										  System.out.println("Car Make: " +carloop.getMake());
										  System.out.println("Car Model: " + carloop.getModel());
										  System.out.println("Car Year: " + carloop.getYear());
										  System.out.println("Color: " + carloop.getColor());
										  System.out.println("Price: " + carloop.getPrice());
										  System.out.println("CarType: " + carloop.getCarType());
										  System.out.println("Owner: " + carloop.getOwner());
										  System.out.println("---------------------------");} 
									  break;
								  case "6":
									  System.out.println("Enter the vinNo: ");
									  String vinnum = sc.nextLine();
									  System.out.println("Enter the username: ");
									  String username = sc.nextLine();
									  CS.updateOwner(vinnum, username);
									  break;
								  case "7":
									  System.out.println("Exit");
									 // toggle = false;
									  continue rgr;
								 default:
								 System.out.println("Invalid Choice!");
									  break;
										  
								  }
								  
							  }
						  }
				  }
				  break;
			  case "3":
				  System.out.println("Good Bye!");
				  toggle = false;
				  break;
			  default:
				  System.out.println("Invalid Choice!");
				  break;
			  }
		  }
			  

		/*
		 * Car car = CS.createCar(); CS.createCarSQL(car);
		 */
		
		/*Steps to print all cars*/
		/*
		 * carList = CS.getAllCars(); for(int x = 0; x < carList.size(); x++) { Car
		 * carloop = carList.get(x); System.out.println("Car VinNo: " +
		 * carloop.getVinNo()); System.out.println("Car Make: " +carloop.getMake());
		 * System.out.println("Car Model: " + carloop.getModel());
		 * System.out.println("Car Year: " + carloop.getYear());
		 * System.out.println("Color: " + carloop.getColor());
		 * System.out.println("Price: " + carloop.getPrice());
		 * System.out.println("CarType: " + carloop.getCarType());
		 * System.out.println("Owner: " + carloop.getOwner());
		 * System.out.println("---------------------------");}
		 */
		 		 
		 
		
		
		
	}
}
