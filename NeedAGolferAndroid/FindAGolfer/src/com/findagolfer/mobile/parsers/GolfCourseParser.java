package com.findagolfer.mobile.parsers;

import org.json.JSONException;
import org.json.JSONObject;

import com.findagolfer.mobile.entities.GolfCourse;


public class GolfCourseParser extends JSONParser {

	private GolfCourse singleCourse;
	
	public GolfCourseParser(String url, String auth, String data){
		super.getContentsOfUrlWithPost(url, auth, data);
	}
	
	@Override 
	public void parseContents(String data){
		
		try {
			JSONObject rawData = new JSONObject(data);
			singleCourse  = new GolfCourse();
			
			singleCourse.setAddress(rawData.getString("Address"));
			singleCourse.setCourseName(rawData.getString("CourseName"));
			singleCourse.setCourseType(rawData.getString("CourseType"));
			singleCourse.setCity(rawData.getString("City"));
			singleCourse.setGolfcourse_id(rawData.getInt("GolfCourse_Id"));
			singleCourse.setLatitude(rawData.getDouble("Latitude"));
			singleCourse.setLongitude(rawData.getDouble("Longitude"));
			singleCourse.setPhoneNumber(rawData.getString("PhoneNumber"));
			singleCourse.setState(rawData.getString("State"));
			singleCourse.setZipCode(rawData.getString("ZipCode"));
			singleCourse.setDistance(rawData.getString("Distance"));
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}


	public GolfCourse getSingleCourse() {
		return singleCourse;
	}

	public void setSingleCourse(GolfCourse singleCourse) {
		this.singleCourse = singleCourse;
	}
}
