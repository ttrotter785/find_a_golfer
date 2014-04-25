package com.findagolfer.mobile.parsers;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.findagolfer.mobile.entities.GolfCourse;

public class GolfCourseNearbyParser extends JSONParser {
	private List<GolfCourse> golfCourses;
	
	public GolfCourseNearbyParser(String url, String auth, String data){
		super.getContentsOfUrlWithPost(url, auth, data);
	}
	
	@Override 
	public void parseContents(String data){

			JSONArray rawMessages;
		
		try {
			rawMessages = new JSONArray(data);

				golfCourses = new ArrayList<GolfCourse>();
				for(int i=0; i<rawMessages.length(); i++){
					GolfCourse course = new GolfCourse();
					JSONObject dObj = rawMessages.getJSONObject(i);
					course.setAddress(dObj.getString("Address"));
					course.setCourseName(dObj.getString("CourseName"));
					course.setCourseType(dObj.getString("CourseType"));
					course.setCity(dObj.getString("City"));
					course.setGolfcourse_id(dObj.getInt("GolfCourse_Id"));
					course.setLatitude(dObj.getDouble("Latitude"));
					course.setLongitude(dObj.getDouble("Longitude"));
					course.setPhoneNumber(dObj.getString("PhoneNumber"));
					course.setState(dObj.getString("State"));
					course.setZipCode(dObj.getString("ZipCode"));
					course.setDistance(dObj.getString("Distance"));
					
					golfCourses.add(course);
				
				}
		}catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public List<GolfCourse> getGolfCourses() {
		return golfCourses;
	}

	public void setGolfCourses(List<GolfCourse> golfCourses) {
		this.golfCourses = golfCourses;
	}

}
