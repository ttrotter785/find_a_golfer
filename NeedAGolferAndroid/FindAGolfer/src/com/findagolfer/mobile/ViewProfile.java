package com.findagolfer.mobile;


import java.util.List;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TableLayout;
import android.widget.TextView;
import com.findagolfer.mobile.entities.Golfer;
import com.findagolfer.mobile.entities.GolferProfileView;
import com.findagolfer.mobile.entities.GolferRating;
import com.findagolfer.mobile.entities.VoidOperationResult;
import com.findagolfer.mobile.parameters.GolferRatingParameter;
import com.findagolfer.mobile.services.ServiceLocator;
import com.findagolfer.mobile.utilities.BackgroundTaskDelegate;
import com.findagolfer.mobile.utilities.ProgressBarAsyncTask;
import com.findagolfer.mobile.utilities.ServiceResponseListener;
import com.findagolfer.mobile.utilities.Utilities.UIUtilities;

public class ViewProfile extends BaseActivity implements ServiceResponseListener<Object> {

	private TextView txtScreenName;
	private TextView txtHandicap;
	private RatingBar ratingBar;
	private TextView txtNumRatings;
	private CheckBox chkIsAvailable;
	private ListView listComments;
	private List<GolferRating> comments;
	private Integer selectedGolferId;
	private Button btnRateThisGolfer;
	private Dialog dialog;
	private GolferProfileView profile;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewprofile);

        Bundle extras = this.getIntent().getExtras();
		if(extras != null){
			if(extras.get(getString(R.string.intentextras_golfer_viewprofileid)) != null){
				selectedGolferId = (Integer)extras.get(getString(R.string.intentextras_golfer_viewprofileid));
			}
		}

		InstantiateControls();
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
            startActivity(new Intent(ViewProfile.this, Main.class));
            finish();
        }
    };
    
    @Override 
	public void onDestroy(){
		super.onDestroy();
		unregisterReceiver(logoutReceiver);
	}

	private void WireUpProfile() {
		
		ProgressBarAsyncTask bindProfileTask = new ProgressBarAsyncTask(ViewProfile.this, ViewProfile.this);
		bindProfileTask._dialogMessage =  "Retrieving golfer profile....";
		BackgroundTaskDelegate<Golfer> delegate = new BackgroundTaskDelegate<Golfer>(){
			public Object setBackgroundTask() {
				return ServiceLocator.getInstance().getGolferProfileByGolferId(selectedGolferId.toString());
			}
		};
		bindProfileTask.execute(delegate);
		
	}

	private void InstantiateControls() {
		txtScreenName = (TextView)findViewById(R.id.TextView_Profile_ScreenName);
		txtHandicap = (TextView)findViewById(R.id.TextView_Profile_Handicap);
		txtNumRatings = (TextView)findViewById(R.id.TextView_Profile_NumRatings);
		ratingBar = (RatingBar)findViewById(R.id.RatingBar_Profile_Rating);
		listComments = (ListView)findViewById(R.id.ListView_ViewProfile_Comments);
		btnRateThisGolfer = (Button)findViewById(R.id.Button_Profile_RateThisGolfer);
		chkIsAvailable = (CheckBox)findViewById(R.id.CheckBox_Profile_IsAvailable);
		dialog = new Dialog(this);
		
		btnRateThisGolfer.setOnClickListener(rateClickListener);
		
		if(selectedGolferId == this.getGolfer().getGolferId()){
			//disable the ratings button
			btnRateThisGolfer.setEnabled(false);
		}
	}
	
	private OnClickListener rateClickListener = new OnClickListener(){

		public void onClick(View v) {
			v.startAnimation(AnimationUtils.loadAnimation(ViewProfile.this, R.anim.button_click));
			dialog.setContentView(R.layout.create_rating);
			dialog.setTitle("Rate This Golfer");
			dialog.setCancelable(true);

			Button btnCancel = (Button)dialog.findViewById(R.id.Button_CreateRating_Cancel);
			Button btnSend = (Button)dialog.findViewById(R.id.Button_CreateRating_Send);
			final RatingBar ratingBar = (RatingBar)dialog.findViewById(R.id.RatingBar_CreateRating_Rating);
			final EditText etMessage = (EditText)dialog.findViewById(R.id.EditText_CreateRating_Text);
			
			btnCancel.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					v.startAnimation(AnimationUtils.loadAnimation(ViewProfile.this, R.anim.button_click));
					dialog.hide();
				}
			});

			btnSend.setOnClickListener(new OnClickListener(){
			
				public void onClick(View v) {
					v.startAnimation(AnimationUtils.loadAnimation(ViewProfile.this, R.anim.button_click));
					if(etMessage.getText().toString().length() > 0){
						final GolferRatingParameter parameter = new GolferRatingParameter();
						parameter.setSubmittingGolferId(ViewProfile.this.getGolfer().getGolferId());
						parameter.setGolferId(profile.getGolfer().getGolferId());
						parameter.setRating((int)ratingBar.getRating());
						parameter.setComments(etMessage.getText().toString());
						ProgressBarAsyncTask sendTask = new ProgressBarAsyncTask(ViewProfile.this, ViewProfile.this);
						sendTask._dialogMessage =  "Sending....";
						BackgroundTaskDelegate<String> delegate = new BackgroundTaskDelegate<String>(){
							public Object setBackgroundTask() {
								return ServiceLocator.getInstance().createGolferRating(parameter.toJSON().toString());
							}
						};
						sendTask.execute(delegate);
					}
				}
				
			});
			dialog.show();
		}
		
		
	};

	public void onServiceResponse(Object result) {
		if(result == null){
			UIUtilities.ShowAlertDialog(this, "View Profile Error", "Oops.  Something bad happened.");
		} else {
			
			if(result instanceof GolferProfileView){
				profile = (GolferProfileView)result;
	        	if(profile.getGolfer().getErrorMessage().length() > 0){
	        		UIUtilities.ShowAlertDialog(this, "Error", profile.getGolfer().getErrorMessage());
	        	} else {
	        		txtScreenName.setText(profile.getGolfer().getScreenName());
	        		txtHandicap.setText(String.valueOf(profile.getGolfer().getHandicap()));
	        		txtNumRatings.setText(String.valueOf(profile.getGolfer().getNumRatings()));
	        		chkIsAvailable.setChecked(profile.getGolfer().isAvailable());
	        		ratingBar.setRating((float)profile.getGolfer().getRating());
	        		comments = profile.getRatings();
	        		
	        		if(comments != null){
	        			BindCommentsList();
	        		}
	        	}
			} else {
				VoidOperationResult operationResult = (VoidOperationResult)result;
				if(operationResult.getErrorMessage().length() > 0){
					UIUtilities.ShowAlertDialog(this, "Error", operationResult.getErrorMessage());
				} else {
					UIUtilities.ShowAlertDialog(this, "Thank You", "Your comment and rating has been received.");
					dialog.hide();
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
		
		listComments.setAdapter(listAdapter);
	}

}
