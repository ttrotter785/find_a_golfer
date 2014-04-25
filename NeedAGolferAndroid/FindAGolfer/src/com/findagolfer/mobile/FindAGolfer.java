package com.findagolfer.mobile;

import com.admob.android.ads.AdView;
import com.findagolfer.mobile.entities.ConfigurationData;
import com.findagolfer.mobile.entities.Golfer;
import com.findagolfer.mobile.entities.LogInfo;
import com.findagolfer.mobile.services.ServiceLocator;
import com.findagolfer.mobile.utilities.AdHelper;
import com.findagolfer.mobile.utilities.BackgroundTaskDelegate;
import com.findagolfer.mobile.utilities.LogInHelper;
import com.findagolfer.mobile.utilities.ProgressBarAsyncTask;
import com.findagolfer.mobile.utilities.ServiceResponseListener;
import com.findagolfer.mobile.utilities.Utilities.UIUtilities;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public class FindAGolfer extends BaseActivity implements ServiceResponseListener<Object> {
	
	private EditText etUserName;
	private EditText etPassword;
	private CheckBox cbRememberLoginInfo;
	private Button btnLogin;
	private Button btnRegister;
	private Button btnForgotPassword;
	private String _userName;
	private String _password;
	private boolean _persist;
	private int REGISTERINTENTHANDLE = 99234;
	private int FORGOTHANDLE = 234;
	private Golfer golfer;
	private ConfigurationData baseUrl;
	
    /** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

	}
	
	private void CheckVersionAndSetServiceURL() {
		
		String version = "";
		PackageManager pm = getPackageManager();
		PackageInfo info;
		try {
			info = pm.getPackageInfo(this.getPackageName(), 0);
			version = info.versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		final String configUrl = getString(R.string.config_service_url);
		final String finalVersion = version;
    	ProgressBarAsyncTask getConfigDataTask = new ProgressBarAsyncTask(FindAGolfer.this, FindAGolfer.this);
    	getConfigDataTask._dialogMessage = "Checking for updates...";
    	
    	BackgroundTaskDelegate<String> handler = new BackgroundTaskDelegate<String>() {

			public Object setBackgroundTask() {
				return ServiceLocator.getInstance().GetCurrentServiceConfiguration(configUrl, finalVersion);
			}
    		
    	};
    	getConfigDataTask.execute(handler); 
	}
	
	@Override 
	public void onResume(){
		if(this.getServiceUrl().length() == 0){
			CheckVersionAndSetServiceURL();
		} else {
			ServiceLocator.getInstance().setServiceUrl(this.getServiceUrl());
			if(!this.hasValidStoredLoginCredentials()){
            	ShowLoginScreen();
            }
            else{
            	PerformLogin();
            }
		}
		super.onResume();
		
	}

	//@Override
	//public boolean onKeyDown(int keyCode, KeyEvent event) {
	//	if(keyCode == KeyEvent.KEYCODE_BACK) {
	//       //Ask the user if they want to quit
	//		LayoutInflater li = getLayoutInflater();
	//		View view = li.inflate(R.layout.exit_ad, null);
	//		new AlertDialog.Builder(this)
	//	        .setTitle("Warning")
	//	        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

	//				public void onClick(DialogInterface arg0, int arg1) {
	//					FindAGolfer.this.finish();
	//				}
	
	//	        })
	//	        .setView(view)
	//	        .setNegativeButton("No", null)
	//	        .show();

	//        return true;
	//    }
	//    else {
	//        return super.onKeyDown(keyCode, event);
	//    }
	//}

	public void ShowWelcomeMessage(){
		LayoutInflater li = getLayoutInflater();
		View view = li.inflate(R.layout.welcome, null);
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		
		builder.setView(view)
			.setTitle("Welcome!")
	    	.setCancelable(false)
	    	.setNegativeButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
					dialog.cancel();
				}
	    	});
		builder.show();
	}

	private void InstantiateControls() {
		
		etUserName = (EditText)findViewById(R.id.EditText_Login_UserName);
		etPassword = (EditText)findViewById(R.id.EditText_Login_Password);
		cbRememberLoginInfo = (CheckBox)findViewById(R.id.Checkbox_SaveLoginCredentials);
		btnLogin = (Button)findViewById(R.id.Button_Login);
		btnRegister = (Button)findViewById(R.id.Button_SignUp);
		btnForgotPassword = (Button)findViewById(R.id.Button_ForgotPassword);
		
		btnRegister.setOnClickListener(registerClickListener);
		btnLogin.setOnClickListener(loginClickListener);
		btnForgotPassword.setOnClickListener(forgotClickListener);
	}

	
	private void ShowLoginScreen(){
		setContentView(R.layout.login);
		InstantiateControls();
		AdHelper.getInstance().GetFreshAd((AdView)findViewById(R.id.ad_login));
        
	}

	public OnClickListener loginClickListener = new OnClickListener(){

		public void onClick(View v) {
			v.startAnimation(AnimationUtils.loadAnimation(FindAGolfer.this, R.anim.button_click));
			PerformLogin();
		}
		
	};
	
	public OnClickListener registerClickListener = new OnClickListener(){

		public void onClick(View v) {
			v.startAnimation(AnimationUtils.loadAnimation(FindAGolfer.this, R.anim.button_click));
			startActivityForResult(new Intent(FindAGolfer.this, Register.class), REGISTERINTENTHANDLE);
		}
		
	};
	
	public OnClickListener forgotClickListener = new OnClickListener(){

		public void onClick(View v) {
			v.startAnimation(AnimationUtils.loadAnimation(FindAGolfer.this, R.anim.button_click));
			startActivityForResult(new Intent(FindAGolfer.this, ResetPassword.class), FORGOTHANDLE);
		}
		
	};
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
            Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REGISTERINTENTHANDLE || requestCode == FORGOTHANDLE) {
            if (resultCode == RESULT_OK) {
                //USER REGISTERED SUCCESSFULLY
            	PerformLogin();
            }
        }
        
    }

	
	public void PerformLogin(){
		if(!this.hasValidStoredLoginCredentials()){
			
			_userName = etUserName.getText().toString();
			_password = etPassword.getText().toString();
			_persist = cbRememberLoginInfo.isChecked();
			
			if(_userName.length() == 0 || _password.length() == 0){
	    		UIUtilities.ShowAlertDialog(this, "Warning", "Please enter a username and password.");
	    		return;
	    	} 
			
		} else {
			ShowLoginScreen();
			_userName = this.get_userName();
			_password = this.get_password();
			_persist = true;
		}
		final LogInfo logInfo = LogInHelper.getInstance().SetLoggingInfo(_userName, _password, FindAGolfer.this, (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE));
		ServiceLocator.getInstance().setCredentials(_userName, _password);
		ProgressBarAsyncTask loginTask = new ProgressBarAsyncTask(FindAGolfer.this, FindAGolfer.this);
		loginTask._dialogMessage =  "Logging in....";
		BackgroundTaskDelegate<Golfer> delegate = new BackgroundTaskDelegate<Golfer>(){
			public Object setBackgroundTask() {
				return ServiceLocator.getInstance().getGolferByUserNameAndPassword(logInfo.toJSON().toString());
			}
		};
		loginTask.execute(delegate);
	}
	
	public void onServiceResponse(Object result) {
		
		if(result == null){
			UIUtilities.ShowAlertDialog(this, "Login Failed", "Please check your username and password.");
			this.clearUserNamePassword();
			ShowLoginScreen();
        }
		else if(result instanceof ConfigurationData){
    		baseUrl = (ConfigurationData)result;
    		if(baseUrl.isLocked()){
    			
    			UIUtilities.ShowApplicationLockedDialog(this, FindAGolfer.this, "Locked");
    			
    		} else {
        		if(baseUrl.isSuccess()){
	        		ServiceLocator.getInstance().setServiceUrl(baseUrl.getBaseUrl());
	        		if(!this.hasValidStoredLoginCredentials()){
	                	ShowLoginScreen();
	                }
	                else{
	                	PerformLogin();
	                }
	        		this.setServiceUrl(baseUrl.getBaseUrl());
        		} else {
        			UIUtilities.ShowAlertDialog(this, "Error", baseUrl.getMessage());
        		}
    		}
    	}
        else{
        	golfer = (Golfer)result;
        	if(golfer.getErrorMessage().length() > 0){
        		
        		UIUtilities.ShowAlertDialog(this, "Login Failed", "Please check your username and password.");
        		ShowLoginScreen();
        		
        	} else {
        		this.setGolfer(golfer);
        		this.set_userNamePassword(_userName, _password, _persist);
        		
        		startActivity(new Intent(FindAGolfer.this, Main.class).putExtra(getString(R.string.intentextras_golfer_keyname), golfer));
        		
        	}
        }
	}
}