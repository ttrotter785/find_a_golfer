package com.findagolfer.mobile;
import java.util.ArrayList;
import java.util.List;

import com.admob.android.ads.AdView;
import com.findagolfer.mobile.entities.ConfigurationData;
import com.findagolfer.mobile.entities.Golfer;
import com.findagolfer.mobile.entities.LogInfo;
import com.findagolfer.mobile.entities.PrivateMessage;
import com.findagolfer.mobile.entities.VoidOperationResult;
import com.findagolfer.mobile.interfaces.IMessageService;
import com.findagolfer.mobile.interfaces.IMessageServiceCallbackListener;
import com.findagolfer.mobile.services.ServiceLocator;
import com.findagolfer.mobile.utilities.AdHelper;
import com.findagolfer.mobile.utilities.BackgroundTaskDelegate;
import com.findagolfer.mobile.utilities.LogInHelper;
import com.findagolfer.mobile.utilities.ProgressBarAsyncTask;
import com.findagolfer.mobile.utilities.ServiceResponseListener;
import com.findagolfer.mobile.utilities.Utilities.UIUtilities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SlidingDrawer;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;

public class Main extends BaseActivity implements ServiceResponseListener<Object> {

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
	private int SETTINGSINTENTHANDLE = 299481;
	private Button btnMyAcct;
	private Button btnViewGolfers;
	private Button btnViewFeedback;
	private Button btnHelp;
	private Button btnViewCourses;
	private ListView listNotifications;
	private List<PrivateMessage> _notifications;
	private List<PrivateMessage> _sortedNotifications;
	private TextView txtNotificationsHeader;
	private Button btnLogout;
	private int numUnreadMessages=0;
	private SlidingDrawer drawerNotifications;
	private ArrayAdapter<PrivateMessage> listAdapter; 
	private IMessageService mService = null;
	private boolean mIsBound;
	private Golfer golfer;
	private Dialog dialog;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
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
	}
	
	@Override 
	public void onResume(){
		
		super.onResume();
		
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
    	ProgressBarAsyncTask getConfigDataTask = new ProgressBarAsyncTask(Main.this, Main.this);
    	getConfigDataTask._dialogMessage = "Checking for updates...";
    	
    	BackgroundTaskDelegate<String> handler = new BackgroundTaskDelegate<String>() {

			public Object setBackgroundTask() {
				return ServiceLocator.getInstance().GetCurrentServiceConfiguration(configUrl, finalVersion);
			}
    		
    	};
    	getConfigDataTask.execute(handler); 
	}

	private BroadcastReceiver logoutReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("onReceive","Logout in progress");
            //At this point you should start the login activity and finish this one
            startActivity(new Intent(Main.this, Main.class));
            finish();
        }
    };
	
	@Override 
	public void onDestroy(){
		super.onDestroy();
		unregisterReceiver(logoutReceiver);
		if(mIsBound){
			unbindService(mConnection);
			mIsBound = false;
		}
	}

	
	 /**
     * Class for interacting with the main interface of the service.
     */
    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className,
                IBinder service) {
            // This is called when the connection with the service has been
            // established, giving us the service object we can use to
            // interact with the service.  We are communicating with our
            // service through an IDL interface, so get a client-side
            // representation of that from the raw service object.
            mService = IMessageService.Stub.asInterface(service);

            // We want to monitor the service for as long as we are
            // connected to it.
            try {
                mService.setGolferId(Main.this.getGolfer().getGolferId());
                mService.setCurrentNotifications(_notifications);
                mService.registerCallback(callbackListener);
                
            } catch (RemoteException e) {
                // In this case the service has crashed before we could even
                // do anything with it; we can count on soon being
                // disconnected (and then reconnected if it can be restarted)
                // so there is no need to do anything here.
            }
        }

        public void onServiceDisconnected(ComponentName className) {
            // This is called when the connection with the service has been
            // unexpectedly disconnected -- that is, its process crashed.
            mService = null;
        }
    };

    private void RunMessageService(final List<PrivateMessage> notifications){
		//start our message service that polls for new notifications

    	if(mIsBound == false){
	    	bindService(new Intent(IMessageService.class.getName()),
	                mConnection, Context.BIND_AUTO_CREATE);
	    	mIsBound = true;
    	}
	}
    
    
    private IMessageServiceCallbackListener callbackListener = new IMessageServiceCallbackListener.Stub() {

		public void getNewMessageList(final List<PrivateMessage> newMessages)
				throws RemoteException {
			 // make sure this runs in the UI thread... since it's messing with views...
		      Main.this.runOnUiThread(
		          new Runnable() {
		            public void run() {
		            	
		            	if(newMessages == null || _notifications == null)
		            		return;
			            
		            	numUnreadMessages = newMessages.size();
		            	_sortedNotifications.addAll(newMessages); //adds to end, resort

			            // tell the view to refresh since the model changed.
				        listAdapter.notifyDataSetChanged();
				        txtNotificationsHeader.setText(String.format("Notifications (%d)", numUnreadMessages));   
			            
		            }
		          });
		}
	  };
    
	private void BindNotifications() {
		
		ProgressBarAsyncTask pollingTask = new ProgressBarAsyncTask(Main.this, Main.this);
		pollingTask._dialogMessage="Getting notifications...";
		final String sGolferId = String.valueOf(Main.this.getGolfer().getGolferId());
		BackgroundTaskDelegate<String> delegate = new BackgroundTaskDelegate<String>(){
			public Object setBackgroundTask() {
				return ServiceLocator.getInstance().getPrivateMessages(sGolferId);
			}
		};
		pollingTask.execute(delegate);
	}
	
	private OnDrawerOpenListener onDrawerOpenListener = new OnDrawerOpenListener(){

		public void onDrawerOpened() {
			if(_notifications != null){
				if(!_notifications.isEmpty()){
					txtNotificationsHeader.setText("Notifications");
				}
			}
		}
		
	};
	
	private OnClickListener feedbackListener = new OnClickListener(){

		public void onClick(View v) {
			v.startAnimation(AnimationUtils.loadAnimation(Main.this, R.anim.button_click));
			startActivity(new Intent(Main.this, Feedback.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK).putExtra(getString(R.string.intentextras_golfer_keyname), Main.this.getGolfer()));;
		}
		
	};
	
	private OnClickListener coursesClickListener = new OnClickListener(){

		public void onClick(View v) {
			v.startAnimation(AnimationUtils.loadAnimation(Main.this, R.anim.button_click));
			startActivity(new Intent(Main.this, CourseList.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK).putExtra(getString(R.string.intentextras_golfer_keyname), Main.this.getGolfer()));;
		}
		
	};
	
	private OnClickListener logoutClickListener = new OnClickListener(){

		public void onClick(View v) {
			v.startAnimation(AnimationUtils.loadAnimation(Main.this, R.anim.button_click));
			Main.this.Logout();
			_notifications.clear();
			unbindService(mConnection);
			mIsBound = false;
			
			Intent broadcastIntent = new Intent();
			broadcastIntent.setAction("com.findagolfer.mobile.ACTION_LOGOUT");
			sendBroadcast(broadcastIntent);
			
		}
		
	};

	private OnItemClickListener listClickListener = new OnItemClickListener(){

		public void onItemClick(AdapterView<?> adapter, View view, int position,
				long arg3) {
			final PrivateMessage msg = (PrivateMessage)listNotifications.getItemAtPosition(position);
			final List<Integer> receivingGolferIds = new ArrayList<Integer>();
			receivingGolferIds.add(msg.getSendingGolferId());
			
			final CharSequence[] items = {"Reply to this message", "View sender's profile"};

			AlertDialog.Builder builder = new AlertDialog.Builder(Main.this);
			builder.setTitle("Options");
			builder.setItems(items, new DialogInterface.OnClickListener() {
			    public void onClick(DialogInterface dialog, int item) {
			        if(items[item] == "Reply to this message"){
			        	
			        	UIUtilities.ShowMessagingDialog(receivingGolferIds, Main.this, Main.this, Main.this.getGolfer().getGolferId());
						
			        } else {
			        	startActivity(new Intent(Main.this, ViewProfile.class).putExtra(getString(R.string.intentextras_golfer_keyname), Main.this.getGolfer()).putExtra(getString(R.string.intentextras_golfer_viewprofileid), msg.getSendingGolferId()));
			        }
			    }
			});
			AlertDialog alert = builder.create();
			alert.show();
		}
		
	};
	
	private OnClickListener viewGolfersClickListener = new OnClickListener(){

		public void onClick(View v) {
			v.startAnimation(AnimationUtils.loadAnimation(Main.this, R.anim.button_click));
			startActivity(new Intent(Main.this, Statuses.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK).putExtra(getString(R.string.intentextras_golfer_keyname), Main.this.getGolfer()));
		}
		
	};
	
	private OnClickListener settingsClickListener = new OnClickListener(){

		public void onClick(View v) {
			v.startAnimation(AnimationUtils.loadAnimation(Main.this, R.anim.button_click));
			Intent settingsIntent = new Intent(Main.this, Settings.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK).putExtra(getString(R.string.intentextras_golfer_keyname), Main.this.getGolfer());
			startActivityForResult(settingsIntent, SETTINGSINTENTHANDLE);
		}
		
	};
	
	private OnClickListener helpClickListener = new OnClickListener(){

		public void onClick(View v) {
			v.startAnimation(AnimationUtils.loadAnimation(Main.this, R.anim.button_click));
			dialog = new Dialog(Main.this);
			dialog.setContentView(R.layout.help);
			dialog.setTitle("Find A Golfer Help");
			dialog.setCancelable(true);

			Button btnCancel = (Button)dialog.findViewById(R.id.Button_Help_Cancel);
			btnCancel.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					v.startAnimation(AnimationUtils.loadAnimation(Main.this, R.anim.button_click));
					dialog.hide();
				}
			});
			dialog.show();
		}
		
	};

	@SuppressWarnings("unchecked")
	public void onServiceResponse(Object result) {
		if(result == null){
			UIUtilities.ShowAlertDialog(this, "Error", "Oops.  Something bad happened.");
		} else {
			
			if(result instanceof List<?>){
				//JUST RECEIVED NOTIFICATIONS
				_notifications = (List<PrivateMessage>)result;
				
				_sortedNotifications = new ArrayList<PrivateMessage>();
				for (int i=_notifications.size()-1; i>=0; i--){
					_sortedNotifications.add(_notifications.get(i));
				}
				
				
				BindNotificationsList();
				RunMessageService(_notifications);
				

			} else if(result instanceof ConfigurationData){
				//FIRST TIME CHECK TO SET THE BASE URL OF OUR SERVICE
        		ConfigurationData baseUrl = (ConfigurationData)result;
        		if(baseUrl.isLocked()){
        			
        			UIUtilities.ShowApplicationLockedDialog(this, Main.this, baseUrl.getMarketUri());
        			
        		} else {
	        		if(baseUrl.isSuccess()){
	        			ServiceLocator.getInstance().setServiceUrl(baseUrl.getBaseUrl());
		        		if(!this.hasValidStoredLoginCredentials()){
		                	ShowLoginScreen();
		                }
		                else{
		                	ShowMainMenuScreen();
		                	PerformLogin();
		                }
		        		this.setServiceUrl(baseUrl.getBaseUrl());
	        		} else {
	        			UIUtilities.ShowAlertDialog(this, "Error", baseUrl.getMessage());
	        		}
        		}
        	} else if (result instanceof Golfer){
        		//JUST LOGGED IN
        		golfer = (Golfer)result;
        	
	        	if(golfer.getErrorMessage().length() > 0){
	        		
	        		UIUtilities.ShowAlertDialog(this, "Login Failed", "Please check your username and password.");
	        		ShowLoginScreen();
	        		
	        	} else {
	        		this.setGolfer(golfer);
	        		this.set_userNamePassword(_userName, _password, _persist);
	        		
	        		ShowMainMenuScreen();
	    			RegisterForLogout();
	        		BindNotifications();
	        	}
        	}
			else {
				//JUST REPLIED TO A MESSAGE
				if(result instanceof VoidOperationResult){
					if(((VoidOperationResult) result).getErrorMessage().length() > 0){
						UIUtilities.ShowAlertDialog(Main.this, "Error", ((VoidOperationResult) result).getErrorMessage());
					} else {
						UIUtilities.ShowAlertDialog(Main.this, "Success!", "Your response to this message has been sent.");
					}
				}
				
			}
			
		}
			
	}
	
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
        if (requestCode == SETTINGSINTENTHANDLE){
        	if (resultCode == RESULT_OK) {
                //USER UPDATED SETTINGS
            }
        }
        
    }
	
	private void RegisterForLogout() {
		IntentFilter intentFilter = new IntentFilter();
	    intentFilter.addAction("com.findagolfer.mobile.ACTION_LOGOUT");
	    registerReceiver(logoutReceiver, intentFilter);
	}

	private void ShowMainMenuScreen(){
		setContentView(R.layout.main);
		
		btnMyAcct = (Button)findViewById(R.id.Button_MyAccount);
		btnViewGolfers = (Button)findViewById(R.id.Button_ViewAvailableGolfers);
		btnViewFeedback = (Button)findViewById(R.id.Button_ViewFeedback);
		btnHelp = (Button)findViewById(R.id.Button_Help);
		listNotifications = (ListView)findViewById(R.id.ListView_Notifications);
		txtNotificationsHeader = (TextView)findViewById(R.id.Notifications_Header);
		btnLogout = (Button)findViewById(R.id.Button_Logout);
		btnViewCourses = (Button)findViewById(R.id.Button_ViewCourses);
		
		drawerNotifications = (SlidingDrawer)findViewById(R.id.SlidingDrawer_Notifications);
		
		btnViewGolfers.setOnClickListener(viewGolfersClickListener);
		btnMyAcct.setOnClickListener(settingsClickListener);
		btnHelp.setOnClickListener(helpClickListener);
		listNotifications.setOnItemClickListener(listClickListener);
		btnLogout.setOnClickListener(logoutClickListener);
		btnViewFeedback.setOnClickListener(feedbackListener);
		drawerNotifications.setOnDrawerOpenListener(onDrawerOpenListener);
		btnViewCourses.setOnClickListener(coursesClickListener);
		AdHelper.getInstance().GetFreshAd((AdView)findViewById(R.id.ad_main));

	}
	
	private void ShowLoginScreen(){
		setContentView(R.layout.login);
		etUserName = (EditText)findViewById(R.id.EditText_Login_UserName);
		etPassword = (EditText)findViewById(R.id.EditText_Login_Password);
		cbRememberLoginInfo = (CheckBox)findViewById(R.id.Checkbox_SaveLoginCredentials);
		btnLogin = (Button)findViewById(R.id.Button_Login);
		btnRegister = (Button)findViewById(R.id.Button_SignUp);
		btnForgotPassword = (Button)findViewById(R.id.Button_ForgotPassword);
		
		btnRegister.setOnClickListener(registerClickListener);
		btnLogin.setOnClickListener(loginClickListener);
		btnForgotPassword.setOnClickListener(forgotClickListener);
		AdHelper.getInstance().GetFreshAd((AdView)findViewById(R.id.ad_login));
        
	}
	
	public OnClickListener loginClickListener = new OnClickListener(){

		public void onClick(View v) {
			v.startAnimation(AnimationUtils.loadAnimation(Main.this, R.anim.button_click));
			PerformLogin();
		}
		
	};
	
	public OnClickListener registerClickListener = new OnClickListener(){

		public void onClick(View v) {
			v.startAnimation(AnimationUtils.loadAnimation(Main.this, R.anim.button_click));
			startActivityForResult(new Intent(Main.this, Register.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK), REGISTERINTENTHANDLE);
		}
		
	};
	
	public OnClickListener forgotClickListener = new OnClickListener(){

		public void onClick(View v) {
			v.startAnimation(AnimationUtils.loadAnimation(Main.this, R.anim.button_click));
			startActivityForResult(new Intent(Main.this, ResetPassword.class), FORGOTHANDLE);
		}
		
	};
	
	private void PerformLogin(){
		if(!this.hasValidStoredLoginCredentials()){
			
			_userName = etUserName.getText().toString();
			_password = etPassword.getText().toString();
			_persist = cbRememberLoginInfo.isChecked();
			
			if(_userName.length() == 0 || _password.length() == 0){
	    		UIUtilities.ShowAlertDialog(this, "Warning", "Please enter a username and password.");
	    		return;
	    	} 
			
		} else {
			//ShowLoginScreen();
			ShowMainMenuScreen();
			_userName = this.get_userName();
			_password = this.get_password();
			_persist = true;
		}
		final LogInfo logInfo = LogInHelper.getInstance().SetLoggingInfo(_userName, _password, Main.this, (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE));
		ServiceLocator.getInstance().setCredentials(_userName, _password);
		ProgressBarAsyncTask loginTask = new ProgressBarAsyncTask(Main.this, Main.this);
		loginTask._dialogMessage =  "Logging in....";
		BackgroundTaskDelegate<Golfer> delegate = new BackgroundTaskDelegate<Golfer>(){
			public Object setBackgroundTask() {
				return ServiceLocator.getInstance().getGolferByUserNameAndPassword(logInfo.toJSON().toString());
			}
		};
		loginTask.execute(delegate);
	}
	
	private void BindNotificationsList(){
		
		listAdapter
			= new ArrayAdapter<PrivateMessage>(this, R.layout.privatemessage, _sortedNotifications){
		
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
					final PrivateMessage message =  _sortedNotifications.get(position);
					View view = (convertView != null) ? (LinearLayout) convertView : createView(parent);

					if(view != null){
						TextView txtMessageBody = (TextView)view.findViewById(R.id.TextView_PrivateMessages_MessageBody);
						if(txtMessageBody != null){
							txtMessageBody.setText(message.getMessage());
						}
						
						TableLayout nextLayout = (TableLayout)view.findViewById(R.id.TableLayout_PrivateMessages);
						
						if(nextLayout != null){
							TextView txtSender = (TextView)nextLayout.findViewById(R.id.TextView_PrivateMessages_ScreenName);
							TextView txtCreatedDate = (TextView)nextLayout.findViewById(R.id.TextView_PrivateMessages_WhenSent);
							
							txtCreatedDate.setText(UIUtilities.DateDiffText(message.getCreateDateTime()));
							txtSender.setText(message.getSendingGolferScreenName());
						}
						
					}
					return view;
				}
				
				private View createView(ViewGroup parent){
					View item = (LinearLayout)getLayoutInflater().inflate(R.layout.privatemessage, parent, false);
					return item;
				}
		};

		listNotifications.setAdapter(listAdapter);
	}
	
}