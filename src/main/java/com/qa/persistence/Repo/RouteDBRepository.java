package com.qa.persistence.Repo;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Route;
import com.qa.persistence.domain.User;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
public class RouteDBRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil jsonOb;
	
	@Transactional(REQUIRED)
	public String createRoute(String route) {
		Route aRoute = jsonOb.getObjectForJSON(route, Route.class);
		manager.persist(aRoute);
		return "{\"message\": \"A user has been sucessfully created\"}";
	}
	
	
	@Transactional(REQUIRED)
	public String updateClassroom(String classroomToUpdate) {
		Route updatedRoute = jsonOb.getObjectForJSON(classroomToUpdate, Route.class);
		Route routeFromDB = findRoute(updatedRoute.getRouteID());
		if (routeFromDB != null) {
			manager.merge(updatedRoute);
			return "{\"message\": \"Route sucessfully updated\"}";
		}
		else return "{\"message\": \"Route does not exist\"}";
	

}
	
	private Route findRoute(long id) {
		return manager.find(Route.class, id);
	}
	
}
