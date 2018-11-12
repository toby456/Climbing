package com.qa.service.business;

public interface RouteService {
	
	String getAllRoutes();
	
	String getRoute(Long id);
	
	String createRoute(String route);
	
	String updateRoute (String routeToUpdate);
	
	String deleteRoute (Long id);
	
	
	
	

}
