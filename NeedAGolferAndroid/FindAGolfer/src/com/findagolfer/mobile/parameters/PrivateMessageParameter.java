package com.findagolfer.mobile.parameters;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PrivateMessageParameter {

	private List<Integer> receivingGolferIds;
	private int sendingGolferId;
	private int rootMessageId;
	private String message;
	
	public PrivateMessageParameter(){
		receivingGolferIds = new ArrayList<Integer>();
		sendingGolferId = 0;
		rootMessageId = 0;
		message = "";
	}
	
	public JSONObject toJSON(){
		JSONObject param = new JSONObject();
		JSONArray receivers = new JSONArray();
		
		for(int i=0; i<receivingGolferIds.size(); i++){
			Integer golferId = receivingGolferIds.get(i);
			receivers.put(golferId);
		}
		
		try{
			param.put("ReceivingGolferIds", receivers);
			param.put("SendingGolferId", sendingGolferId);
			param.put("RootMessageId", rootMessageId);
			param.put("Message", message);
			
		}catch (JSONException e) {
			e.printStackTrace();
		}		
		return param;
	}
	
	public List<Integer> getReceivingGolferId() {
		return receivingGolferIds;
	}
	public void setReceivingGolferIds(List<Integer> receivingGolferIds) {
		this.receivingGolferIds = receivingGolferIds;
	}
	public int getSendingGolferId() {
		return sendingGolferId;
	}
	public void setSendingGolferId(int sendingGolferId) {
		this.sendingGolferId = sendingGolferId;
	}
	public int getRootMessageId() {
		return rootMessageId;
	}
	public void setRootMessageId(int rootMessageId) {
		this.rootMessageId = rootMessageId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
