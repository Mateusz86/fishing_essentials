package pl.mateusz.drozdz.fishing_essentials.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class Weather extends AsyncTask<String, Void, String>  {
	private Context context;
	private HttpClient httpClient;

	public Weather(Context context) {
		super();
		this.context = context;
	}
	
	public void getWeather(String latitude, String longitude){
		String url =Property.WEATHER_API_URL.replace("{0}", latitude).replace("{1}", longitude);
		
	}

	@Override
	protected void onPostExecute(String result) {
		if(result==null) {
	    	Toast.makeText(context, "sprawdz polaczenie internetowe", Toast.LENGTH_SHORT).show();       
		}
		super.onPostExecute(result);
	}

	@Override
	protected String doInBackground(String... params) {
		Rest r = new Rest();
		System.out.println(params[0]);
		r.get(params[0]);
		r.getResponseString();
		String textRetrieved = r.getResponseText();
		return textRetrieved;
	}

	
}
