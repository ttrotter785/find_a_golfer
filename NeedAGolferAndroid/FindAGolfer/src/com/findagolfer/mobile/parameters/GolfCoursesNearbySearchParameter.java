package com.findagolfer.mobile.parameters;

import org.json.JSONException;
import org.json.JSONObject;

public class GolfCoursesNearbySearchParameter {
	private double latitude;
	private double longitude;
	private int radius;
	private String courseType;
	
	public GolfCoursesNearbySearchParameter(){
		latitude = 0.0;
		longitude = 0.0;
		radius = 0;
		courseType = "";
	}
	
	public JSONObject toJSON(){
		JSONObject param = new JSONObject();
		try{
			param.put("Latitude", latitude);
			param.put("Longitude", longitude);
			param.put("Radius", radius);
			param.put("CourseType", courseType);
			
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
	public String getCourseType() {
		return courseType;
	}
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	
}
