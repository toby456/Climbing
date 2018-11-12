package com.qa.persistence.Repo;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.persistence.domain.User;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
public class UserDBRepository{
	
	

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil jsonOb;

	
	
	@Transactional(REQUIRED)
	public String createUser(String user) {
		User aUser = jsonOb.getObjectForJSON(user, User.class);
		manager.persist(aUser);
		return "{\"message\": \"A user has been sucessfully created\"}";
	}

	

	public String getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private User findUser(long id) {
		return manager.find(User.class, id);
	}

}
