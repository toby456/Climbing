package com.qa.service.business;

import javax.inject.Inject;

import com.qa.persistence.Repo.UserDBRepository;
import com.qa.persistence.Repo.UserDBRepository;

public class UserService {
	
	@Inject
	private UserDBRepository repo;

	
	
	public String createUser(String user) {
		return repo.createUser(user);	
	}

	

}
