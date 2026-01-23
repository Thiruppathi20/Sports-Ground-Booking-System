package com.wipro.sgs.entity;

public class Booking {
	private String bookingId;
	private String userId;
	private String groundId ;
	private String date ;
	private String timeSlot;
	private double totalFare;
	
	public Booking(String bookingId, String userId, String groundId, String date, String timeSlot, double totalFare) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.groundId = groundId;
		this.date = date;
		this.timeSlot = timeSlot;
		this.totalFare = totalFare;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGroundId() {
		return groundId;
	}

	public void setGroundId(String groundId) {
		this.groundId = groundId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}
	

}
