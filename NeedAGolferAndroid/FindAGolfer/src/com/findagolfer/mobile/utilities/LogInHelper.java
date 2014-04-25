package com.findagolfer.mobile.utilities;

import com.findagolfer.mobile.entities.LogInfo;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Config;


public class LogInHelper {

	private static LogInHelper instance = null;
	
	public static LogInHelper getInstance(){
		if(instance == null){
			instance = new LogInHelper();
		}		
		return instance;
	}
	
	public LogInHelper(){
		
	}
	
	public LogInfo SetLoggingInfo(String userName, String password, Context context, TelephonyManager tm){
		
		LogInfo _logInfo = new LogInfo();
		
		if(Config.DEBUG){
			_logInfo.setDeviceId("testDeviceId");
			_logInfo.setDeviceType("testDeviceType");
			_logInfo.setOsVersion("froyo");
			_logInfo.setUserAccount(userName);
		} else {
			String deviceId = getDeviceId(tm, context);
			String deviceType = Build.DEVICE + " " + Build.BRAND + " " + Build.MANUFACTURER + " " + Build.MODEL;
			String osVersion = Build.VERSION.RELEASE;
			
			_logInfo.setDeviceId(deviceId);
			_logInfo.setDeviceType(deviceType);
			_logInfo.setOsVersion(osVersion);
			_logInfo.setUserAccount(userName);
			_logInfo.setPassword(password);
		}
		return _logInfo;
	}

	
	public String getDeviceId(TelephonyManager tm, Context context) {
	     String deviceID = null;
	     boolean noPhone = false;
	     try{
		     int deviceType = tm.getPhoneType();
		     switch (deviceType) {
		           case (TelephonyManager.PHONE_TYPE_GSM):
		           break;
		           case (TelephonyManager.PHONE_TYPE_CDMA):
		           break;
		           case (TelephonyManager.PHONE_TYPE_NONE):
		           break;
		          default:
		         break;
		     }
		     deviceID = tm.getDeviceId();
	     } catch(RuntimeException e) {
	    	 //no telephony, so try something else
	    	 noPhone = true;
	     }
	     
	     if(noPhone){
	    	 deviceID = Secure.getString(context.getContentResolver(),
	                 Secure.ANDROID_ID); //could be null on some devices
	    	 
	    	 if(deviceID == null){
	    		 WifiManager wm = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
	    		 deviceID = wm.getConnectionInfo().getMacAddress();
	    	 }
	     }

	     if (deviceID == null) {
	    	 deviceID = "emulatorTest1";
       	 }
	     return deviceID;
	}
}
