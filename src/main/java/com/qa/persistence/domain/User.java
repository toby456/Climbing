package com.qa.persistence.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class User {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "user_ID")
	private Long userID;
	@Column(name = "user_Name", length = 20)
	private String userName;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "trainee_ID", referencedColumnName = "trainee_ID")
	private List<Route> routes = new ArrayList<>();

	public User() {
	}

	public User(String firstName, String secondName, List<Route> routes) {
		this.userName = userName;
		this.routes = routes;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}


	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

	@Override
	public String toString() {
		return "User [User ID = " + userID + ", User Name = " + userName
				+ ", Routes = " + routes + "]";
	}

}
