package com.findagolfer.mobile.services;

import com.findagolfer.mobile.utilities.Base64;


public class UserCredentialService {
	private String user;
	private String password;

	public UserCredentialService() {

	}

	public void setCredentialsForNewUser() {
		user = "new";
		password = "user";
	}

	public String getAuthHeader() {
		return Base64.encodeBytes((user + ":" + password).getBytes()); // convert
																		// to
																		// base64
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

