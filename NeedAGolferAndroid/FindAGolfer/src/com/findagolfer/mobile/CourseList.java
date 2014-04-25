package com.findagolfer.mobile;

import java.text.DecimalFormat;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.admob.android.ads.AdView;
import com.findagolfer.mobile.entities.GolfCourse;
import com.findagolfer.mobile.entities.Golfer;
import com.findagolfer.mobile.parameters.GolfCoursesNearbySearchParameter;
import com.findagolfer.mobile.services.ServiceLocator;
import com.findagolfer.mobile.utilities.AdHelper;
import com.findagolfer.mobile.utilities.BackgroundTaskDelegate;
import com.findagolfer.mobile.utilities.LocationHelper;
import com.findagolfer.mobile.utilities.ProgressBarAsyncTask;
import com.findagolfer.mobile.utilities.ServiceResponseListener;
import com.findagolfer.mobile.utilities.LocationHelper.LocationResult;
import com.findagolfer.mobile.utilities.Utilities.UIUtilities;

public class CourseList extends BaseActivity implements ServiceResponseListener<Object> {

	ProgressDialog tempDialog;
	double latitude;
	double longitude;
	List<GolfCourse> nearbyCourses;
	ListView listCourses;
	DecimalFormat oneDecimalFormat = new DecimalFormat("#.#");
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.courselist);

		AdHelper.getInstance().GetFreshAd((AdView)findViewById(R.id.ad_courselist));
        InstantiateControls();
		
		tempDialog = new ProgressDialog(this);
        tempDialog.setMessage("Getting your location....");
        tempDialog.show();
        
        GetLocation();
	        
		IntentFilter intentFilter = new IntentFilter();
	    intentFilter.addAction("com.findagolfer.mobile.ACTION_LOGOUT");
	    registerReceiver(logoutReceiver, intentFilter);
	}
	
	private void GetLocation() {
		LocationHelper locationHelper = new LocationHelper();
		locationHelper.getLocation(CourseList.this, new LocationResult(){
			@Override
			public void gotLocation(final Location location){
				latitude = location.getLatitude();
				longitude = location.getLongitude();
				RetrieveCourses(latitude, longitude);
			}

		});
	}
	
	private void RetrieveCourses(double latitude, double longitude) {
		
		final GolfCoursesNearbySearchParameter searchParameter = new GolfCoursesNearbySearchParameter();
		searchParameter.setLatitude(latitude);
		searchParameter.setLongitude(longitude);
		searchParameter.setRadius(this.getSearchPreference_CourseDistance());
		searchParameter.setCourseType("Public");
		
		ProgressBarAsyncTask getCoursesTask = new ProgressBarAsyncTask(CourseList.this, CourseList.this);
		
		getCoursesTask._dialogMessage =  "Finding nearby courses....";
		BackgroundTaskDelegate<Golfer> delegate = new BackgroundTaskDelegate<Golfer>(){
			public Object setBackgroundTask() {
				return ServiceLocator.getInstance().getNearbyGolfCourses(searchParameter.toJSON().toString());
			}
		};
		tempDialog.dismiss();
		getCoursesTask.execute(delegate);
	}


	private void InstantiateControls() {
		listCourses = (ListView)findViewById(R.id.ListView_CourseList);
		listCourses.setOnItemClickListener(listCourseClickListener);
	}
	
	private OnItemClickListener listCourseClickListener = new OnItemClickListener(){

		public void onItemClick(AdapterView<?> adapterView, View v, int position,
				long arg3) {
			GolfCourse golfCourse = (GolfCourse)listCourses.getItemAtPosition(position);
			startActivity(new Intent(CourseList.this, ViewCourse.class).putExtra(getString(R.string.intentextras_golfer_viewcourseid), golfCourse.getGolfcourse_id()));
		}
		
	};

	private BroadcastReceiver logoutReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("onReceive","Logout in progress");
            //At this point you should start the login activity and finish this one
            startActivity(new Intent(CourseList.this, Main.class));
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
			UIUtilities.ShowAlertDialog(this, "Error", "Could not get nearby courses.");
		} else {
			
			nearbyCourses = (List<GolfCourse>)result;
			
			if(nearbyCourses != null){
    			BindGolfCourseList();
    		} else {
    			UIUtilities.ShowAlertDialog(this, "Alert", "No golf courses found.");
    		}
		}
	}

	private void BindGolfCourseList() {
		ArrayAdapter<GolfCourse> listAdapter 
				= new ArrayAdapter<GolfCourse>(this, R.layout.courselist_listitem, nearbyCourses){
			
				@Override
				public View getView(int position, View convertView, ViewGroup parent) {
					final GolfCourse course =  nearbyCourses.get(position);
					View view = (convertView != null) ? (RelativeLayout) convertView : createView(parent, course);
					
					if(view != null){
						TextView txtName = (TextView)view.findViewById(R.id.TextView_Courses_CourseName);
						if(txtName != null){
							txtName.setText(course.getCourseName());
						}
						TextView txtDistance = (TextView)view.findViewById(R.id.TextView_Courses_Distance);
						if(txtDistance != null){
							double distance = Double.parseDouble(course.getDistance());
							txtDistance.setText(String.format("%s miles", Double.valueOf(oneDecimalFormat.format(distance))));
						}
						
						
					}
					return view;
				}
				
				private View createView(ViewGroup parent, GolfCourse course){
					View item = (RelativeLayout)getLayoutInflater().inflate(R.layout.courselist_listitem, parent, false);
					return item;
				}
		};

		listCourses.setAdapter(listAdapter);
	}

}
