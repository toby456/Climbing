package com.qa.persistence.integration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.service.business.UserService;
import com.qa.rest.UserEndpoint;

@RunWith(MockitoJUnitRunner.class)
public class UserEndpointTest {

	private static final String MOCK_VALUE2 = "Toby";

	private static final String MOCK_VALUE = "UserCreated";

	@InjectMocks
	private UserEndpoint endpoint;

	@Mock
	private UserService service;

	@Before
	public void setup() {
		endpoint.setService(service);
	}

	@Test
	public void testGetAllUsers() {
		Mockito.when(service.getAllUsers()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.getAllUsers());
	}

	@Test
	public void testCreateUser() {
		Mockito.when(service.createUser(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.addUser(MOCK_VALUE2));
		Mockito.verify(service).createUser(MOCK_VALUE2);
	}

	

}

