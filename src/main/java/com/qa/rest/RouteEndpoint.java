package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.service.business.RouteService;
import com.qa.service.business.UserService;

@Path("/Route")
public class RouteEndpoint {

	@Inject
	private RouteService routes;

	@Path("/getAllRoutes")
	@GET
	@Produces({ "application/json" })
	public String getAllRoutes() {
		return routes.getAllRoutes();
	}

	@Path("/getRoute/{id}")
	@GET
	@Produces({ "application/json" })
	public String getRoute(@PathParam("id") Long id) {
		return routes.getRoute(id);
	}

	@Path("/createRoute")
	@POST
	@Produces({ "application/json" })
	public String addRoute(String route) {
		return routes.createRoute(route);
	}

	@Path("/updateRoute")
	@PUT
	@Produces({ "application/json " })
	public String updateRoute(String route) {
		return routes.updateRoute(route);

	}

	@Path("/deleteRoute/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteRoute(@PathParam("id") Long id) {
		return routes.deleteRoute(id);
	}

	public void setService(RouteService route) {
		this.routes = route;
	}

}
