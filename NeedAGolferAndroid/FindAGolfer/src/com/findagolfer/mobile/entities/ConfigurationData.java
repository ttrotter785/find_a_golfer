package com.findagolfer.mobile.entities;

public class ConfigurationData {
	
	private String baseUrl;
	private boolean locked;
	private String message;
	private boolean isSuccess;
	private String marketUri;
	
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public void setMarketUri(String marketUri) {
		this.marketUri = marketUri;
	}
	public String getMarketUri() {
		return marketUri;
	}
	
	
}
