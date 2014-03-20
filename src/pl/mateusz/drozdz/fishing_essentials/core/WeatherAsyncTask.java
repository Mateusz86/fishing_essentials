package pl.mateusz.drozdz.fishing_essentials.core;

import java.util.concurrent.ExecutionException;

import org.apache.http.client.HttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.utils.MyLinearLayout;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.AsyncTask;
import android.view.TextureView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class WeatherAsyncTask extends AsyncTask<String, Void, String> {
	private Context context;
	private HttpClient httpClient;
	private Activity activity;
	private JSONObject result;
	private RestConnector connector;

	

	private String latitude, longitude;
	private String urls;
	private Location location;
	private WeatherInterface fragment;
	private Weather weather;

	public WeatherAsyncTask(WeatherInterface fragment, Location location) {
		super();
		this.activity = fragment.getActivity();

		this.context = fragment.getContext();
		if (location == null)
			this.location = new LocationHelper(activity).getLocation();
		else
			this.location = location;
		latitude = String.valueOf(this.location.getLatitude());
		longitude = String.valueOf(this.location.getLongitude());
		urls = Property.WEATHER_API_URL.replace("{0}", latitude).replace("{1}",
				longitude);

		this.fragment = fragment;
		
		weather = new Weather();
	}

	public void getWeatherData() {

	
		connector = new RestConnector();
		connector.execute(urls);
		try {
			result = connector.get();
			if (result != null) {
				weather.setCity(result.getString("name"));
				weather.setTemp((float) result.getJSONObject("main").getDouble("temp"));
				weather.setTempMax((float) result.getJSONObject("main").getDouble(
						"temp_max"));
				weather.setTempMin((float) result.getJSONObject("main").getDouble(
						"temp_min"));
				weather.setPressure(result.getJSONObject("main").getInt("pressure"));
				weather.setHumidity(result.getJSONObject("main").getInt("humidity"));

				weather.setWindSpeed((float) result.getJSONObject("wind").getDouble(
						"speed"));
				weather.setWindDeg((float) result.getJSONObject("wind")
						.getDouble("deg"));

				weather.setClouds(result.getJSONObject("clouds").getInt("all"));

				weather.setIcon(result.getJSONArray("weather").getJSONObject(0)
						.getString("icon"));
				System.out.println(result.getJSONArray("weather")
						.getJSONObject(0).getString("icon"));

				weather.setDescription(result.getJSONArray("weather").getJSONObject(0)
						.getString("description"));
			}

		} catch (JSONException e) {
			e.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


	public void setWeather(Weather weather) {
		this.weather = weather;
	}
	

	public Weather getWeather() {
		return weather;
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
        fragment.getProgressBar().setVisibility(View.VISIBLE);
	}

	@Override
	protected void onPostExecute(String result) {
		if (result == null && context != null) {
			Toast.makeText(context, "sprawdz polaczenie internetowe",
					Toast.LENGTH_SHORT).show();
			
		} else {
			super.onPostExecute(result);
			getWeatherData();
			MyLinearLayout l = fragment.getWeaterContener();			
			weather.generateWeatherOutput(l);
		}
		 fragment.getProgressBar().setVisibility(View.GONE);
	}

	@Override
	protected String doInBackground(String... params) {
		Rest r = new Rest();
		// System.out.println(params[0]);
		r.get(urls);
		r.getResponseString();
		String textRetrieved = r.getResponseText();
		return textRetrieved;
	}
	
	
	

}
