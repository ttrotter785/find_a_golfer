package com.findagolfer.mobile.parsers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.findagolfer.mobile.utilities.RequestMethod;


import android.util.Config;

public abstract class JSONParser {
	private ArrayList <NameValuePair> headers;
    private int responseCode;
    private String message;
    private String response;
    
	public void getContentsOfUrl(String url, String auth){
		//go out and get data from url here post/get 
		//then call parseContents(with data returned from svc/url)
		try {
			
			if(Config.DEBUG){
				System.out.println(auth);
				System.out.println(url);
			}
			Execute(RequestMethod.GET, url, auth, null);
			parseContents(response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getContentsOfUrlWithPost(String url, String auth, String data){
		try {
			if(Config.DEBUG){
				System.out.println(auth);
				System.out.println(url);
				System.out.println(data);
			}
			Execute(RequestMethod.POST, url, auth, data);
			parseContents(response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void parseContents(String data){
		//must override this
		//throw new Exception
		if(Config.DEBUG){
			System.out.println(data);
		}
	}
	
	private void Execute(RequestMethod method, String url, String auth, String data) throws Exception
    {
		headers = new ArrayList<NameValuePair>();
		
		if(auth != null){
			headers.add(new BasicNameValuePair("Authorization", "Basic " + auth));
		}	
		
		switch(method) {
            case GET:
            {
                HttpGet request = new HttpGet(url);
 
                //add headers
                for(NameValuePair h : headers)
                {
                    request.addHeader(h.getName(), h.getValue());
                }
 
                executeRequest(request, url);
                break;
            }
            case POST:
            {
                HttpPost request = new HttpPost(url);
                //add headers
                for(NameValuePair h : headers)
                {
                    request.addHeader(h.getName(), h.getValue());
                }
                request.addHeader("Content-Type", "application/json");
                request.setEntity(new StringEntity(data));
                executeRequest(request, url);
                break;
            }
        }
    }
	
	private void executeRequest(HttpUriRequest request, String url)
    {
        HttpClient client = new DefaultHttpClient();
 
        HttpResponse httpResponse;
 
        try {
            httpResponse = client.execute(request);
            setResponseCode(httpResponse.getStatusLine().getStatusCode());
            setMessage(httpResponse.getStatusLine().getReasonPhrase());
 
            HttpEntity entity = httpResponse.getEntity();
 
            if (entity != null) {

                InputStream instream = entity.getContent();
                response = convertStreamToString(instream);
 
                // Closing the input stream will trigger connection release
                instream.close();
            }
 
        } catch (ClientProtocolException e)  {
            client.getConnectionManager().shutdown();
            e.printStackTrace();
        } catch (IOException e) {
            client.getConnectionManager().shutdown();
            e.printStackTrace();
        }
    }
 
    private static String convertStreamToString(InputStream is) {
 
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
 
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public int getResponseCode() {
		return responseCode;
	}
}
