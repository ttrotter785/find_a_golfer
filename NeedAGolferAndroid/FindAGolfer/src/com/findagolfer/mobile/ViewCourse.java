package com.findagolfer.mobile;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.admob.android.ads.AdView;
import com.findagolfer.mobile.entities.GolfCourse;
import com.findagolfer.mobile.entities.Golfer;
import com.findagolfer.mobile.services.ServiceLocator;
import com.findagolfer.mobile.utilities.AdHelper;
import com.findagolfer.mobile.utilities.BackgroundTaskDelegate;
import com.findagolfer.mobile.utilities.ProgressBarAsyncTask;
import com.findagolfer.mobile.utilities.ServiceResponseListener;
import com.findagolfer.mobile.utilities.Utilities.UIUtilities;

public class ViewCourse  extends BaseActivity implements ServiceResponseListener<Object>{

	TextView txtCourseName;
	TextView txtAddyLine1;
	TextView txtCityStateZip;
	TextView txtPhone;
	TextView txtCourseType;
	Button btnCallCourse;
	Button btnViewOnMap;
	GolfCourse selectedCourse;
	int selectedCourseId;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.courseprofile);

        Bundle extras = this.getIntent().getExtras();
		if(extras != null){
			if(extras.get(getString(R.string.intentextras_golfer_viewcourseid)) != null){
				selectedCourseId = (Integer)extras.get(getString(R.string.intentextras_golfer_viewcourseid));
			}
		}

		AdHelper.getInstance().GetFreshAd((AdView)findViewById(R.id.ad_courseprofile));
        InstantiateControls();
		WireUpProfile();
		
		IntentFilter intentFilter = new IntentFilter();
	    intentFilter.addAction("com.findagolfer.mobile.ACTION_LOGOUT");
	    registerReceiver(logoutReceiver, intentFilter);
	}
	
	private void InstantiateControls() {
		txtCourseName = (TextView)findViewById(R.id.TextView_CourseProfile_CourseName);
		txtAddyLine1 = (TextView)findViewById(R.id.TextView_CourseProfile_Address);
		txtCityStateZip = (TextView)findViewById(R.id.TextView_CourseProfile_CityStateZip);
		txtPhone = (TextView)findViewById(R.id.TextView_CourseProfile_Phone);
		txtCourseType = (TextView)findViewById(R.id.TextView_CourseProfile_CourseType);
		btnCallCourse = (Button)findViewById(R.id.Button_CourseProfile_CallCourse);
		btnViewOnMap = (Button)findViewById(R.id.Button_CourseProfile_ViewOnMap);
		
		btnCallCourse.setOnClickListener(callClickListener);
		btnViewOnMap.setOnClickListener(mapClickListener);
	}
	
	private OnClickListener callClickListener = new OnClickListener(){

		public void onClick(View v) {
			v.startAnimation(AnimationUtils.loadAnimation(ViewCourse.this, R.anim.button_click));
			ShowPlacePhoneCallDialog(String.format("tel:%s",  selectedCourse.getPhoneNumber()));
		}
		
	};
	
	
	private OnClickListener mapClickListener = new OnClickListener(){

		public void onClick(View v) {
			v.startAnimation(AnimationUtils.loadAnimation(ViewCourse.this, R.anim.button_click));
			Intent intent = new Intent(Intent.ACTION_VIEW);
			intent.setData(Uri.parse("geo:"+String.valueOf(selectedCourse.getLatitude())+","+String.valueOf(selectedCourse.getLongitude())+""));
			startActivity(intent);
		}
		
	};

	private void WireUpProfile() {
		ProgressBarAsyncTask bindCourseTask = new ProgressBarAsyncTask(ViewCourse.this, ViewCourse.this);
		bindCourseTask._dialogMessage =  "Retrieving course data....";
		BackgroundTaskDelegate<Golfer> delegate = new BackgroundTaskDelegate<Golfer>(){
			public Object setBackgroundTask() {
				return ServiceLocator.getInstance().getGolfCourseDataById(String.valueOf(selectedCourseId));
			}
		};
		bindCourseTask.execute(delegate);
	}

	private BroadcastReceiver logoutReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("onReceive","Logout in progress");
            //At this point you should start the login activity and finish this one
            startActivity(new Intent(ViewCourse.this, Main.class));
            finish();
        }
    };
    
    @Override 
	public void onDestroy(){
		super.onDestroy();
		unregisterReceiver(logoutReceiver);
	}
    
	public void onServiceResponse(Object result) {
		if(result == null){
			UIUtilities.ShowAlertDialog(this, "View Course Error", "Oops.  Something bad happened.");
		} else {
			selectedCourse = (GolfCourse)result;
			
			txtCourseName.setText(selectedCourse.getCourseName());
			txtAddyLine1.setText(selectedCourse.getAddress());
			txtCityStateZip.setText(selectedCourse.getCity() + " " + selectedCourse.getState() + " " + selectedCourse.getZipCode());
			txtPhone.setText(selectedCourse.getPhoneNumber());
			txtCourseType.setText(selectedCourse.getCourseType());
		}
	}
	
	private void ShowPlacePhoneCallDialog(String phoneNumber){
		final String alertText = String.format("You are about to place a call to %s.  Proceed?", selectedCourse.getCourseName());
		
		final String phone = phoneNumber;
		AlertDialog.Builder builder = new AlertDialog.Builder(ViewCourse.this);
	 	builder.setMessage(alertText)
	       .setCancelable(false)
	       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	           public void onClick(DialogInterface dialog, int id) {
	        	   //try{
	        	   //   String phoneNumber = _telephonyManager.getLine1Number();
	        	   //} catch (RuntimeException e){
	        	   //	   UIUtilities.ShowAlertDialog(MainMenu.this, "Error", "Phone calls are not supported on this device.");
	        	   //	   return;
	        	   //}
	        	   
	        	   	Intent intent = new Intent(Intent.ACTION_CALL);
					intent.setData(Uri.parse(phone));
					startActivity(intent);
	           }
	       })
	       .setNegativeButton("No", new DialogInterface.OnClickListener() {
	           public void onClick(DialogInterface dialog, int id) {
	                dialog.cancel();
	           }
	       });
	    
	    builder.create().show();
	}

}
