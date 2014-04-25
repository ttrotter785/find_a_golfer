package com.findagolfer.mobile.entities;

import org.json.JSONException;
import org.json.JSONObject;

public class LogInfo {
	private String deviceId;
	private String deviceType;
	private String osVersion;
	private String userAccount;
	private String password;
	
	public LogInfo(){
		
	}
	
	public JSONObject toJSON() {
		
		JSONObject param = new JSONObject();
		
		try {
			param.put("DeviceId", deviceId);
			param.put("DeviceType", deviceType);
			param.put("OSVersion", osVersion);
			param.put("UserAccount", userAccount);
			param.put("Password", password);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return param;
	}
	
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public String getOsVersion() {
		return osVersion;
	}
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
