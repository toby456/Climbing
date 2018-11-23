package com.qa.persistence.Repo;

import javax.inject.Inject;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.persistence.domain.Route;
import com.qa.persistence.domain.User;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
public class UserDBRepository{
	
	

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil jsonOb;

	public String getAllUsers() {
		Query query = manager.createQuery("SELECT a FROM User a");
		Collection<User> user = (Collection<User>) query.getResultList();
		return jsonOb.getJSONForObject(user);
	}
	
	
	@Transactional(REQUIRED)
	public String createUser(String user) {
		User aUser = jsonOb.getObjectForJSON(user, User.class);
		manager.persist(aUser);
		return "{\"message\": \"A user has been sucessfully created\"}";
	}
	
	private User findUser(long id) {
		return manager.find(User.class, id);
	}
	
	

}
