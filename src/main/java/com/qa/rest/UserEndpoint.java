package com.qa.rest;


import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.qa.service.business.IClassroomService;
import com.qa.service.business.RouteService;
import com.qa.service.business.UserService;

@Path("/Classroom")
public class UserEndpoint {
	
	@Inject
	private UserService user;

	

	@Path("/createUser")
	@POST
	@Produces({ "application/json" })
	public String addUser(String user) {
		return user.createUser(user);
	}
	
	

	public void setService(IClassroomService service) {
		this.service = service;
	}

}