package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.qa.service.business.RouteServiceImpl;
import com.qa.service.business.UserService;

@Path("/User")
public class UserEndpoint {

	@Inject
	private UserService users;
	
	@Path("/getAllUsers")
	@GET
	@Produces({ "application/json" })
	public String getAllUsers() {
		return users.getAllUsers();
	}

	@Path("/createUser")
	@POST
	@Produces({ "application/json" })
	public String addUser(String user) {
		return users.createUser(user);
	}

	public void setService(UserService user) {
		this.users = user;
	}

}
