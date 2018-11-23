package com.qa.persistence.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Route")
public class Route {

	@Column(name = "climbStatus")
	private String climbStatus;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long routeID;
	@Column(name = "routeName", length = 50)
	private String routeName;
	@Column(name = "difficulty", length = 20)
	private String difficulty;
	@Column(name = "location", length = 200)
	private String location;
	@Column(name = "typeOfClimb", length = 50)
	private String typeOfClimb;
	@Column(name = "climbDescription", length = 200)
	private String climbDescription;
	@Column(name = "crux", length = 150)
	private String crux;
	@JoinColumn(name = "userID")
	private Long userID;

	public Route() {
	}

	public Route(String climbStatus, String routeName, String difficulty, String location, String typeOfClimb,
			String climbDescription, String crux, Long userID) {
		this.climbStatus = climbStatus;
		this.routeName = routeName;
		this.difficulty = difficulty;
		this.location = location;
		this.typeOfClimb = typeOfClimb;
		this.climbDescription = climbDescription;
		this.crux = crux;
		this.userID = userID;
	}
	
	

	public Long getrouteID() {
		return routeID;
	}

	public void setrouteID(Long iD) {
		routeID = routeID;
	}

	public String getClimbStatus() {
		return climbStatus;
	}

	public void setClimbStatus(String climbStatus) {
		this.climbStatus = climbStatus;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTypeOfClimb() {
		return typeOfClimb;
	}

	public void setTypeOfClimb(String typeOfClimb) {
		this.typeOfClimb = typeOfClimb;
	}

	public String getClimbDescription() {
		return climbDescription;
	}

	public void setClimbDescription(String climbDescription) {
		this.climbDescription = climbDescription;
	}

	public String getCrux() {
		return crux;
	}

	public void setCrux(String crux1) {
		this.crux = crux1;
	}


	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	@Override
	public String toString() {
		return "Route [Climb status=" + climbStatus + ", ID =" + routeID + ", Route name =" + routeName
				+ ", Difficulty =" + difficulty + ", Location = " + location + ", Type of Climb = " + typeOfClimb
				+ ", Climb Description = " + climbDescription + ", Crux = " + crux
				+ ", User ID = " + userID + "]";

	}
}
