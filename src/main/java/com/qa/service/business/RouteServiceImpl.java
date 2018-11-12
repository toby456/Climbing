package com.qa.service.business;

import javax.inject.Inject;

import com.qa.persistence.Repo.RouteDBRepository;

public class RouteServiceImpl implements RouteService {

	@Inject
	private RouteDBRepository repo;

	@Override
	public String getAllRoutes() {
		return repo.getAllRoutes();
	}
	
	@Override
	public String getRoute(Long id) {
		return repo.getRoute(id);
	}

	@Override
	public String createRoute(String route) {
		return repo.createRoute(route);
	}

	@Override
	public String updateRoute(String routeToUpdate) {
		return repo.updateRoute(routeToUpdate);
	}

	@Override
	public String deleteRoute(Long id) {
		return repo.deleteRoute(id);
	}

}
