package com.revature.service;
import static com.revature.util.LoggerUtil.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import com.revature.pojos.User;
import com.revature.pojos.User.Role;

public class LoginServiceImpl implements LoginService {

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
			warn("This username is taken");
			warn("Enter Desired Username");
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
			user.setRole(User.Role.CUSTOMER);
			
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
			
			error("This user already exists!");
			
		}
		
	}

	@Override
	public boolean checkLogin() {
		
		User userCHK = null;
		Scanner keyboard = new Scanner (System.in);
		String username;
		String password;
		trace("Check if username exists");
		username = keyboard.nextLine();
		File tmpDir = new File(username +".dat");
		boolean fileExist = tmpDir.exists();
		while(fileExist == false) {
			warn("This username isnt registered");
			warn("Check if username exists");
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
			error("The file was not found!");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(username.equals(userCHK.getUserName()) && password.equals(userCHK.getPassWord())) {
			trace("It was true");
			return true;
		}else {
			trace("It was false");
		return false;
		}
	}
}
