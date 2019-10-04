package com.revature.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import static com.revature.util.LoggerUtil.*;
import com.revature.pojos.OfferList;
import com.revature.pojos.Offerings.Status;
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
			warn("This Offer List Does not Exist!");
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
			error("The file was not found!");
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
			trace("Offer List does exist");
			
		}
		if(fileExist == false) {
			warn("Offer List doesn't exist");
		
		}
		return fileExist;
	}
	@Override
	public void addOffer() {
		// TODO Auto-generated method stub
		boolean chk = checkOfferList();
		if(chk == false) {
			System.out.println("Check your OfferList");
			warn("Check the offerlist");
		}else {
		readOfferList();
		userList.getUserList().add(oF.createOffer());
		createOfferList();
		}
		
	}
	@Override
	public void deleteOffer() {
		Scanner keyboard = new Scanner (System.in);
		String user;
		String vinNo;
		System.out.println("Enter user: ");
		user = keyboard.nextLine();
		System.out.println("Enter vinNo: ");
		vinNo = keyboard.nextLine();
		boolean chk = checkOfferList();
		if(chk == false) {
			warn("Check your offer list");
		}else {
		readOfferList();
		for(int x = 0; x <userList.getUserList().size();x++) {
			if(user.equals(userList.getUserList().get(x).getUserName()) && vinNo.equals(userList.getUserList().get(x).getVinNo())) {
				userList.getUserList().remove(x);
				createOfferList();
				}else {
					warn("Offer does not exist!");
				}
			}
		}
	}
	@Override
	public void viewOfferList() {
		// TODO Auto-generated method stub
		
		readOfferList();
		for(int x = 0; x <userList.getUserList().size();x++) {
		System.out.println("User: " + userList.getUserList().get(x).getUserName());	
		System.out.println("Vin No: " + userList.getUserList().get(x).getVinNo());	
		System.out.println("Offer: " + userList.getUserList().get(x).getOffer());	
		System.out.println("Status: " + userList.getUserList().get(x).getStatus());	
		System.out.println("-------------------");
		}
		
	}
	@Override
	public void viewUserOffer() {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner (System.in);
		String user;
		System.out.println("Enter user: ");
		user = keyboard.nextLine();
		boolean chk = checkOfferList();
		if(chk == false) {
			warn("Check your offer list");
		}else {
		readOfferList();
		for(int x = 0; x <userList.getUserList().size();x++) {
			if(user.equals(userList.getUserList().get(x).getUserName())) {
				System.out.println("User: " + userList.getUserList().get(x).getUserName());	
				System.out.println("Vin No: " + userList.getUserList().get(x).getVinNo());	
				System.out.println("Offer: " + userList.getUserList().get(x).getOffer());	
				System.out.println("Status: " + userList.getUserList().get(x).getStatus());	
				System.out.println("-------------------");
						}
					
				}
			}
		
	}
	@Override
	public void setOfferStatus() {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner (System.in);
		String user;
		String vinNo;
		String setter;
		System.out.println("Enter user: ");
		user = keyboard.nextLine();
		System.out.println("Enter vinNo: ");
		vinNo = keyboard.nextLine();
		boolean chk = checkOfferList();
		if(chk == false) {
			warn("Check your offer list");
		}else {
		readOfferList();
		for(int x = 0; x <userList.getUserList().size();x++) {
			if(user.equals(userList.getUserList().get(x).getUserName()) && vinNo.equals(userList.getUserList().get(x).getVinNo())) {
				System.out.println("Enter status: a/r ACCEPT OR REJECT");
				setter = keyboard.nextLine().toLowerCase();
				while(!setter.equals("a") && !setter.equals("r")) {
					System.out.println("Invalid choice!");
					System.out.println("Does this car have an owner?: yes/no");
					setter = keyboard.next().toLowerCase();
				}
				if(setter.equals("a")) {
					userList.getUserList().get(x).setStatus(Status.ACCEPTED);
				}
				if(setter.equals("r")) {
					userList.getUserList().get(x).setStatus(Status.REJECTED);
				}
				createOfferList();
				}else {
					warn("Offer does not exist!");
				}
			}
		}
		
	}
	
	
	
	
		
}


