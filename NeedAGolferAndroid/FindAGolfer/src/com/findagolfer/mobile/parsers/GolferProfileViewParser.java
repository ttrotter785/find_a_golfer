package com.findagolfer.mobile.parsers;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.findagolfer.mobile.entities.Golfer;
import com.findagolfer.mobile.entities.GolferProfileView;
import com.findagolfer.mobile.entities.GolferRating;

public class GolferProfileViewParser extends JSONParser {

	private GolferProfileView profileView;
	private Golfer golfer;
	
	public GolferProfileViewParser(String url, String auth, String data){
		super.getContentsOfUrlWithPost(url, auth, data);
	}
	
	@Override
	public void parseContents(String data){
		JSONObject rawData;
		JSONArray ratings;
		try{
			golfer = new Golfer();
			profileView = new GolferProfileView();
			rawData = new JSONObject(data);
			ratings = rawData.getJSONArray("Ratings");
			List<GolferRating> ratingsList = new ArrayList<GolferRating>();
			
			for(int i = 0; i < ratings.length(); i++){
				GolferRating singleRating = new GolferRating();
				JSONObject dObj = ratings.getJSONObject(i);
				singleRating.setComments(dObj.getString("Comments"));
				singleRating.setCreateDateTime(dObj.getInt("CreateDateTime"));
				singleRating.setGolferId(dObj.getInt("GolferId"));
				singleRating.setRating(dObj.getInt("Rating"));
				singleRating.setSubmitterName(dObj.getString("SubmitterName"));
				ratingsList.add(singleRating);
			}
			golfer.setGolferId(rawData.getInt("GolferId"));
			golfer.setErrorMessage(rawData.getString("ErrorMessage"));
			golfer.setScreenName(rawData.getString("ScreenName"));
			golfer.setHandicap(rawData.getInt("Handicap"));
			golfer.setAvailable(rawData.getBoolean("IsAvailable"));
			golfer.setRating(rawData.getDouble("Rating"));
			golfer.setNumRatings(rawData.getInt("NumRatings"));
			
			if(ratings.length() > 0){
				profileView.setRatings(ratingsList);
			}
			profileView.setGolfer(golfer);
		}
		catch (JSONException e) {
			golfer.setErrorMessage(("Unauthorized."));
			e.printStackTrace();
		}
	}

	public Golfer getGolfer() {
		return golfer;
	}

	public void setGolfer(Golfer golfer) {
		this.golfer = golfer;
	}

	public GolferProfileView getProfileView() {
		return profileView;
	}

	public void setProfileView(GolferProfileView profileView) {
		this.profileView = profileView;
	}
}
