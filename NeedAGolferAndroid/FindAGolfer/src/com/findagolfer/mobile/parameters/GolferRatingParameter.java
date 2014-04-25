package com.findagolfer.mobile.parameters;

import org.json.JSONException;
import org.json.JSONObject;

public class GolferRatingParameter {

	private int golferId;
	private int submittingGolferId;
	private int rating;
	private String comments;
	
	public GolferRatingParameter(){
		golferId = 0;
		submittingGolferId = 0;
		rating = 0;
		comments = "";
	}
	
	public JSONObject toJSON(){
		JSONObject param = new JSONObject();
		try {
			param.put("GolferId", golferId);
			param.put("SubmittingGolferId", submittingGolferId);
			param.put("Rating", rating);
			param.put("Comments", comments);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return param;	
	}
	
	public int getGolferId() {
		return golferId;
	}
	public void setGolferId(int golferId) {
		this.golferId = golferId;
	}
	public int getSubmittingGolferId() {
		return submittingGolferId;
	}
	public void setSubmittingGolferId(int submittingGolferId) {
		this.submittingGolferId = submittingGolferId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
}
