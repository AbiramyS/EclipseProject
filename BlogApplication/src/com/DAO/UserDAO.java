package com.DAO;

import java.util.List;

import com.model.User;

public interface UserDAO {
	
	int addUser(User u);
	int updateUser(User u);
	int deleteUser(User u);
	List<User> getListOfUser();
	User getUser(String email, String password);
	

}
