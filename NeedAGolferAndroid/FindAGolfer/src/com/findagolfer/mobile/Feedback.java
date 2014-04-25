package com.findagolfer.mobile;

import java.util.List;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TableLayout;
import android.widget.TextView;

import com.admob.android.ads.AdView;
import com.findagolfer.mobile.entities.Golfer;
import com.findagolfer.mobile.entities.GolferProfileView;
import com.findagolfer.mobile.entities.GolferRating;
import com.findagolfer.mobile.services.ServiceLocator;
import com.findagolfer.mobile.utilities.AdHelper;
import com.findagolfer.mobile.utilities.BackgroundTaskDelegate;
import com.findagolfer.mobile.utilities.ProgressBarAsyncTask;
import com.findagolfer.mobile.utilities.ServiceResponseListener;
import com.findagolfer.mobile.utilities.Utilities.UIUtilities;

public class Feedback extends BaseActivity implements ServiceResponseListener<Object> {

	private ListView listFeedback;
	private GolferProfileView profile;
	private List<GolferRating> comments;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewfeedback);
        
        AdHelper.getInstance().GetFreshAd((AdView)findViewById(R.id.ad_feedback));
        listFeedback = (ListView)findViewById(R.id.ListView_ViewFeedback_Comments);
        WireUpProfile();
        
        IntentFilter intentFilter = new IntentFilter();
	    intentFilter.addAction("com.findagolfer.mobile.ACTION_LOGOUT");
	    registerReceiver(logoutReceiver, intentFilter);
       
	}
	
	private BroadcastReceiver logoutReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("onReceive","Logout in progress");
            //At this point you should start the login activity and finish this one
            startActivity(new Intent(Feedback.this, Main.class));
            finish();
        }
    };
    
    @Override 
	public void onDestroy(){
		super.onDestroy();
		unregisterReceiver(logoutReceiver);
	}

	
	private void WireUpProfile() {
		
		ProgressBarAsyncTask bindProfileTask = new ProgressBarAsyncTask(Feedback.this, Feedback.this);
		bindProfileTask._dialogMessage =  "Retrieving your feedback....";
		BackgroundTaskDelegate<Golfer> delegate = new BackgroundTaskDelegate<Golfer>(){
			public Object setBackgroundTask() {
				return ServiceLocator.getInstance().getGolferProfileByGolferId(String.valueOf(Feedback.this.getGolfer().getGolferId()));
			}
		};
		bindProfileTask.execute(delegate);
		
	}

	public void onServiceResponse(Object result) {
		if(result == null){
			UIUtilities.ShowAlertDialog(this, "View Profile Error", "Oops.  Something bad happened.");
		} else {
			
			if(result instanceof GolferProfileView){
				profile = (GolferProfileView)result;
	        	if(profile.getGolfer().getErrorMessage().length() > 0){
	        		UIUtilities.ShowAlertDialog(this, "Error", profile.getGolfer().getErrorMessage());
	        	} else {
	        		comments = profile.getRatings();
	        		
	        		if(comments != null){
	        			BindCommentsList();
	        		} else {
	        			UIUtilities.ShowAlertDialog(this, "Alert", "You have no feedback at this time.");
	        		}
	        	}
			} 
		}
	}
	
	private void BindCommentsList(){
		ArrayAdapter<GolferRating> listAdapter 
				= new ArrayAdapter<GolferRating>(this, R.layout.viewprofile_comments_listitem, comments){
			
				@Override
				public View getView(int position, View convertView, ViewGroup parent) {
					final GolferRating rating =  comments.get(position);
					View view = (convertView != null) ? (LinearLayout) convertView : createView(parent);
					
					if(view != null){
						TextView txtComment = (TextView)view.findViewById(R.id.TextView_ViewProfile_Comments_Comment);
						if(txtComment != null){
							txtComment.setText(rating.getComments());
						}
						
						TableLayout nextLayout = (TableLayout)view.findViewById(R.id.TableLayout_ProfileComments);
						
						if(nextLayout != null){
							
							TextView txtScreenName = (TextView)nextLayout.findViewById(R.id.TextView_ViewProfile_Comments_ScreenName);
							TextView txtCreatedDate = (TextView)nextLayout.findViewById(R.id.TextView_ViewProfile_Comments_CreatedDate);
							RatingBar singleRating = (RatingBar)nextLayout.findViewById(R.id.RatingBar_ViewProfile_Comments_Rating);
							txtCreatedDate.setText(UIUtilities.DateDiffText(rating.getCreateDateTime()));
							txtScreenName.setText(rating.getSubmitterName());
							singleRating.setRating((float)rating.getRating());
						}
						
					}
					return view;
				}
				
				private View createView(ViewGroup parent){
					View item = (LinearLayout)getLayoutInflater().inflate(R.layout.viewprofile_comments_listitem, parent, false);
					return item;
				}
		};
		
		listFeedback.setAdapter(listAdapter);
	}

}
