package pl.mateusz.drozdz.fishing_essentials.core;

import java.util.concurrent.ExecutionException;

import org.apache.http.client.HttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Weather extends AsyncTask<String, Void, String> {
	private Context context;
	private HttpClient httpClient;
	private Activity activity;
	private JSONObject result;
	private RestConnector connector;

	private String city;
	private String sunrise; // wschód s³oñca
	private String sunset; // zachód s³oñca
	private Float temp;
	private Float tempMin;
	private Float tempMax;
	private Integer pressure; // ciœnienie
	private Integer humidity; // wilgotnosc
	private Float windSpeed;
	private Float windDeg;
	private Integer clouds;

	private String icon;
	private String description;

	private String latitude, longitude;
	private String urls;
	private Location location;
	private WeatherInterface fragment;

	public Weather(WeatherInterface fragment, Location location) {
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
	}

	public void getWeather() {

		// String url = Property.WEATHER_API_URL.replace("{0}",
		// latitude).replace(
		// "{1}", longitude);

		connector = new RestConnector();
		connector.execute(urls);
		try {
			result = connector.get();
			if (result != null) {
				setCity(result.getString("name"));
				setTemp((float) result.getJSONObject("main").getDouble("temp"));
				setTempMax((float) result.getJSONObject("main").getDouble(
						"temp_max"));
				setTempMin((float) result.getJSONObject("main").getDouble(
						"temp_min"));
				setPressure(result.getJSONObject("main").getInt("pressure"));
				setHumidity(result.getJSONObject("main").getInt("humidity"));

				setWindSpeed((float) result.getJSONObject("wind").getDouble(
						"speed"));
				setWindDeg((float) result.getJSONObject("wind")
						.getDouble("deg"));

				setClouds(result.getJSONObject("clouds").getInt("all"));

				setIcon(result.getJSONArray("weather").getJSONObject(0)
						.getString("icon"));
				System.out.println(result.getJSONArray("weather")
						.getJSONObject(0).getString("icon"));

				setDescription(result.getJSONArray("weather").getJSONObject(0)
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

	public String getCity() {
		return city;
	}

	private void setCity(String city) {
		this.city = city;
	}

	public String getSunrise() {
		return sunrise;
	}

	private void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}

	public String getSunset() {
		return sunset;
	}

	private void setSunset(String sunset) {
		this.sunset = sunset;
	}

	public Float getTemp() {
		return temp;
	}

	public String getTempD() {
		return String.valueOf(temp) + "°C";
	}

	private void setTemp(Float temp) {
		this.temp = temp - (float) 273.15;
	}

	public Float getTempMin() {
		return tempMin;
	}

	public String getTempMinD() {
		return String.valueOf(tempMin) + "°C";
	}

	private void setTempMin(Float tempMin) {
		this.tempMin = tempMin - (float) 273.15;
	}

	public Float getTempMax() {
		return tempMax;
	}

	public String getTempMaxD() {
		return String.valueOf(tempMax) + "°C";
	}

	private void setTempMax(Float tempMax) {
		this.tempMax = tempMax - (float) 273.15;
	}

	public Integer getPressure() {
		return pressure;
	}

	public String getPressureD() {
		return String.valueOf(pressure) + "hPa";
	}

	private void setPressure(Integer pressure) {
		this.pressure = pressure;
	}

	public Integer getHumidity() {
		return humidity;
	}

	public String getHumidityD() {
		return String.valueOf(humidity) + "%";
	}

	private void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}

	public Float getWindSpeed() {
		return windSpeed;
	}

	public String getWindSpeedD() {
		return String.valueOf(windSpeed) + " m/s";
	}

	private void setWindSpeed(Float windSpeed) {
		this.windSpeed = windSpeed;
	}

	public Float getWindDeg() {
		return windDeg;
	}

	public String getWindDegD() {
		String wiatr = "N";
		String[] des = { "N", "NE", "E", "SE", "S", "SW", "W", "NW" };
		if (windDeg < 22.5) {
			wiatr = des[0];
		} else if (22.5 < windDeg && windDeg < 67.5) {
			wiatr = des[1];
		} else if (67.5 < windDeg && windDeg < 112.5) {
			wiatr = des[2];
		} else if (112.5 < windDeg && windDeg < 157.5) {
			wiatr = des[3];
		} else if (157.5 < windDeg && windDeg < 202.5) {
			wiatr = des[4];
		} else if (202.5 < windDeg && windDeg < 247.5) {
			wiatr = des[5];
		} else if (247.5 < windDeg && windDeg < 292.5) {
			wiatr = des[6];
		} else if (292.5 < windDeg && windDeg < 337.5) {
			wiatr = des[7];
		} else if (237.5 < windDeg) {
			wiatr = des[1];
		}
		return wiatr;
	}

	private void setWindDeg(Float windDeg) {
		this.windDeg = windDeg;
	}

	public Integer getClouds() {
		return clouds;
	}

	public String getCloudsD() {
		return String.valueOf(clouds) + "%";
	}

	private void setClouds(Integer clouds) {
		this.clouds = clouds;
	}

	public String getIcon() {
		return icon;
	}

	private void setIcon(String icon) {
		this.icon = icon;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
			getWeather();
			EditText w = fragment.getWeaterContener();
			String pogoda = (new StringBuilder("Temperatura: " + getTempD()
					+ "\nCiœnieie: " + getPressureD() + "\nWiatr: "
					+ getWindDegD() + " " + getWindSpeedD() + "\nWilgotnoœæ: "
					+ getHumidityD() + "\n" + getDescription())).toString();
			w.setText(pogoda);
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
