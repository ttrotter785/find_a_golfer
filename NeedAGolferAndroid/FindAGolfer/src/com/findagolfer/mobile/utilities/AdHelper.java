package com.findagolfer.mobile.utilities;

import com.admob.android.ads.AdManager;
import com.admob.android.ads.AdView;

public class AdHelper {

	private static AdHelper instance = null;
	
	public static AdHelper getInstance(){
		if(instance == null){
			instance = new AdHelper();
		}		
		return instance;
	}
	
	public AdHelper(){
		
	}
	
	public void GetFreshAd(AdView adView){
		AdManager.setTestDevices( new String[] { AdManager.TEST_EMULATOR });
		adView.requestFreshAd();
	}
}
