package com.findagolfer.mobile;

import com.findagolfer.mobile.entities.Golfer;
import com.findagolfer.mobile.services.ServiceLocator;
import com.phonegap.DroidGap;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;


public class BaseActivity extends DroidGap {
	
	private SharedPreferences _loginPreferences;
	private SharedPreferences _searchPreferences;
	private SharedPreferences.Editor _editor;
	private static final String _loginPreferencesFileName = "CREDENTIALS";
	private static final String _searchPreferencesFileName = "SEARCHPREFS";
	private static final String _welcomePrefsFileName = "WELCOME";
	private Golfer _golfer;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Bundle extras = this.getIntent().getExtras();
		
		if(extras != null){
			if(extras.get(getString(R.string.intentextras_golfer_keyname)) != null){
				_golfer = (Golfer) extras.get(getString(R.string.intentextras_golfer_keyname));
			}
		}
		
	    
		
	}

	@Override 
	public void onResume(){
		super.onResume();
	}
	public Golfer getGolfer(){
		return _golfer;
	}
	public void setGolfer(Golfer golfer){
		_golfer = golfer;
	}
	
	public String get_userName() {
		return getLoginCredential("userName");
	}

	public void set_userNamePassword(String userName, String password, boolean persist) {
		
		if(persist){
			storeLoginCredentials("userName", userName);
			storeLoginCredentials("password", password);
		}

	}
	public String get_password() {
		return getLoginCredential("password");
	}
	
	public boolean hasValidStoredLoginCredentials(){
		return (getLoginCredential("password")!= null && getLoginCredential("userName")!=null);
	}
	
	public void clearUserNamePassword(){
		Logout();
	}
	
	public void Logout(){
		_loginPreferences = getSharedPreferences(_loginPreferencesFileName, 0);
		_editor = _loginPreferences.edit(); 
		_editor.clear();
		_editor.commit();
		
		SharedPreferences welcomePrefs = getSharedPreferences(_welcomePrefsFileName, 0);
		_editor = welcomePrefs.edit(); 
		_editor.clear();
		_editor.commit();
	}
	
	private void storeLoginCredentials(String key, String value){
		_loginPreferences = getSharedPreferences(_loginPreferencesFileName, 0);
		_editor = _loginPreferences.edit(); 
		_editor.putString(key, value);
		_editor.commit();
	}
	private String getLoginCredential(String key){
		String _value = null;
		_loginPreferences = getSharedPreferences(_loginPreferencesFileName, 0);
		_value = _loginPreferences.getString(key, null);
		return _value;
	}
	
	public void storeDefaultSearchPrefs(){
		_searchPreferences = getSharedPreferences(_searchPreferencesFileName, 0);
		_editor = _searchPreferences.edit(); 
		_editor.putInt("Radius", 5);
		_editor.putInt("Rating", 0);
		_editor.putInt("Handicap", 20);
		_editor.putInt("CourseDistance", 10);
		_editor.commit();
	}
	
	public void setSearchPreferences(int radius, int minRating, int maxHandicap, int courseDistance){
		_searchPreferences = getSharedPreferences(_searchPreferencesFileName, 0);
		_editor = _searchPreferences.edit(); 
		_editor.putInt("Radius", radius);
		_editor.putInt("Rating", minRating);
		_editor.putInt("Handicap", maxHandicap);
		_editor.putInt("CourseDistance", courseDistance);
		_editor.commit();
	}
	
	
	public int getSearchPreference_Radius(){
		int _value;
		_searchPreferences = getSharedPreferences(_searchPreferencesFileName, 0);
		_value = _searchPreferences.getInt("Radius", 5);
		return _value;
	}
	
	public int getSearchPreference_CourseDistance(){
		int _value;
		_searchPreferences = getSharedPreferences(_searchPreferencesFileName, 0);
		_value = _searchPreferences.getInt("CourseDistance", 10);
		return _value;
	}
	
	public int getSearchPreference_Handicap(){
		int _value;
		_searchPreferences = getSharedPreferences(_searchPreferencesFileName, 0);
		_value = _searchPreferences.getInt("Handicap", 20);
		return _value;
	}
	
	public int getSearchPreference_Rating(){
		int _value;
		_searchPreferences = getSharedPreferences(_searchPreferencesFileName, 0);
		_value = _searchPreferences.getInt("Rating", 0);
		return _value;
	}

	public boolean getHasSeenWelcomeMessage(){
		boolean _value = false;
		SharedPreferences welcomePrefs = getSharedPreferences(_welcomePrefsFileName, 0);
		_value = welcomePrefs.getBoolean("WelcomeMessage", _value);
		return _value;
	}
	public String getServiceUrl(){
		String _value;
		SharedPreferences welcomePrefs = getSharedPreferences(_welcomePrefsFileName, 0);
		_value = welcomePrefs.getString("ServiceUrl", "");
		return _value;
	}
	public void setHasSeenWelcomeMessage(){
		SharedPreferences welcomePrefs = getSharedPreferences(_welcomePrefsFileName, 0);
		_editor = welcomePrefs.edit(); 
		_editor.putBoolean("WelcomeMessage", true);
		_editor.commit();
	}
	public void setServiceUrl(String serviceUrl){
		SharedPreferences welcomePrefs = getSharedPreferences(_welcomePrefsFileName, 0);
		_editor = welcomePrefs.edit(); 
		_editor.putString("ServiceUrl", serviceUrl);
		_editor.commit();
	}
	
	

}

