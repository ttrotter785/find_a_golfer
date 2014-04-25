package com.findagolfer.mobile.parsers;

import org.json.JSONException;
import org.json.JSONObject;

import com.findagolfer.mobile.entities.ConfigurationData;

public class ConfigurationResultParser extends JSONParser {
	
	ConfigurationData configData;
	
	public ConfigurationResultParser(String url, String auth){
		super.getContentsOfUrl(url, auth);
	}
	
	@Override
	public void parseContents(String data){
		
		JSONObject dObj;
		try {
			dObj = new JSONObject(data);
			configData = new ConfigurationData();
			configData.setBaseUrl(dObj.getString("BaseURL")); 
			configData.setLocked(dObj.getBoolean("IsLocked"));
			configData.setSuccess(dObj.getBoolean("IsSuccess"));
			configData.setMessage(dObj.getString("Message"));
			configData.setMarketUri(dObj.getString("MarketUri"));
			
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (NullPointerException ex){
			ex.printStackTrace();
		}
		
		
		
	}

	public ConfigurationData getConfigData() {
		return configData;
	}

	public void setConfigData(ConfigurationData configData) {
		this.configData = configData;
	}
}
