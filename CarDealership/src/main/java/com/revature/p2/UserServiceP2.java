package com.revature.p2;

import java.util.List;

import com.revature.pojos.User;

public interface UserServiceP2 {

	public User createUser();
	
	public void createUserSQL(User user);
	
	public List<User> getAllUsers();
	
	public User getUser(String username);
}
