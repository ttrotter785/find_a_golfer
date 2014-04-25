package com.findagolfer.mobile.parsers;

import org.json.JSONException;
import org.json.JSONObject;

import com.findagolfer.mobile.entities.CreateGolferResult;

public class CreateGolferParser extends JSONParser {

	private CreateGolferResult golferResult;
	
	public CreateGolferParser(String url, String auth, String data){
		super.getContentsOfUrlWithPost(url, auth, data);
	}
	
	@Override 
	public void parseContents(String data){
			JSONObject rawCreateGolferResult;
		
		try {
			rawCreateGolferResult = new JSONObject(data);
			golferResult = new CreateGolferResult();
			
			golferResult.setErrorMessage(rawCreateGolferResult.getString("ErrorMessage"));
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public CreateGolferResult getGolferResult() {
		return golferResult;
	}

	public void setGolferResult(CreateGolferResult golferResult) {
		this.golferResult = golferResult;
	}
	
	
}
