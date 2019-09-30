package com.revature.dao;

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

public class CarLotDAOSerialization implements CarLotDao{
	
	public CarLot carLot = new CarLot();
	public CarService CS = new CarServiceImpl();

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
			System.out.println("This carlot doesnt exist");
				break;
			
			}
		if(fileExist == true){
		
		try (FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis);){
			
			try {
				carLot = (CarLot) ois.readObject();
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
			System.out.println("Lot exists!");
			
		}
		if(fileExist == false) {
			System.out.println("Lot doesn't exist!");
		
		}
		return fileExist;
	}

	@Override
	public void addCar() {
		// TODO Auto-generated method stub
		boolean chk = checkLot();
		if(chk == false) {
			System.out.println("Check your lot");
		}else {
		carLot.getCarLot().add(CS.createCar());
		createLot();
		}
	}
}
