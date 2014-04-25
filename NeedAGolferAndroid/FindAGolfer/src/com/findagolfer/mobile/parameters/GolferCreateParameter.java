package com.findagolfer.mobile.parameters;

import org.json.JSONException;
import org.json.JSONObject;

public class GolferCreateParameter {

	private String emailAddress;
	private boolean allowEmails;
	private boolean allowPhoneCalls;
	private String phoneNumber;
	private boolean isAvailable;
	private int handicap;
	private double latitude;
	private double longitude;
	private String screenName;
	private int availabilityDistance;
	private String password;
	
	public GolferCreateParameter(){
		
		emailAddress = "";
		allowEmails = false;
		phoneNumber = "";
		allowPhoneCalls = false;
		isAvailable = false;
		handicap = 0;
		latitude = 0.0;
		longitude = 0.0;
		screenName = "";
		availabilityDistance = 5;
		password = "";
	}
	
	public JSONObject toJSON(){
		
		JSONObject param = new JSONObject();
		try {
			param.put("EmailAddress", emailAddress);
			param.put("AllowEmails", allowEmails);
			param.put("PhoneNumber", phoneNumber);
			param.put("AllowPhoneCalls", allowPhoneCalls);
			param.put("IsAvailable", isAvailable);
			param.put("Handicap", handicap);
			param.put("Latitude", latitude);
			param.put("Longitude", longitude);
			param.put("Name", screenName);
			param.put("AvailabilityDistanceInMiles", availabilityDistance);
			param.put("Password", password);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return param;	
	}

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

	public boolean isAllowPhoneCalls() {
		return allowPhoneCalls;
	}

	public void setAllowPhoneCalls(boolean allowPhoneCalls) {
		this.allowPhoneCalls = allowPhoneCalls;
	}
}
