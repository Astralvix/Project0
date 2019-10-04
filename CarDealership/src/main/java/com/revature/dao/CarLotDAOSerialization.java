package com.revature.dao;
import static com.revature.util.LoggerUtil.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import com.revature.pojos.Car;
import com.revature.pojos.CarLot;
import com.revature.pojos.User;
import com.revature.service.CarService;
import com.revature.service.CarServiceImpl;

public class CarLotDAOSerialization implements CarLotDao{
	
	public CarLot carLot = new CarLot();
	public CarService CS = new CarServiceImpl();
	//public Car c = new Car();

	@Override
	public void createLot() {
		// TODO Auto-generated method stub
		String fileName = "CarLOT.dat";
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		//Scanner keyboard = new Scanner (System.in);
		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(carLot);
			trace("Carlot overwritten");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			if(oos != null) {
				
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public CarLot readLot() {
		// TODO Auto-generated method stub
		String fileName = "CarLOT.dat";
		File tmpDir = new File(fileName);
		boolean fileExist = tmpDir.exists();
		while(fileExist == false) {
			warn("Carlot doesn't exist");
			System.out.println("This carlot doesnt exist");
				break;
			
			}
		if(fileExist == true){
		
		try (FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis);){
			
			try {
				carLot = (CarLot) ois.readObject();
				trace("Carlot has been read");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("The file was not found!");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		}
		return carLot;		
	}

	@Override
	public boolean checkLot() {
		String fileName = "CarLOT.dat";
		
		File tmpDir = new File(fileName);
		boolean fileExist = tmpDir.exists();
		
		if(fileExist == true) {
			trace("Lot exists!");
			
		}
		if(fileExist == false) {
			warn("Lot doesn't exist!");
		
		}
		return fileExist;
	}

	@Override
	public void addCar() {
		// TODO Auto-generated method stub
		boolean chk = checkLot();
		if(chk == false) {
			System.out.println("Check your lot");
			warn("Check the lot");
		}else {
		readLot();
		carLot.getCarLot().add(CS.createCar());
		createLot();
		trace("Car has been added!");
		}
	}

	@Override
	public void deleteCar() {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner (System.in);
		String vin;
		System.out.println("Enter the vin No: ");
		vin = keyboard.nextLine();
		boolean chk = checkLot();
		if(chk == false) {
			warn("Check your lot");
		}else {
		readLot();
		for(int x = 0; x <carLot.getCarLot().size();x++) {
			if(vin.equals(carLot.getCarLot().get(x).getVinNo())) {
				carLot.getCarLot().remove(x);
				createLot();
				}else {
					System.out.println("Car doesn't exist!");
					warn("Car does not exist!");
				}
		}
		
		
		}

	}

	@Override
	public void viewLot() {
		// TODO Auto-generated method stub
		readLot();
		for(int x = 0; x <carLot.getCarLot().size();x++) {
		System.out.println("Car Make: " + carLot.getCarLot().get(x).getMake());	
		System.out.println("Car Model: " + carLot.getCarLot().get(x).getModel());	
		System.out.println("Car Year: " + carLot.getCarLot().get(x).getYear());	
		System.out.println("Car Color: " +carLot.getCarLot().get(x).getColor());	
		System.out.println("Car Price: $" +carLot.getCarLot().get(x).getPrice());	
		System.out.println("Car VinNo: " +carLot.getCarLot().get(x).getVinNo());
		System.out.println("Car Type: " +carLot.getCarLot().get(x).getCarType());
		System.out.println("Car Owner: " +carLot.getCarLot().get(x).getOwner());
		System.out.println("-------------------");
		}
		
	}

	@Override
	public void viewLotCust() {
		// TODO Auto-generated method stub
		readLot();
		for(int x = 0; x <carLot.getCarLot().size();x++) {
			if(carLot.getCarLot().get(x).getOwner().equals("")) {
				System.out.println("Car Make: " + carLot.getCarLot().get(x).getMake());	
				System.out.println("Car Model: " + carLot.getCarLot().get(x).getModel());	
				System.out.println("Car Year: " + carLot.getCarLot().get(x).getYear());	
				System.out.println("Car Color: " +carLot.getCarLot().get(x).getColor());	
				System.out.println("Car Price: $" +carLot.getCarLot().get(x).getPrice());	
				System.out.println("Car VinNo: " +carLot.getCarLot().get(x).getVinNo());
				System.out.println("Car Type: " +carLot.getCarLot().get(x).getCarType());
				System.out.println("Car Owner: " +carLot.getCarLot().get(x).getOwner());
				System.out.println("-------------------");
				}else {
					
				}
			}
		}

	@Override
	public void setOwner() {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner (System.in);
		String vin;
		String owner;
		System.out.println("Enter the vin No: ");
		vin = keyboard.nextLine();
		boolean chk = checkLot();
		if(chk == false) {
			warn("Check your lot");
		}else {
		readLot();
		for(int x = 0; x <carLot.getCarLot().size();x++) {
			if(vin.equals(carLot.getCarLot().get(x).getVinNo())) {
				System.out.println("Set the owner: ");
				owner = keyboard.nextLine();
				carLot.getCarLot().get(x).setOwner(owner);
				createLot();	
					}
				}
			}
		}
}
