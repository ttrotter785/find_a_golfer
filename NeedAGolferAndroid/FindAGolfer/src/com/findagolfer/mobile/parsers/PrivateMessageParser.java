package com.findagolfer.mobile.parsers;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.findagolfer.mobile.entities.PrivateMessage;
public class PrivateMessageParser extends JSONParser {

	private List<PrivateMessage> messages;
	
	public PrivateMessageParser(String url, String auth, String data){
		super.getContentsOfUrlWithPost(url, auth, data);
	}
	
	@Override 
	public void parseContents(String data){

			JSONArray rawMessages;
		
		try {
			rawMessages = new JSONArray(data);
			messages = new ArrayList<PrivateMessage>();
			
			for(int i=0; i<rawMessages.length(); i++){
				PrivateMessage message = new PrivateMessage();
				JSONObject dObj = rawMessages.getJSONObject(i);
				message.setMessageId(dObj.getInt("MessageId"));
				message.setCreateDateTime(dObj.getInt("CreateDateTime"));
				message.setMessage(dObj.getString("Message"));
				message.setReceivingGolferId(dObj.getInt("ReceivingGolferId"));
				message.setSendingGolferId(dObj.getInt("SendingGolferId"));
				message.setReceivingGolferScreenName(dObj.getString("ReceivingGolferScreenName"));
				message.setSendingGolferScreenName(dObj.getString("SendingGolferScreenName"));
				message.setRootMessageId(dObj.getInt("RootMessageId"));
				messages.add(message);
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public List<PrivateMessage> getPrivateMessages() {
		return messages;
	}

	public void setPrivateMessages(List<PrivateMessage> messages) {
		this.messages = messages;
	}
}
