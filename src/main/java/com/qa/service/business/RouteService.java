package com.qa.service.business;

import javax.inject.Inject;

import com.qa.persistence.Repo.RouteDBRepository;

public class RouteService {

	@Inject
	private RouteDBRepository repo;

	public String getAllRoutes() {
		return repo.getAllRoutes();
	}

	public String createRoute(String route) {
		return repo.createRoute(route);
	}

	public String updateRoute(String routeToUpdate) {
		return repo.updateRoute(routeToUpdate);
	}

	public String deleteRoute(Long id) {
		return repo.deleteRoute(id);
	}

}
