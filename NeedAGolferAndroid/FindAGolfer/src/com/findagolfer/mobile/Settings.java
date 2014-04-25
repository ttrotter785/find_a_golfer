package com.findagolfer.mobile;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import com.admob.android.ads.AdView;
import com.findagolfer.mobile.entities.Golfer;
import com.findagolfer.mobile.parameters.GolferCreateParameter;
import com.findagolfer.mobile.services.ServiceLocator;
import com.findagolfer.mobile.utilities.AdHelper;
import com.findagolfer.mobile.utilities.BackgroundTaskDelegate;
import com.findagolfer.mobile.utilities.LocationHelper;
import com.findagolfer.mobile.utilities.ProgressBarAsyncTask;
import com.findagolfer.mobile.utilities.ServiceResponseListener;
import com.findagolfer.mobile.utilities.LocationHelper.LocationResult;
import com.findagolfer.mobile.utilities.Utilities.UIUtilities;

public class Settings extends BaseActivity implements ServiceResponseListener<Object> {

	EditText etEmail;
	EditText etHandicap;
	CheckBox cbAvailable;
	CheckBox cbAllowEmail;
	EditText etScreenName;
	EditText etDistance;
	EditText etMinRating;
	EditText etMaxHandicap;
	EditText etCourseDistance;
	Button btnUpdate;
	Golfer golfer;
	ProgressDialog tempDialog;
	double latitude;
	double longitude;
	String sDistance;
	String sMinRating;
	String sMaxHandicap;
	String sCourseDistance;
	EditText etAvailabilityDistance;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        
        AdHelper.getInstance().GetFreshAd((AdView)findViewById(R.id.ad_settings));
        InstantiateControls();

        BindProfileData();
        
