package com.qa.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.User;
import com.qa.persistence.Repo.UserDBRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class UserDBRepoTest {

	@InjectMocks
	private UserDBRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtil JsonOb;

	private static final String MOCK_ARRAY = "[{\"userName\":\"Toby\"}]";

	private static final String MOCK_OBJECT = "{\"userName\":\"Toby\"}";	
	
	
	@Before
	public void setup() {
		repo.setManager(manager);		
		JsonOb = new JSONUtil();
		repo.setJsonOb(JsonOb);
	}

	@Test
	public void testGetAllUsers() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<User> user = new ArrayList<User>();
		user.add(new User("Toby"));
		Mockito.when(query.getResultList()).thenReturn(user);
		Assert.assertEquals(MOCK_ARRAY, repo.getAllUsers());
	}

	@Test
	public void testCreateUser() {
		String reply = repo.createUser(MOCK_OBJECT);
		Assert.assertEquals(reply, "{\"message\": \"A user has been sucessfully created\"}");
	}

	

}
