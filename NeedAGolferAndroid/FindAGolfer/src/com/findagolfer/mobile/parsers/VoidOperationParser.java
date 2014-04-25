package com.findagolfer.mobile.parsers;

import org.json.JSONException;
import org.json.JSONObject;
import com.findagolfer.mobile.entities.VoidOperationResult;

public class VoidOperationParser  extends JSONParser {

	private VoidOperationResult result;
	
	public VoidOperationParser(String url, String auth, String data){
		super.getContentsOfUrlWithPost(url, auth, data);
	}
	
	@Override 
	public void parseContents(String data){
			JSONObject rawResult;
		
		try {
			rawResult = new JSONObject(data);
			result = new VoidOperationResult();
			
			result.setErrorMessage(rawResult.getString("ErrorMessage"));
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public VoidOperationResult getResult() {
		return result;
	}

	public void setResult(VoidOperationResult result) {
		this.result = result;
	}
}