        IntentFilter intentFilter = new IntentFilter();
	    intentFilter.addAction("com.findagolfer.mobile.ACTION_LOGOUT");
	    registerReceiver(logoutReceiver, intentFilter);
	}
	
	private BroadcastReceiver logoutReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("onReceive","Logout in progress");
            //At this point you should start the login activity and finish this one
            startActivity(new Intent(Settings.this, Main.class));
            finish();
        }
    };

    
    @Override 
	public void onDestroy(){
		super.onDestroy();
		unregisterReceiver(logoutReceiver);
	}
    
    private boolean IsFormDirty(){
    	if(etEmail.getText().toString().compareTo(golfer.getEmailAddress()) != 0){
    		return true;
    	}
    	if(etHandicap.getText().toString().compareTo(String.valueOf(golfer.getHandicap())) != 0){
    		return true;
    	}
    	if(cbAvailable.isChecked() != golfer.isAvailable()){
    		return true;
    	}
    	if(cbAllowEmail.isChecked() != golfer.isAllowEmails()){
    		return true;
    	}
    	if(etScreenName.getText().toString().compareTo(String.valueOf(golfer.getScreenName())) != 0){
    		return true;
    	}
    	if(etAvailabilityDistance.getText().toString().compareTo(String.valueOf(golfer.getAvailabilityDistance())) != 0){
    		return true;
    	}
    	if(sDistance.compareTo(String.valueOf(this.getSearchPreference_Radius())) != 0){
    		return true;
    	}
    	if(sCourseDistance.compareTo(String.valueOf(this.getSearchPreference_CourseDistance())) != 0){
    		return true;
    	}
    	if(sMinRating.compareTo(String.valueOf(this.getSearchPreference_Rating())) != 0){
    		return true;
    	}
    	if(sMaxHandicap.compareTo(String.valueOf(this.getSearchPreference_Handicap())) != 0){
    		return true;
    	}
    	
    	return false;
    }

    
	private void InstantiateControls() {
		etEmail = (EditText)findViewById(R.id.EditText_Settings_Email);
		etHandicap = (EditText)findViewById(R.id.EditText_Settings_Handicap);
		cbAvailable = (CheckBox)findViewById(R.id.CheckBox_Settings_IsAvailable);
		cbAllowEmail = (CheckBox)findViewById(R.id.CheckBox_Settings_AllowEmails);
		etScreenName = (EditText)findViewById(R.id.EditText_Settings_ScreenName);
		etDistance = (EditText)findViewById(R.id.EditText_Settings_Distance);
		btnUpdate = (Button)findViewById(R.id.Button_Settings_UpdateProfile);
		etMinRating = (EditText)findViewById(R.id.EditText_Settings_MinimumRating);
		etMaxHandicap = (EditText)findViewById(R.id.EditText_Settings_MaxHandicap);
		etAvailabilityDistance = (EditText)findViewById(R.id.EditText_Settings_AvailabilityDistance);
		etCourseDistance = (EditText)findViewById(R.id.EditText_Settings_GolfCourseDistance);
		
		golfer = this.getGolfer();
		btnUpdate.setOnClickListener(updateClickListener);
	}

	
	private void GetLocationAndUpdate() {
		LocationHelper locationHelper = new LocationHelper();
		locationHelper.getLocation(Settings.this, new LocationResult(){
			@Override
			public void gotLocation(final Location location){
				latitude = location.getLatitude();
				longitude = location.getLongitude();
				BuildUpdateParameterAndUpdate();
			}

		});
	}
	
	private void BindProfileData(){
		
		etEmail.setText(golfer.getEmailAddress());
		etHandicap.setText(String.valueOf(golfer.getHandicap()));
		cbAvailable.setChecked(golfer.isAvailable());
		cbAllowEmail.setChecked(golfer.isAllowEmails());
		etScreenName.setText(golfer.getScreenName());
		etAvailabilityDistance.setText(String.valueOf(golfer.getAvailabilityDistance()));
		
		sDistance = String.valueOf(this.getSearchPreference_Radius());
		sMinRating = String.valueOf(this.getSearchPreference_Rating());
		sMaxHandicap = String.valueOf(this.getSearchPreference_Handicap());
		sCourseDistance = String.valueOf(this.getSearchPreference_CourseDistance());
		
		etCourseDistance.setText(sCourseDistance);
		etDistance.setText(sDistance);
		etMinRating.setText(sMinRating);
		etMaxHandicap.setText(sMaxHandicap);
	}
	
	private OnClickListener updateClickListener = new OnClickListener(){

		public void onClick(View v) {
			v.startAnimation(AnimationUtils.loadAnimation(Settings.this, R.anim.button_click));
			GetLocationAndUpdate();
		}
		
	};
	
	private void BuildUpdateParameterAndUpdate(){
		final GolferCreateParameter parameter = new GolferCreateParameter();
		parameter.setAllowEmails(cbAllowEmail.isChecked());
		parameter.setAvailabilityDistance(Integer.parseInt(etDistance.getText().toString()));
		parameter.setAvailable(cbAvailable.isChecked());
		parameter.setScreenName(etScreenName.getText().toString());
		parameter.setEmailAddress(etEmail.getText().toString());
		parameter.setPassword(Settings.this.get_password());
		parameter.setHandicap(Integer.parseInt(etHandicap.getText().toString()));
		parameter.setLatitude(latitude);
		parameter.setLongitude(longitude);
		
		sDistance = etDistance.getText().toString();
		sMinRating = etMinRating.getText().toString();
		sMaxHandicap = etMaxHandicap.getText().toString();
		sCourseDistance = etCourseDistance.getText().toString();
		
		Settings.this.setSearchPreferences(Integer.parseInt(sDistance), Integer.parseInt(sMinRating), Integer.parseInt(sMaxHandicap), Integer.parseInt(sCourseDistance));
		
		ProgressBarAsyncTask updateTask = new ProgressBarAsyncTask(Settings.this, Settings.this);
		updateTask._dialogMessage =  "Updating your profile....";
		BackgroundTaskDelegate<Golfer> delegate = new BackgroundTaskDelegate<Golfer>(){
			public Object setBackgroundTask() {
				return ServiceLocator.getInstance().updateGolferProfile(parameter.toJSON().toString());
			}
		};
		updateTask.execute(delegate);
	}
	
	public void onServiceResponse(Object result) {
		if(result == null){
			UIUtilities.ShowAlertDialog(this, "Error", "An error occurred updating your profile.");
		} else {
			
			if(result instanceof Golfer){
				Golfer golfer = (Golfer)result;
				this.setGolfer(golfer);
				ShowSuccessDialogAndReturn();
			}
		}
	} 
	
	private void ShowSuccessDialogAndReturn() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
	 	   
 	    builder.setMessage("You have successfully updated your profile.")
 	    	.setTitle("Success!")
 	    	.setCancelable(false)
 	    	.setNegativeButton("OK", new DialogInterface.OnClickListener() {
    			public void onClick(DialogInterface dialog, int id) {
    				dialog.cancel();
    				setResult(RESULT_OK);
    				finish();
    			}
 	    	});
 	   
 	    builder.create().show();
	}

}
