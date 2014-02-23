package pl.mateusz.drozdz.fishing_essentials;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutionException;

import pl.mateusz.drozdz.fishing_essentials.core.Property;
import pl.mateusz.drozdz.fishing_essentials.core.Rest;
import pl.mateusz.drozdz.fishing_essentials.core.Weather;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class WeatherActivity extends Activity implements LocationListener {

	private LocationManager locationManager;
	private String latitude, longitude;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weather);

		// tymczasowe rozwi¹zanie
		latitude = "50.0619720";
		longitude = "19.9379100";

		// Weather weather = new Weather(this);
		// weather.getWeather(latitude, longitude);

		String urls = Property.WEATHER_API_URL.replace("{0}", latitude)
				.replace("{1}", longitude);
		
		Weather weather = new Weather(this);
		weather.execute(urls);
        try {
			String s = weather.get();
			TextView weatherView = (TextView) findViewById(R.id.weather);
			weatherView.setText(s);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
		// locationManager = (LocationManager) this
		// .getSystemService(Context.LOCATION_SERVICE);
		// locationManager.requestLocationUpdates(
		// LocationManager.NETWORK_PROVIDER, 0, 0, this);

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
