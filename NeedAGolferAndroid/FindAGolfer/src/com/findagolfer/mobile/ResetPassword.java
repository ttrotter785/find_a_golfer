package com.findagolfer.mobile;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.admob.android.ads.AdView;
import com.findagolfer.mobile.entities.Golfer;
import com.findagolfer.mobile.parameters.ResetPasswordParameter;
import com.findagolfer.mobile.services.ServiceLocator;
import com.findagolfer.mobile.utilities.AdHelper;
import com.findagolfer.mobile.utilities.BackgroundTaskDelegate;
import com.findagolfer.mobile.utilities.ProgressBarAsyncTask;
import com.findagolfer.mobile.utilities.ServiceResponseListener;
import com.findagolfer.mobile.utilities.Utilities.UIUtilities;

public class ResetPassword extends BaseActivity implements ServiceResponseListener<Object>  {

	private EditText etUsername;
	private EditText etEmailAddress;
	private EditText etNewPassword1;
	private EditText etNewPassword2;
	private Button btnSendPassword;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resetpassword);
        WireUpControls();

        AdHelper.getInstance().GetFreshAd((AdView)findViewById(R.id.ad_forgot));
	}
	
	private void WireUpControls() {
		etUsername = (EditText)findViewById(R.id.EditText_ForgotPassword_UserName);
		etEmailAddress = (EditText)findViewById(R.id.EditText_ForgotPassword_EmailAddress);
		etNewPassword1 = (EditText)findViewById(R.id.EditText_ForgotPassword_Password1);
		etNewPassword2 = (EditText)findViewById(R.id.EditText_ForgotPassword_Password2);
		btnSendPassword = (Button)findViewById(R.id.Button_ForgotPassword_SendPassword);
		
		btnSendPassword.setOnClickListener(sendPasswordClickListener);
	}
	
	private OnClickListener sendPasswordClickListener = new OnClickListener(){

		public void onClick(View v) {
			if(Validates()){
				final ResetPasswordParameter param = new ResetPasswordParameter();
				param.setEmailAddress(etEmailAddress.getText().toString());
				param.setUsername(etUsername.getText().toString());
				param.setPassword(etNewPassword1.getText().toString());
				
				ProgressBarAsyncTask resetTask = new ProgressBarAsyncTask(ResetPassword.this, ResetPassword.this);
				resetTask._dialogMessage =  "Resetting password....";
				BackgroundTaskDelegate<Golfer> delegate = new BackgroundTaskDelegate<Golfer>(){
					public Object setBackgroundTask() {
						return ServiceLocator.getInstance().resetPword(param.toJSON().toString());
					}
				};
				resetTask.execute(delegate);
			} else {
				UIUtilities.ShowAlertDialog(ResetPassword.this, "Error", "Your passwords do not match.");
			}
		}
		
	};
	
	private boolean Validates(){
		if(etNewPassword1.getText().toString().equals(etNewPassword2.getText().toString())){
			return true;
		}
		return false;
	}

	public void onServiceResponse(Object result) {
		if(result == null){
			UIUtilities.ShowAlertDialog(this, "Error", "An error occurred resetting your password.");
		} else {
			this.set_userNamePassword(etUsername.getText().toString(), etNewPassword1.getText().toString(), true);
			
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
		 	   
	 	    builder.setMessage("Your password has been reset.")
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
	}

}
