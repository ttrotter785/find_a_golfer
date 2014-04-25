package com.findagolfer.mobile.utilities;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

@SuppressWarnings("unchecked")
public class ProgressBarAsyncTask extends AsyncTask<BackgroundTaskDelegate, Void, Object> {
	private ProgressDialog _dialog;
	private final Context _context;
	private ServiceResponseListener<?> _callbackListener;
	public String _dialogMessage;
	
	public ProgressBarAsyncTask(Context c, ServiceResponseListener<?> callbackListener){
		_context = c;
		_callbackListener = callbackListener;
	}

	
	@Override
	protected void onPostExecute(Object result) {
		// execution of result of Long time consuming operation
		_dialog.dismiss();
		_callbackListener.onServiceResponse(result);
	}


	@Override
	protected void onPreExecute() {
		_dialog=new ProgressDialog(_context);
		_dialog.setMessage(_dialogMessage);
		_dialog.show();
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

