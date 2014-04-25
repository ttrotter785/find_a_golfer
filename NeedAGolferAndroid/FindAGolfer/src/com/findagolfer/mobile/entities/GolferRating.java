package com.findagolfer.mobile.entities;

public class GolferRating {

	private String comments;
	private long createDateTime;
	private int golferId;
	private int rating;
	private String submitterName;
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public long getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(long createDateTime) {
		this.createDateTime = createDateTime;
	}
	public int getGolferId() {
		return golferId;
	}
	public void setGolferId(int golferId) {
		this.golferId = golferId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getSubmitterName() {
		return submitterName;
	}
	public void setSubmitterName(String submitterName) {
		this.submitterName = submitterName;
	}
	
	
	
}
