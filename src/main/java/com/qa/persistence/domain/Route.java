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
	private int climbStatus;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long ID;
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
	@Column(name = "crux1", length = 150)
	private String crux1;
	@Column(name = "crux2", length = 150)
	private String crux2;
	@JoinColumn(name = "userID")
	private Long userID;

	public Route() {
	}

	public Route(int climbStatus, String routeName, String difficulty, String location, String typeOfClimb,
			String climbDescription, String crux1, String crux2, Long userID) {
		this.climbStatus = climbStatus;
		this.routeName = routeName;
		this.difficulty = difficulty;
		this.location = location;
		this.typeOfClimb = typeOfClimb;
		this.climbDescription = climbDescription;
		this.crux1 = crux1;
		this.crux2 = crux2;
		this.userID = userID;
	}
	
	

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public int getClimbStatus() {
		return climbStatus;
	}

	public void setClimbStatus(int climbStatus) {
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

	public String getCrux1() {
		return crux1;
	}

	public void setCrux1(String crux1) {
		this.crux1 = crux1;
	}

	public String getCrux2() {
		return crux2;
	}

	public void setCrux2(String crux2) {
		this.crux2 = crux2;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	@Override
	public String toString() {
		return "Route [Climb status=" + climbStatus + ", ID =" + ID + ", Route name =" + routeName
				+ ", Difficulty =" + difficulty + ", Location = " + location + ", Type of Climb = " + typeOfClimb
				+ ", Climb Description = " + climbDescription + ", Crux 1 = " + crux1 + ", Crux 2 = " + crux2
				+ ", User ID = " + userID + "]";

	}
}
