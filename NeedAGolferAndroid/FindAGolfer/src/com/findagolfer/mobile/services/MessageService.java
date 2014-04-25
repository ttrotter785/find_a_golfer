package com.findagolfer.mobile.services;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.findagolfer.mobile.R.drawable;
import com.findagolfer.mobile.entities.PrivateMessage;
import com.findagolfer.mobile.interfaces.IMessageService;
import com.findagolfer.mobile.interfaces.IMessageServiceCallbackListener;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;

public class MessageService extends Service {

	private Timer timer = new Timer();
	private static final long UPDATE_INTERVAL = 100000;
	private static final int GOLFERMESSAGENOTIFICATIONSID = 1111;
	private static int GolferId;
	private static List<PrivateMessage> DataFromServlet;
	private static List<PrivateMessage> CurrentDataSet;
	private static List<PrivateMessage> NewMessages;
	final RemoteCallbackList<IMessageServiceCallbackListener> mCallbacks = 
		new RemoteCallbackList<IMessageServiceCallbackListener>();
	
	@Override
	public void onCreate(){
		timer.scheduleAtFixedRate(
		    new TimerTask() {
		    public void run() {
		      _getNotifications();
		    }
		  },
		  90000,
		  UPDATE_INTERVAL);
	}
	
	@Override 
	public void onDestroy() {
		if(CurrentDataSet != null)
			CurrentDataSet.clear();
		if(NewMessages != null)
			NewMessages.clear();
		if(DataFromServlet != null)
			DataFromServlet.clear();
		
		if(mCallbacks != null)
			mCallbacks.kill();
		if (timer != null) 
			timer.cancel();
	}
	
	public IBinder onBind(Intent intent) {
		// Select the interface to return.  If your service only implements
        // a single interface, you can just return it here without checking
        // the Intent.
        if (IMessageService.class.getName().equals(intent.getAction())) {
            return mBinder;
        }

        return null;
	}
	
	/**
     * The IRemoteInterface is defined through IDL
     */
    private final IMessageService.Stub mBinder = new IMessageService.Stub() {
        
		public List<PrivateMessage> getNewNotifications() throws RemoteException {
			return DataFromServlet;
		}

		public void setCurrentNotifications(List<PrivateMessage> notifications)
				throws RemoteException {
			CurrentDataSet = notifications;
		}
		public void setGolferId(int golferId) throws RemoteException {
			GolferId = golferId;
		}
		public void registerCallback(IMessageServiceCallbackListener listener)
				throws RemoteException {
			if(listener != null){ mCallbacks.register(listener); }
		}	
	};
	
	
	/** dont forget to fire update to the ui listener */
	private void _getNotifications() {

	  try {

		DataFromServlet = ServiceLocator.getInstance().getPrivateMessages(String.valueOf(GolferId));
		
		if(CurrentDataSet != null){
			NewMessages = new ArrayList<PrivateMessage>();
			
			if(DataFromServlet.size() > CurrentDataSet.size()){
				int k = 0;
				for (int i = 0; i < CurrentDataSet.size(); i++){
					PrivateMessage pm1 = DataFromServlet.get(i);
					PrivateMessage pm2 = CurrentDataSet.get(i);
					if(!(pm1.getMessageId() == pm2.getMessageId())){
						
					}
					k = i;
				}
				k++;
				if(CurrentDataSet.size() == 0){
					k=0;
				}
				for (int i=k; i< DataFromServlet.size(); i++){
					NewMessages.add(DataFromServlet.get(i));
				}
			} else {
				int k = 0;
				for (int i = 0; i < DataFromServlet.size(); i++){
					PrivateMessage pm1 = DataFromServlet.get(i);
					PrivateMessage pm2 = CurrentDataSet.get(i);
					
					if(!(pm1.getMessageId() == pm2.getMessageId())){
						
					}
					k = i;
				}
				k++;
				for (int i=k; i< CurrentDataSet.size(); i++){
					NewMessages.add(CurrentDataSet.get(i));
				}
			}
			
			
			if(NewMessages.size() > 0){
				String ns = Context.NOTIFICATION_SERVICE;
				NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);
				int icon = drawable.statbar_icon;
				CharSequence tickerText = "Find A Golfer message...";
				long when = System.currentTimeMillis();
				Notification notification = new Notification(icon, tickerText, when);
				
				//now build the actual notification in the dropdown
				Context context = getApplicationContext();
				
				for(int i=0; i< NewMessages.size(); i++){
					PrivateMessage message = NewMessages.get(i);
					CharSequence contentTitle = message.getSendingGolferScreenName();
					CharSequence contentText = message.getMessage();
					Intent notificationIntent = new Intent(this, com.findagolfer.mobile.Main.class);
					PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
	
					notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
					
					if(notification.contentIntent != null){
						mNotificationManager.notify(GOLFERMESSAGENOTIFICATIONSID, notification);
						
						final int N = mCallbacks.beginBroadcast();
						  for (int j=0; j<N; j++) {
					          try {
					              mCallbacks.getBroadcastItem(j).getNewMessageList(NewMessages);
					          } catch (RemoteException e) {
					              // The RemoteCallbackList will take care of removing
					              // the dead object for us.
					          }
					      }
						  mCallbacks.finishBroadcast();
					}
				}
			}
			
		}
		
		CurrentDataSet = DataFromServlet;
	  }
	  catch (Exception e) {
	    StringWriter sw = new StringWriter();
	    PrintWriter pw = new PrintWriter(sw);
	    e.printStackTrace(pw);
	    Log.e(getClass().getSimpleName(), sw.getBuffer().toString(), e);
	  }

	}

    
}
