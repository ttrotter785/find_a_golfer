package com.findagolfer.mobile.parsers;

import org.json.JSONException;
import org.json.JSONObject;

import com.findagolfer.mobile.entities.Golfer;

public class GolferParser extends JSONParser {

	private Golfer golfer;
	
	public GolferParser(String url, String auth, String data){
		super.getContentsOfUrlWithPost(url, auth, data);
	}
	

	@Override
	public void parseContents(String data){
		JSONObject rawGolferData;
		JSONObject standaloneGolfer;
		try{
			golfer = new Golfer();
			rawGolferData = new JSONObject(data);
			if(rawGolferData.get("golfer") != null){
				standaloneGolfer = new JSONObject(rawGolferData.get("golfer").toString());
				golfer.setGolferId(standaloneGolfer.getInt("GolferId"));
				golfer.setAllowEmails(standaloneGolfer.getBoolean("AllowEmails"));
				golfer.setAvailabilityDistance(standaloneGolfer.getInt("AvailabilityDistance"));
				golfer.setAvailable(standaloneGolfer.getBoolean("IsAvailable"));
				golfer.setHandicap(standaloneGolfer.getInt("Handicap"));
				golfer.setLatitude(standaloneGolfer.getDouble("Latitude"));
				golfer.setLongitude(standaloneGolfer.getDouble("Longitude"));
				golfer.setPhoneNumber(standaloneGolfer.getString("PhoneNumber"));
				golfer.setScreenName(standaloneGolfer.getString("ScreenName"));
				golfer.setEmailAddress(standaloneGolfer.getString("EmailAddress"));
				golfer.setErrorMessage("");
			} else {
				golfer.setGolferId(rawGolferData.getInt("GolferId"));
				golfer.setAllowEmails(rawGolferData.getBoolean("AllowEmails"));
				golfer.setAvailabilityDistance(rawGolferData.getInt("AvailabilityDistance"));
				golfer.setAvailable(rawGolferData.getBoolean("IsAvailable"));
				golfer.setHandicap(rawGolferData.getInt("Handicap"));
				golfer.setLatitude(rawGolferData.getDouble("Latitude"));
				golfer.setLongitude(rawGolferData.getDouble("Longitude"));
				golfer.setPhoneNumber(rawGolferData.getString("PhoneNumber"));
				golfer.setScreenName(rawGolferData.getString("ScreenName"));
				golfer.setEmailAddress(rawGolferData.getString("EmailAddress"));
				golfer.setErrorMessage("");
			}
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
}
