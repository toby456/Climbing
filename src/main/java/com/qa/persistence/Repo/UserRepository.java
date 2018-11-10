package com.qa.persistence.Repo;

public interface UserRepository {
	
	String createUser(String create);
	String deleteUser(long userID);
	String getAllUsers();

}
