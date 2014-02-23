package pl.mateusz.drozdz.fishing_essentials;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import pl.mateusz.drozdz.fishing_essentials.core.Property;
import pl.mateusz.drozdz.fishing_essentials.core.Rest;
import pl.mateusz.drozdz.fishing_essentials.core.Weather;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class WeatherActivity extends Activity implements LocationListener {

	private LocationManager locationManager;
	private String latitude, longitude;
	
	private static final HashMap<String, Integer> icons = new HashMap<String, Integer>(){
		{
			put("01d", R.drawable.p01d);
			put("01n", R.drawable.p01n);
			put("02n", R.drawable.p02n);
			put("02d", R.drawable.p02d);
			put("03n", R.drawable.p03n);
			put("03d", R.drawable.p03d);
			put("04n", R.drawable.p04n);
			put("04d", R.drawable.p04d);
			put("09n", R.drawable.p09n);
			put("09d", R.drawable.p09d);
			put("10n", R.drawable.p10n);
			put("10n", R.drawable.p10n);
			put("11n", R.drawable.p11n);
			put("11n", R.drawable.p11n);
			put("13n", R.drawable.p13n);
			put("13n", R.drawable.p13n);
			put("50n", R.drawable.p50n);
			put("50n", R.drawable.p50n);
		}
	};
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weather);

		// tymczasowe rozwi¹zanie
		latitude = "50.0619720";
		longitude = "19.9379100";

		Weather weather = new Weather(this);
		weather.getWeather(latitude, longitude);
		
		
		TextView city = (TextView) findViewById(R.id.city);
		city.setText(weather.getCity());
		
		TextView temaperature = (TextView) findViewById(R.id.temperature);
		temaperature.setText(weather.getTemp().toString() + "^C");
		
		TextView presure = (TextView) findViewById(R.id.pressure);
		presure.setText(weather.getPressure().toString()+"hPa");
		
		TextView humidity = (TextView) findViewById(R.id.humidity);
		humidity.setText(weather.getHumidity().toString()+"%");
		
		TextView windSpeed = (TextView) findViewById(R.id.windSpeed);
		windSpeed.setText(weather.getWindSpeed().toString());
		
		TextView windDeg = (TextView) findViewById(R.id.windDeg);
		windDeg.setText(weather.getWindDeg().toString());
		
		TextView clouds = (TextView) findViewById(R.id.clouds);
		clouds.setText(weather.getClouds().toString());
		
		ImageView icon = (ImageView) findViewById(R.id.icon);
		icon.setImageResource(icons.get(weather.getIcon()));


	}

	@Override
	public void onLocationChanged(Location location) {
		System.out.println("location");
		System.out.println(location.toString());
		// kurwa nie dzia³a !!! huj w dupe !!!!!!!!!
		// biore na sztywno wspólrzêdne dla krakowa

	}

	@Override
	public void onProviderDisabled(String provider) {
		System.out.println("provider disabled");

	}

	@Override
	public void onProviderEnabled(String provider) {
		System.out.println("provider enabled");

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		System.out.println("status change");

	}
}
