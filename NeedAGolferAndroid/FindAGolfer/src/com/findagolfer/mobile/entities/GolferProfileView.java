package com.findagolfer.mobile.entities;

import java.util.List;

public class GolferProfileView {

	private List<GolferRating> ratings;
	private Golfer golfer;
	
	public List<GolferRating> getRatings() {
		return ratings;
	}
	public void setRatings(List<GolferRating> ratings) {
		this.ratings = ratings;
	}
	public Golfer getGolfer() {
		return golfer;
	}
	public void setGolfer(Golfer golfer) {
		this.golfer = golfer;
	}
	
	
}
