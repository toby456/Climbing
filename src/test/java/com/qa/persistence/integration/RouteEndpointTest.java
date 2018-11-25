package com.qa.persistence.integration;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.service.business.RouteService;
import com.qa.rest.RouteEndpoint;

@RunWith(MockitoJUnitRunner.class)
public class RouteEndpointTest {

	private static final String MOCK_ROUTE = "ROUTE";

	private static final String MOCK_VALUE = "ROUTE_2";
	
	private static final String MOCK_DELETE = "Route Deleted";
	
	private static final String MOCK_UPDATE = "Route updated";

	@InjectMocks
	private RouteEndpoint endpoint;

	@Mock
	private RouteService service;

	@Before
	public void setup() {
		endpoint.setService(service);
	}

	@Test
	public void testGetAllRoutes() {
		Mockito.when(service.getAllRoutes()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.getAllRoutes());
	}
	
	@Test
	public void testGetRoute() {
		Mockito.when(service.getRoute(1L)).thenReturn(MOCK_ROUTE);
		Assert.assertEquals(MOCK_ROUTE, endpoint.getRoute(1L));
	}

	@Test
	public void testCreateRoute() {
		Mockito.when(service.createRoute(MOCK_ROUTE)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.addRoute(MOCK_ROUTE));
		Mockito.verify(service).createRoute(MOCK_ROUTE);
	}
	
	@Test
	public void testDeleteRoute() {
		Mockito.when(service.deleteRoute(1L)).thenReturn(MOCK_DELETE);
		Assert.assertEquals(MOCK_DELETE, endpoint.deleteRoute(1L));
		Mockito.verify(service).deleteRoute(1L);
	} 
	
	@Test
	public void testUpdateRoute() {
		Mockito.when(service.updateRoute(MOCK_ROUTE)).thenReturn(MOCK_UPDATE);
		assertEquals(MOCK_UPDATE, endpoint.updateRoute(MOCK_ROUTE));
		Mockito.verify(service).updateRoute(MOCK_ROUTE);
	}
	


	

}
