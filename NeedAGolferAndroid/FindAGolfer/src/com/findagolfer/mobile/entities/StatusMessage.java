package com.findagolfer.mobile.entities;

public class StatusMessage {
	private int golferid;
	private String emailAddress;
	private int handicap;
	private boolean allowEmails;
	private String screenName;
	private String message;
	private long messageCreateDate;
	private double rating;
	private int numRatings;
	private String courseName;
	
	public int getGolferid() {
		return golferid;
	}
	public void setGolferid(int golferid) {
		this.golferid = golferid;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public int getHandicap() {
		return handicap;
	}
	public void setHandicap(int handicap) {
		this.handicap = handicap;
	}
	public boolean isAllowEmails() {
		return allowEmails;
	}
	public void setAllowEmails(boolean allowEmails) {
		this.allowEmails = allowEmails;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getMessageCreateDate() {
		return messageCreateDate;
	}
	public void setMessageCreateDate(long messageCreateDate) {
		this.messageCreateDate = messageCreateDate;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public int getNumRatings() {
		return numRatings;
	}
	public void setNumRatings(int numRatings) {
		this.numRatings = numRatings;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	
	
}
