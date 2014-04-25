package com.findagolfer.mobile;

import android.os.Bundle;

import com.phonegap.*;

public class TestPhoneGap extends DroidGap {

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		super.loadUrl("file:///android_asset/www/index.html");
	}
}
