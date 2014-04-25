package com.findagolfer.mobile.utilities;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.findagolfer.mobile.R;
import com.findagolfer.mobile.entities.Golfer;
import com.findagolfer.mobile.parameters.PrivateMessageParameter;
import com.findagolfer.mobile.services.ServiceLocator;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

public final class Utilities {

public static class UIUtilities {
		
	public static void ShowApplicationLockedDialog(Context context, final Activity callingActivity, final String marketUri){
		
			AlertDialog.Builder builder = new AlertDialog.Builder(context);
		 	   
	 	    builder.setMessage("This version of Find A Golfer is outdated.  Please update or install the latest version from the Android Market.")
	 	    	.setTitle("Error")
	 	    	.setCancelable(false)
	 	    	.setNegativeButton("OK", new DialogInterface.OnClickListener() {
	 	    		public void onClick(DialogInterface dialog, int id) {
	    				Intent intent = new Intent (Intent.ACTION_VIEW);
	    		     	intent.setData(Uri.parse(marketUri));
	    		     	intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	    		     	callingActivity.startActivity(intent);
	    			}
	 	    	});
	 	   
	 	    builder.create().show();
	
		}
		public static String DateDiffText(long unixTime){
			
			Date whenCreated = new Date(unixTime*1000 - TimeZone.getTimeZone("EST").getRawOffset());
			Calendar calendarNow = Calendar.getInstance(TimeZone.getTimeZone("EST"));
			Calendar calendarCreated = Calendar.getInstance(TimeZone.getTimeZone("EST"));
			calendarCreated.setTime(whenCreated);
			long nowInMilliseconds = calendarNow.getTimeInMillis();
			long createdInMilliseconds = calendarCreated.getTimeInMillis();
			long diff = createdInMilliseconds - nowInMilliseconds;
			long diffDays = Math.abs(diff/(24*60*60*1000));
			long diffHours = Math.abs(diff/(60*60*1000));
			long diffMins = Math.abs(diff/(60*1000));
			long diffSecs = Math.abs(diff/1000);
			String sDescription = null;
			long diffTime = 0;
			
			if(diffSecs <= 60){
				sDescription = "%d seconds ago";
				diffTime = diffSecs;
			} else if (diffMins <=60){
				sDescription = "%d minutes ago";
				diffTime = diffMins;
			} else if (diffHours <=24){
				sDescription = "%d hours ago";
				diffTime = diffHours;
			} else if (diffDays >= 1){
				sDescription = "%d days ago";
				diffTime = diffDays;
			} 
			
			return String.format(sDescription, diffTime);
		}
	
		public static void ShowAlertDialog(Context context, String title, String messageText) {		
			ShowAlertDialogWithIntent(context, title, messageText, null);
		}
		
		public static void ShowAlertDialogWithIntent(final Context context, String title, String messageText, final Intent intent) {
			AlertDialog.Builder builder = new AlertDialog.Builder(context);
	 	   
	 	    builder.setMessage(messageText)
	 	    	.setTitle(title)
	 	    	.setCancelable(false)
	 	    	.setNegativeButton("OK", new DialogInterface.OnClickListener() {
	    			public void onClick(DialogInterface dialog, int id) {
	    				dialog.cancel();
						
						if(intent != null) {
							context.startActivity(intent);
						}
	    			}
	 	    	});
	 	   
	 	    builder.create().show();
		}
		
		public static void ShowMessagingDialog(List<Integer> receivingGolferIds, 
				final Context ctx, 
				final ServiceResponseListener<?> listener,
				int sendingGolferId){
			final Dialog dialog = new Dialog(ctx);
			dialog.setContentView(R.layout.sendmessage);
			dialog.setTitle("Send Private Message");
			dialog.setCancelable(true);
			Button btnCancel = (Button)dialog.findViewById(R.id.Button_SendMessage_Cancel);
			Button btnSend = (Button)dialog.findViewById(R.id.Button_SendMessage_Send);
			final EditText etMessage = (EditText)dialog.findViewById(R.id.EditText_SendMessage_Text);
			
			btnCancel.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					v.startAnimation(AnimationUtils.loadAnimation(ctx, R.anim.button_click));
					dialog.hide();
				}
			});
			
			final PrivateMessageParameter parameter = new PrivateMessageParameter();
			parameter.setReceivingGolferIds(receivingGolferIds);
			parameter.setSendingGolferId(sendingGolferId);
			parameter.setRootMessageId(0);
			
			btnSend.setOnClickListener(new OnClickListener(){
			
				public void onClick(View v) {
					v.startAnimation(AnimationUtils.loadAnimation(ctx, R.anim.button_click));
					if(etMessage.getText().toString().length() > 0){
						parameter.setMessage(etMessage.getText().toString());
						ProgressBarAsyncTask sendTask = new ProgressBarAsyncTask(ctx, listener);
						sendTask._dialogMessage =  "Sending....";
						BackgroundTaskDelegate<Golfer> delegate = new BackgroundTaskDelegate<Golfer>(){
							public Object setBackgroundTask() {
								return ServiceLocator.getInstance().sendPrivateMessage(parameter.toJSON().toString());
							}
						};
						sendTask.execute(delegate);
						dialog.hide();
					}
				}
				
			});
			dialog.show();
		}
	}
	
	public static class DeviceUtilities {
		
		public static String getDeviceId(Context context) {
		     String deviceID = null;
		     String serviceName = Context.TELEPHONY_SERVICE;
		     TelephonyManager m_telephonyManager = (TelephonyManager) context.getSystemService(serviceName);
		     int deviceType = m_telephonyManager.getPhoneType();
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
		     deviceID = m_telephonyManager.getDeviceId();
		     //String msisdn =  m_telephonyManager.getLine1Number();
		     //String simSerialNumber = m_telephonyManager.getSimSerialNumber();
		     //String imsi = m_telephonyManager.getSubscriberId();
		     if (deviceID == null) {
	        	deviceID = "emulatorTest1";
	        	}
		     return deviceID;
		}
	}
}
