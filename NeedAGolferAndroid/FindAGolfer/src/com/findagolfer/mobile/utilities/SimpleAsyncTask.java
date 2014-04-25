package com.findagolfer.mobile.utilities;

import android.content.Context;
import android.os.AsyncTask;

public class SimpleAsyncTask extends AsyncTask<BackgroundTaskDelegate, Void, Object> {
	private final Context _context;
	private ServiceResponseListener<?> _callbackListener;
	public String _dialogMessage;
	
	public SimpleAsyncTask(Context c, ServiceResponseListener<?> callbackListener){
		_context = c;
		_callbackListener = callbackListener;
	}

	
	@Override
	protected void onPostExecute(Object result) {
		// execution of result of Long time consuming operation
		_callbackListener.onServiceResponse(result);
	}


	@Override
	protected void onPreExecute() {
	}


	@Override
	protected void onProgressUpdate(Void... values) {
      // Things to be done while execution of long running operation is in progress. For example updating ProgessDialog
	 }


	@Override
	protected Object doInBackground(BackgroundTaskDelegate... params) {
		return params[0].setBackgroundTask();
	}
}
