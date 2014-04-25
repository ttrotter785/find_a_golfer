package com.findagolfer.mobile.parsers;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.findagolfer.mobile.entities.StatusMessage;

public class NearbyGolfersParser extends JSONParser {

	private List<StatusMessage> statusMessages;
	
	public NearbyGolfersParser(String url, String auth, String data){
		super.getContentsOfUrlWithPost(url, auth, data);
	}
	
	@Override 
	public void parseContents(String data){

			JSONArray rawMessages;
		
		try {
			rawMessages = new JSONArray(data);
			statusMessages = new ArrayList<StatusMessage>();
			
			for(int i=0; i<rawMessages.length(); i++){
				StatusMessage message = new StatusMessage();
				JSONObject dObj = rawMessages.getJSONObject(i);
				message.setAllowEmails(dObj.getBoolean("AllowEmails"));
				message.setGolferid(dObj.getInt("GolferId"));
				message.setHandicap(dObj.getInt("Handicap"));
				message.setEmailAddress(dObj.getString("EmailAddress"));
				message.setScreenName(dObj.getString("ScreenName"));
				message.setMessage(dObj.getString("Message"));
				message.setMessageCreateDate(dObj.getInt("MessageCreateDate"));
				message.setRating(dObj.getDouble("Rating"));
				message.setNumRatings(dObj.getInt("NumRatings"));
				message.setCourseName(dObj.getString("CourseName"));
				statusMessages.add(message);
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public List<StatusMessage> getStatusMessages() {
		return statusMessages;
	}

	public void setStatusMessages(List<StatusMessage> statusMessages) {
		this.statusMessages = statusMessages;
	}
	
}
