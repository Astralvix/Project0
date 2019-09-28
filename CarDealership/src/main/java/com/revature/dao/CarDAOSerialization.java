package com.revature.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.pojos.Car;

public class CarDAOSerialization implements CarDAO {

	public void createCar(Car c) {
		// TODO Auto-generated method stub
		String fileName;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		if(c.getVinNo() !=null) {
			fileName = c.getVinNo()+".dat";
		}
		else {
			fileName = "MysteryMachine.dat";
		}
		
		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(c);
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

	public Car readCar(String vin) {
		// TODO Auto-generated method stub
String fileName = vin+".dat";
		
		Car ret = null;
		//try with resources
		try (FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis);){
			
			try {
				ret = (Car) ois.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				return ret;
	}

}
