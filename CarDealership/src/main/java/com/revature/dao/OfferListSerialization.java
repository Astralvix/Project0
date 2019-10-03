package com.revature.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static com.revature.util.LoggerUtil.*;
import com.revature.pojos.CarLot;
import com.revature.pojos.OfferList;
import com.revature.service.OfferService;
import com.revature.service.OfferServiceImpl;

public class OfferListSerialization implements OfferListDAO{

	public OfferList userList = new OfferList();
	public OfferService oF = new OfferServiceImpl();	
	
	@Override
	public void createOfferList() {
		// TODO Auto-generated method stub
		String fileName = "OfferLIST.dat";
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		//Scanner keyboard = new Scanner (System.in);
		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(userList);
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
	public OfferList readOfferList() {
		// TODO Auto-generated method stub
		String fileName = "OfferLIST.dat";
		File tmpDir = new File(fileName);
		boolean fileExist = tmpDir.exists();
		while(fileExist == false) {
			System.out.println("This Offer List Does not Exist!");
				break;
			
			}
		if(fileExist == true){
		
		try (FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis);){
			
			try {
				userList = (OfferList) ois.readObject();
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
		return userList;		
		
	}
	@Override
	public boolean checkOfferList() {
		// TODO Auto-generated method stub
		String fileName = "OfferLIST.dat";
		
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
		
}


