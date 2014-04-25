package com.findagolfer.mobile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.findagolfer.mobile.entities.Golfer;
import com.findagolfer.mobile.entities.StatusMessage;
import com.findagolfer.mobile.entities.VoidOperationResult;
import com.findagolfer.mobile.parameters.GolfersNearbySearchParameter;
import com.findagolfer.mobile.services.ServiceLocator;
import com.findagolfer.mobile.utilities.BackgroundTaskDelegate;
import com.findagolfer.mobile.utilities.LocationHelper;
import com.findagolfer.mobile.utilities.ProgressBarAsyncTask;
import com.findagolfer.mobile.utilities.ServiceResponseListener;
import com.findagolfer.mobile.utilities.SimpleAsyncTask;
import com.findagolfer.mobile.utilities.LocationHelper.LocationResult;
import com.findagolfer.mobile.utilities.Utilities.UIUtilities;

public class Statuses  extends BaseActivity implements ServiceResponseListener<Object> {

	EditText etStatus;
	Button btnUpdateStatus;
	Button btnSendMessage;
	ListView listStatuses;
	List<StatusMessage> statusMessages;
	double latitude;
	double longitude;
	List<StatusMessage> selectedGolfers;
	ProgressDialog tempDialog;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statuses);
        
        //AdHelper.getInstance().GetFreshAd((AdView)findViewById(R.id.ad_statuses));
        InstantiateControls();
        
        tempDialog = new ProgressDialog(this);
        tempDialog.setMessage("Getting your location....");
        tempDialog.show();
        
        GetLocation();
        
        Toast.makeText(this, "Swipe down to refresh the list.", Toast.LENGTH_LONG);
        
        IntentFilter intentFilter = new IntentFilter();
	    intentFilter.addAction("com.findagolfer.mobile.ACTION_LOGOUT");
	    registerReceiver(logoutReceiver, intentFilter);
        
	}

	private BroadcastReceiver logoutReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("onReceive","Logout in progress");
            //At this point you should start the login activity and finish this one
            startActivity(new Intent(Statuses.this, Main.class));
            finish();
        }
    };
    
    @Override
    public void onResume(){
    	super.onResume();
    	if(latitude > 0.0 && longitude > 0.0){
    		RetrieveMessages(latitude, longitude, false, false);
    	}
    }
    
    @Override 
	public void onDestroy(){
		super.onDestroy();
		unregisterReceiver(logoutReceiver);
	}

    
	private void GetLocation() {
		LocationHelper locationHelper = new LocationHelper();
		locationHelper.getLocation(Statuses.this, new LocationResult(){
			@Override
			public void gotLocation(final Location location){
				latitude = location.getLatitude();
				longitude = location.getLongitude();
				RetrieveMessages(latitude, longitude, false, false);
			}

		});
	}


	private void InstantiateControls() {
		etStatus = (EditText)findViewById(R.id.EditText_StatusMessage);
		btnUpdateStatus = (Button)findViewById(R.id.Button_UpdateStatus);
		btnSendMessage = (Button)findViewById(R.id.Button_SendMessage);
		listStatuses = (ListView)findViewById(R.id.ListView_StatusMessages);
		
		btnUpdateStatus.setOnClickListener(updateStatusClickListener);
		btnSendMessage.setOnClickListener(sendMessageClickListener);

		selectedGolfers = new ArrayList<StatusMessage>();
		listStatuses.setOnItemClickListener(statusItemClickListener);

	}
	
	private OnItemClickListener statusItemClickListener = new OnItemClickListener(){

		public void onItemClick(AdapterView<?> adapterView, View v, int position,
				long arg3) {
			StatusMessage msg = (StatusMessage)listStatuses.getItemAtPosition(position);
			startActivity(new Intent(Statuses.this, ViewProfile.class).putExtra(getString(R.string.intentextras_golfer_keyname), Statuses.this.getGolfer()).putExtra(getString(R.string.intentextras_golfer_viewprofileid), msg.getGolferid()));
		}
		
	};
	
	private OnClickListener updateStatusClickListener = new OnClickListener(){

		public void onClick(View v) {
			v.startAnimation(AnimationUtils.loadAnimation(Statuses.this, R.anim.button_click));
			RetrieveMessages(latitude, longitude, true, false);
		}
		
	};
	
	
	private OnClickListener sendMessageClickListener = new OnClickListener(){

		public void onClick(View v) {
			if(!selectedGolfers.isEmpty()){
				v.startAnimation(AnimationUtils.loadAnimation(Statuses.this, R.anim.button_click));
				List<Integer> receivingGolferIds = new ArrayList<Integer>();
				Iterator<StatusMessage> i = selectedGolfers.iterator();
				while(i.hasNext()){
					StatusMessage message = i.next();
					receivingGolferIds.add(message.getGolferid());
				}
				UIUtilities.ShowMessagingDialog(receivingGolferIds, Statuses.this, Statuses.this, Statuses.this.getGolfer().getGolferId());
				
			} else {
				UIUtilities.ShowAlertDialog(Statuses.this, "Error", "You must select one or more messages/golfers to reply to");
			}
		}
		
	};
	
	private void RetrieveMessages(double latitude, double longitude, boolean isStatusUpdate, boolean isBackground) {
		
		final GolfersNearbySearchParameter searchParameter = new GolfersNearbySearchParameter();
		searchParameter.setLatitude(latitude);
		searchParameter.setLongitude(longitude);
		searchParameter.setRadius(this.getSearchPreference_Radius());
		searchParameter.setRating(this.getSearchPreference_Rating());
		searchParameter.setHandicap(this.getSearchPreference_Handicap());
		searchParameter.setGolferid(this.getGolfer().getGolferId());
		
		ProgressBarAsyncTask retrieveMessagesTask = new ProgressBarAsyncTask(Statuses.this, Statuses.this);
		
		if(!isStatusUpdate){
			
			if(!isBackground){
				retrieveMessagesTask._dialogMessage =  "Finding nearby golfers....";
				BackgroundTaskDelegate<Golfer> delegate = new BackgroundTaskDelegate<Golfer>(){
					public Object setBackgroundTask() {
						return ServiceLocator.getInstance().getNearbyGolfers(searchParameter.toJSON().toString());
					}
				};
				tempDialog.dismiss();
				retrieveMessagesTask.execute(delegate);
			} else {
				//NO LOADING DIALOG
				SimpleAsyncTask messageTask = new SimpleAsyncTask(Statuses.this, Statuses.this);
				BackgroundTaskDelegate<Golfer> delegate = new BackgroundTaskDelegate<Golfer>(){
					public Object setBackgroundTask() {
						return ServiceLocator.getInstance().getNearbyGolfers(searchParameter.toJSON().toString());
					}
				};
				messageTask.execute(delegate);
			}
		} else {
			
			if(etStatus.getText().toString().length() > 0){
				searchParameter.setGolferid(this.getGolfer().getGolferId());
				searchParameter.setMessage(etStatus.getText().toString());
				retrieveMessagesTask._dialogMessage =  "Updating status....";
				BackgroundTaskDelegate<Golfer> delegate = new BackgroundTaskDelegate<Golfer>(){
					public Object setBackgroundTask() {
						return ServiceLocator.getInstance().updateGolferStatus(searchParameter.toJSON().toString());
					}
				};
				retrieveMessagesTask.execute(delegate);
				
			} else {
				UIUtilities.ShowAlertDialog(Statuses.this, "Error", "You must supply text for your status update.");
			}
		}
	}

	public void onServiceResponse(Object result) {
		if(result == null){
			UIUtilities.ShowAlertDialog(this, "Error", "Oops.  Something bad happened.");
		} else {
			
			if(result instanceof List<?>){
				
				statusMessages = (List<StatusMessage>)result;
				if(statusMessages.size() == 0){
					UIUtilities.ShowAlertDialog(this, "No golfers found", "You may want to expand your search criteria by changing your Settings and Preferences, or encourage some friends to sign up!");
					
				} else {
					BindSearchResultsToList();
					etStatus.setText("");
				}
			}
			
			if(result instanceof VoidOperationResult){
				if(((VoidOperationResult) result).getErrorMessage().length() > 0){
					UIUtilities.ShowAlertDialog(Statuses.this, "Error", ((VoidOperationResult) result).getErrorMessage());
				} else {
					if(selectedGolfers.size() > 1){
						UIUtilities.ShowAlertDialog(Statuses.this, "Success!", "You have successfully sent these golfers a private message.  Check your notifications for responses.");
					} else {
						UIUtilities.ShowAlertDialog(Statuses.this, "Success!", "You have successfully sent " + ((StatusMessage)selectedGolfers.get(0)).getScreenName() + " a private message.  Check your notifications for responses.");
					}
				}
			}
		}
	}


	private void BindSearchResultsToList() {
		ArrayAdapter<StatusMessage> listAdapter 
			= new ArrayAdapter<StatusMessage>(this, R.layout.statuses_listitem, statusMessages){
			
				@Override
				public View getView(int position, View convertView, ViewGroup parent) {
					final StatusMessage message =  statusMessages.get(position);
					View view = (convertView != null) ? (RelativeLayout) convertView : createView(parent, message);
					if(view != null){
						TextView txtMessage = (TextView)view.findViewById(R.id.TextView_StatusMessage);
						TextView txtScreenName = (TextView)view.findViewById(R.id.TextView_ScreenName);
						TextView txtHandicap = (TextView)view.findViewById(R.id.TextView_Handicap);
						TextView txtWhenUpdated = (TextView)view.findViewById(R.id.TextView_WhenUpdated);
						RatingBar rating = (RatingBar)view.findViewById(R.id.RatingBar_List);
						CheckBox cbSelected = (CheckBox)view.findViewById(R.id.CheckBox_SendMessage);
						OnCheckedChangeListener checkBoxListener = new OnCheckedChangeListener(){

							public void onCheckedChanged(CompoundButton arg0,
									boolean isChecked) {
								if(isChecked){
									selectedGolfers.add(message);
								}else {
									selectedGolfers.remove(message);
								}
							}
							
						};
						
						//check to see if our views are being recycled...if they are, then we need to clear
						//the checkbox state of payment items that have already been displayed
						if(convertView != null){
							cbSelected.setOnCheckedChangeListener(null);
							cbSelected.setChecked(false);
						}
						cbSelected.setOnCheckedChangeListener(checkBoxListener);
						
						txtWhenUpdated.setText(UIUtilities.DateDiffText(message.getMessageCreateDate()));
						txtMessage.setText(message.getMessage());
						txtScreenName.setText(message.getScreenName());
						txtHandicap.setText(String.valueOf(message.getHandicap()));
						rating.setRating(Float.valueOf(String.valueOf(message.getRating())));
					}
					return view;
				}
				
				private View createView(ViewGroup parent, StatusMessage message){
					View item = (RelativeLayout)getLayoutInflater().inflate(R.layout.statuses_listitem, parent, false);
					return item;
				}
		};
		listStatuses.setAdapter(listAdapter);
	}
}
