package pl.mateusz.drozdz.fishing_essentials.core;
import java.util.concurrent.ExecutionException;

import org.apache.http.client.HttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;




public class Weather extends AsyncTask<String, Void, String>  {
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

	public Weather(Context context) {
		super();
		this.context = context;
	}

	public void getWeather(String latitude, String longitude) {
		String url = Property.WEATHER_API_URL.replace("{0}", latitude).replace(
				"{1}", longitude);
		connector = new RestConnector();
		connector.execute(url);
		try {
			result = connector.get();
			if(result!=null) {
			setCity(result.getString("name"));
			setTemp((float) result.getJSONObject("main").getDouble("temp"));
			setTempMax((float) result.getJSONObject("main").getDouble(
					"temp_max"));
			setTempMin((float) result.getJSONObject("main").getDouble(
					"temp_min"));
			setPressure(result.getJSONObject("main").getInt("pressure"));
			setHumidity(result.getJSONObject("main").getInt("humidity"));

			setWindSpeed((float) result.getJSONObject("wind")
					.getDouble("speed"));
			setWindDeg((float) result.getJSONObject("wind").getDouble("deg"));

			setClouds(result.getJSONObject("clouds").getInt("all"));
			

            setIcon(result.getJSONArray("weather").getJSONObject(0).getString("icon"));
			System.out.println(result.getJSONArray("weather").getJSONObject(0).getString("icon"));
			
			setDescription(result.getJSONArray("weather").getJSONObject(0).getString("description"));
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

	private void setTemp(Float temp) {
		this.temp = temp - (float) 273.15;
	}

	public Float getTempMin() {
		return tempMin;
	}

	private void setTempMin(Float tempMin) {
		this.tempMin = tempMin - (float) 273.15;
	}

	public Float getTempMax() {
		return tempMax;
	}

	private void setTempMax(Float tempMax) {
		this.tempMax = tempMax - (float) 273.15;
	}

	public Integer getPressure() {
		return pressure;
	}

	private void setPressure(Integer pressure) {
		this.pressure = pressure;
	}

	public Integer getHumidity() {
		return humidity;
	}

	private void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}

	public Float getWindSpeed() {
		return windSpeed;
	}

	private void setWindSpeed(Float windSpeed) {
		this.windSpeed = windSpeed;
	}

	public Float getWindDeg() {
		return windDeg;
	}

	private void setWindDeg(Float windDeg) {
		this.windDeg = windDeg;
	}

	public Integer getClouds() {
		return clouds;
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

	@Override
	protected void onPostExecute(String result) {
		if(result==null&&context!=null) {
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
