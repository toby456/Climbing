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

import com.qa.persistence.domain.Route;
import com.qa.persistence.Repo.RouteDBRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class RouteDBRepoTest {

	@InjectMocks
	private RouteDBRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtil JsonOb;

	private static final String MOCK_ARRAY = "[{\"climbStatus\":\"Progress\",\"routeName\":\"red\",\"difficulty\":\"v6\",\"location\":\"depot\",\"typeOfClimb\":\"boulder\",\"climbDescription\":\"hard\",\"crux\":\"2nd move\",\"userID\":1}]";

	private static final String MOCK_OBJECT = "{\"climbStatus\":\"Progress\",\"routeName\":\"red\",\"difficulty\":\"v6\",\"location\":\"depot\",\"typeOfClimb\":\"boulder\",\"climbDescription\":\"hard\",\"crux\":\"2nd move\",\"userID\":1}";
	
	private static final String MOCK_UPDATE = "{\"climbStatus\":\"complete\",\"routeName\":\"red\",\"difficulty\":\"v6\",\"location\":\"depot\",\"typeOfClimb\":\"boulder\",\"climbDescription\":\"very hard\",\"crux\":\"2nd move\",\"userID\":1}";

	@Before
	public void setup() {
		repo.setManager(manager);		
		JsonOb = new JSONUtil();
		repo.setJsonOb(JsonOb);
	}

	@Test
	public void testGetAllRoutes() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Route> routes = new ArrayList<Route>();
		routes.add(new Route("Progress", "red", "v6", "depot", "boulder", "hard", "2nd move", 1l));
		Mockito.when(query.getResultList()).thenReturn(routes);
		Assert.assertEquals(MOCK_ARRAY, repo.getAllRoutes());
	}

	@Test
	public void testCreateRoute() {
		String reply = repo.createRoute(MOCK_OBJECT);
		Assert.assertEquals(reply, "{\"message\": \"A route has been sucessfully created\"}");
	}

	@Test
	public void testDeleteRoute() {
		Route updatedRoute=new Route("Progress", "red", "v6", "depot", "boulder", "hard", "2nd move", 1l);
		Mockito.when(manager.find(Route.class, 1l)).thenReturn(updatedRoute);
		Assert.assertEquals("{\"message\": \"Route sucessfully deleted\"}", repo.deleteRoute(1l));
	}
	

}
