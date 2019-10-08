package com.revature.service;

import static com.revature.util.LoggerUtil.warn;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.p2.UserServiceP2;
import com.revature.pojos.User;
import com.revature.util.ConnectionFactory;

public class UserServicePostgres implements UserServiceP2 {

private Connection conn = ConnectionFactory.getConnection();
	
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public User createUser() {
		// TODO Auto-generated method stub
		User user = new User();
		
		Scanner keyboard = new Scanner (System.in);
		String firstname; 
		String lastname; 
		String username; 
		String password; 
		String role;
		
			System.out.println("Enter Username");
			username = keyboard.nextLine();
			user.setUserName(username); 
			System.out.println("Enter First Name: ");
			firstname = keyboard.nextLine();
			user.setFirstName(firstname);
			System.out.println("Enter Last Name");
			lastname = keyboard.nextLine();
			user.setLastName(lastname);
			System.out.println("Choose your password");
			password = keyboard.nextLine();
			user.setPassWord(password);
			System.out.println("Choose your role");
			role = keyboard.nextLine();
			user.setRole(role);		
	
		return user;	 
	}

	@Override
	public void createUserSQL(User user) {
		// TODO Auto-generated method stub
		PreparedStatement stmt;
		String sql = "insert into cardealer.users (username,passwrd,firstname,lastname,roles) values(?,?,?,?,?);";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getPassWord());
			stmt.setString(3, user.getFirstName());
			stmt.setString(4, user.getLastName());
			stmt.setString(5, user.getRole());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		
		List<User> listOfUsers = new ArrayList<>();
		PreparedStatement stmt;
		String sql = "select * from cardealer.users;";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				user.setUserName(rs.getString(1));
				user.setPassWord(rs.getString(2));
				user.setFirstName(rs.getString(3));
				user.setLastName(rs.getString(4));
				user.setRole(rs.getString(5));
				listOfUsers.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOfUsers;
	}
	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		String sql = "select * from cardealer.users where username = ?;";
		PreparedStatement stmt;
		User user = new User();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				user.setUserName(rs.getString(1));
				user.setPassWord(rs.getString(2));
				user.setFirstName(rs.getString(3));
				user.setLastName(rs.getString(4));
				user.setRole(rs.getString(5));	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return user;
	}
	
}
