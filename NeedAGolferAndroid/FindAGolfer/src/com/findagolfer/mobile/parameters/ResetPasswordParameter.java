package com.findagolfer.mobile.parameters;

import org.json.JSONException;
import org.json.JSONObject;

public class ResetPasswordParameter {

	private String password;
	private String username;
	private String emailAddress;
	
	public ResetPasswordParameter(){
		password = "";
		username = "";
		emailAddress = "";
	}
	
	public JSONObject toJSON(){
		
		JSONObject param = new JSONObject();
		try {
			param.put("UserAccount", username);
			param.put("EmailAddress", emailAddress);
			param.put("Password", password);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return param;	
	}
	
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
}
