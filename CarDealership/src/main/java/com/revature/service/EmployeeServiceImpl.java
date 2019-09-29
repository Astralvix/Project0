package com.revature.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import com.revature.pojos.User;

public class EmployeeServiceImpl implements LoginService {

	@Override
	public void createUser() {
		// TODO Auto-generated method stub
		User user = new User();
		String fileName;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		Scanner keyboard = new Scanner (System.in);
		String firstname; 
		String lastname; 
		String username; 
		String password; 
	
		System.out.println("Enter Desired Username");
		username = keyboard.nextLine();
		File tmpDir = new File(username +".dat");
		boolean fileExist = tmpDir.exists();
		while(fileExist == true) {
			System.out.println("This username is taken");
			System.out.println("Enter Desired Username");
			username = keyboard.nextLine();
			tmpDir = new File(username +".dat");
			fileExist = tmpDir.exists();
			}
		if(fileExist == false) {
			System.out.println("Enter Username");
			username = keyboard.nextLine();
			user.setUserName(username); 
			fileName = user.getUserName()+".dat";
			System.out.println("Enter First Name: ");
			firstname = keyboard.nextLine();
			user.setFirstName(firstname);
			System.out.println("Enter Last Name");
			lastname = keyboard.nextLine();
			user.setLastName(lastname);
			System.out.println("Choose your password");
			password = keyboard.nextLine();
			user.setPassWord(password);
			user.setRole(User.Role.EMPLOYEE);
			
			try {
				fos = new FileOutputStream(fileName);
				oos = new ObjectOutputStream(fos);
				
				oos.writeObject(user);
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

			
		}else {
			
			System.out.println("This user already exists!");
			
		}
		
		
	}

	@Override
	public boolean checkLogin() {
		// TODO Auto-generated method stub
		User userCHK = null;
		Scanner keyboard = new Scanner (System.in);
		String username;
		String password;
		System.out.println("Check if username exists");
		username = keyboard.nextLine();
		File tmpDir = new File(username +".dat");
		boolean fileExist = tmpDir.exists();
		while(fileExist == false) {
			System.out.println("This username isnt registered");
			System.out.println("Check if username exists");
			username = keyboard.nextLine();
			tmpDir = new File(username +".dat");
			fileExist = tmpDir.exists();
			}
		System.out.println("Enter Username");
		username = keyboard.nextLine();
		String temp = username;
		String fileName = temp + ".dat";
		System.out.println("Enter password");
		password = keyboard.nextLine();
		
		try (FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis);){
			
			try {
				userCHK = (User) ois.readObject();
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
		if(username.equals(userCHK.getUserName()) && password.equals(userCHK.getPassWord())) {
			System.out.println("It was true");
			return true;
		}else {
			System.out.println("It was false");
		return false;
		}
	}	
	
}


