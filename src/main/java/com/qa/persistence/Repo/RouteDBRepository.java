package com.qa.persistence.Repo;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import com.qa.persistence.domain.Route;
import com.qa.persistence.domain.User;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
public class RouteDBRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil jsonOb;

	public String getAllRoutes() {
		Query query = manager.createQuery("SELECT a FROM Route a");
		Collection<Route> route = (Collection<Route>) query.getResultList();
		return jsonOb.getJSONForObject(route);
	}
	
	public String getRoute(long id) {
		Route routeInDB = findRoute(id);
		return jsonOb.getJSONForObject(routeInDB);
	}

	@Transactional(REQUIRED)
	public String createRoute(String route) {
		Route aRoute = jsonOb.getObjectForJSON(route, Route.class);
		manager.persist(aRoute);
		return "{\"message\": \"A route has been sucessfully created\"}";
	}

	@Transactional(REQUIRED)
	public String updateRoute(String routeToUpdate) {
		Route updatedRoute = jsonOb.getObjectForJSON(routeToUpdate, Route.class);
		System.out.println(updatedRoute.getrouteID());
		Route routeFromDB = findRoute(updatedRoute.getrouteID());
		if (routeFromDB != null) {
			manager.merge(updatedRoute);
			return "{\"message\": \"Route sucessfully updated\"}";
		} else
			return "{\"message\": \"Route does not exist\"}";

	}

	@Transactional(REQUIRED)
	public String deleteRoute(Long id) {
		Route RouteInDB = findRoute(id);
		if (RouteInDB != null) {
			manager.remove(RouteInDB);
			return "{\"message\": \"Route sucessfully deleted\"}";
		} else
			return "{\"message\": \"Route not found\"}" ;
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public JSONUtil getJsonOb() {
		return jsonOb;
	}

	public void setJsonOb(JSONUtil jsonOb) {
		this.jsonOb = jsonOb;
	}

	private Route findRoute(long id) {
		return manager.find(Route.class, id);
	}
	
	

}
