package com.findagolfer.mobile.parameters;

import org.json.JSONException;
import org.json.JSONObject;

public class GolfersNearbySearchParameter {

	private double latitude;
	private double longitude;
	private int radius;
	private int handicap;
	private int rating;
	private int golferid;
	private String message;
	
	public GolfersNearbySearchParameter(){
		latitude = 0.0;
		longitude = 0.0;
		radius = 0;
		handicap = 0;
		rating = 0;
		golferid = 0;
		message = "";
	}
	
	public JSONObject toJSON(){
		JSONObject param = new JSONObject();
		try{
			param.put("Latitude", latitude);
			param.put("Longitude", longitude);
			param.put("Radius", radius);
			param.put("Handicap", handicap);
			param.put("Rating", rating);
			param.put("GolferId", golferid);
			param.put("Message", message);
			
		}catch (JSONException e) {
			e.printStackTrace();
		}		
		return param;
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

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getHandicap() {
		return handicap;
	}

	public void setHandicap(int handicap) {
		this.handicap = handicap;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getGolferid() {
		return golferid;
	}

	public void setGolferid(int golferid) {
		this.golferid = golferid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
