package com.findagolfer.mobile.entities;

import java.io.Serializable;

public class Golfer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6132026704887681445L;
	private int golferId;
	private String emailAddress;
	private boolean allowEmails;
	private String phoneNumber;
	private boolean isAvailable;
	private int handicap;
	private double latitude;
	private double longitude;
	private long lastUpdated;
	private String screenName;
	private int availabilityDistance;
	private String password;
	private String errorMessage;
	private int numRatings;
	private double rating;
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public boolean isAllowEmails() {
		return allowEmails;
	}
	public void setAllowEmails(boolean allowEmails) {
		this.allowEmails = allowEmails;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public int getHandicap() {
		return handicap;
	}
	public void setHandicap(int handicap) {
		this.handicap = handicap;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public long getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(int lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public int getAvailabilityDistance() {
		return availabilityDistance;
	}
	public void setAvailabilityDistance(int availabilityDistance) {
		this.availabilityDistance = availabilityDistance;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getGolferId() {
		return golferId;
	}
	public void setGolferId(int golferId) {
		this.golferId = golferId;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getNumRatings() {
		return numRatings;
	}
	public void setNumRatings(int numRatings) {
		this.numRatings = numRatings;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public void setLastUpdated(long lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
}