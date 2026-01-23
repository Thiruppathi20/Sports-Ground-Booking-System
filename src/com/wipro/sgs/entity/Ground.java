package com.wipro.sgs.entity;

public class Ground {
	private String groundId;
	private String groundName;
	private String sportType;
	private double hourlyRate ;


public Ground(String groundId, String groundName, String sportType, double hourlyRate) {
	super();
	this.groundId = groundId;
	this.groundName = groundName;
	this.sportType = sportType;
	this.hourlyRate = hourlyRate;
}
public String getGroundId() {
	return groundId;
}
public void setGroundId(String groundId) {
	this.groundId = groundId;
}
public String getGroundName() {
	return groundName;
}
public void setGroundName(String groundName) {
	this.groundName = groundName;
}
public String getSportType() {
	return sportType;
}
public void setSportType(String sportType) {
	this.sportType = sportType;
}
public double getHourlyRate() {
	return hourlyRate;
}
public void setHourlyRate(double hourlyRate) {
	this.hourlyRate = hourlyRate;
}
}