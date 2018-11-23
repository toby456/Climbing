
package com.qa.service.business;

import javax.inject.Inject;

import com.qa.persistence.Repo.UserDBRepository;
import com.qa.persistence.Repo.UserDBRepository;

public class UserServiceImpl implements UserService {

	@Inject
	private UserDBRepository repo;
	
	@Override
	public String getAllUsers() {
		return repo.getAllUsers();
		
	}

	@Override
	public String createUser(String user) {
		return repo.createUser(user);
	}

}
 