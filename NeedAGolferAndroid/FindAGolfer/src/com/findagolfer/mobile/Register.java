package com.findagolfer.mobile;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

import com.admob.android.ads.AdView;
import com.findagolfer.mobile.entities.CreateGolferResult;
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

public class Register extends BaseActivity implements ServiceResponseListener<Object> { 
	
	private EditText etUsername;
	private EditText etPassword;
	private EditText etConfirmPassword;
	private EditText etHandicap;
	private EditText etEmail;
	private Button btnRegister;
	private double latitude = 0.0;
	private double longitude = 0.0;
	private CreateGolferResult createGolferResult;
	ProgressDialog tempDialog;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        WireUpControls();

        AdHelper.getInstance().GetFreshAd((AdView)findViewById(R.id.ad_register));
	}
	private void WireUpControls() {
		
		etUsername = (EditText)findViewById(R.id.EditText_Register_UserName);
		etPassword = (EditText)findViewById(R.id.EditText_Register_Password);
		etConfirmPassword = (EditText)findViewById(R.id.EditText_Register_ConfirmPassword);
		etHandicap = (EditText)findViewById(R.id.EditText_Register_Handicap);
		etEmail = (EditText)findViewById(R.id.EditText_Register_Email);
		btnRegister = (Button)findViewById(R.id.Button_Register);
		btnRegister.setOnClickListener(registerClickListener);
		
	}
	public void onServiceResponse(Object result) {
	
		if(result == null){
			UIUtilities.ShowAlertDialog(this, "Error", "Oops.  Something bad happened.");
		} else {
			createGolferResult = (CreateGolferResult)result;
			if(!createGolferResult.getErrorMessage().equals("null")){
				UIUtilities.ShowAlertDialog(this, "Error", createGolferResult.getErrorMessage());
			} else {
				this.storeDefaultSearchPrefs();
				this.set_userNamePassword(etUsername.getText().toString(), etPassword.getText().toString(), true);
				
				ShowSuccessDialogAndReturn();
			}
		}
	}
	
	private void ShowSuccessDialogAndReturn() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
	 	   
 	    builder.setMessage("Thank you for registering!")
 	    	.setTitle("Success")
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

	private OnClickListener registerClickListener = new OnClickListener(){

		public void onClick(View v) {
			
			v.startAnimation(AnimationUtils.loadAnimation(Register.this, R.anim.button_click));
			if(Validates()){
				
				tempDialog = new ProgressDialog(Register.this);
		        tempDialog.setMessage("Getting your location....");
		        tempDialog.show();
		        
		        GetLocationAndSendRegistration();
				
			} else {
				UIUtilities.ShowAlertDialog(Register.this, "Error", "Your passwords do not match.");
			}
			
		}

		
	};
	
	private boolean Validates() {
		
		if(etPassword.getText().toString().equals(etConfirmPassword.getText().toString())){
			return true;
		}
		return false;
	}
	
	private void GetLocationAndSendRegistration() {
		LocationHelper locationHelper = new LocationHelper();
		locationHelper.getLocation(Register.this, new LocationResult(){
			@Override
			public void gotLocation(final Location location){
				if(location != null){
					latitude = location.getLatitude();
					longitude = location.getLongitude();
					tempDialog.dismiss();
				}
				final GolferCreateParameter newGolfer = new GolferCreateParameter();
				newGolfer.setEmailAddress(etEmail.getText().toString());
				newGolfer.setScreenName(etUsername.getText().toString());
				newGolfer.setPassword(etPassword.getText().toString());
				newGolfer.setLatitude(latitude);
				newGolfer.setLongitude(longitude);
				newGolfer.setHandicap(Integer.parseInt(etHandicap.getText().toString()));
				newGolfer.setAvailable(true);
				
				ProgressBarAsyncTask createGolferTask = new ProgressBarAsyncTask(Register.this, Register.this);
				createGolferTask._dialogMessage =  "Registering....";
				BackgroundTaskDelegate<Golfer> delegate = new BackgroundTaskDelegate<Golfer>(){
					public Object setBackgroundTask() {
						return ServiceLocator.getInstance().createGolfer(newGolfer.toJSON().toString());
					}
				};
				createGolferTask.execute(delegate);
			}

		});
	}

}
