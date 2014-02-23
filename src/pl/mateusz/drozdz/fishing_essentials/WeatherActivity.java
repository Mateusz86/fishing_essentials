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
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class WeatherActivity extends Activity implements LocationListener {

	private LocationManager locationManager;
	private String latitude, longitude;
	private String provider;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weather);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria, false);
        Location location = locationManager.getLastKnownLocation(provider);

        if (location != null) {
          System.out.println("Provider " + provider + " has been selected.");
          onLocationChanged(location);
  	    locationManager.requestLocationUpdates(provider, 400, 1, this);

        int lat = (int) (location.getLatitude());
        int lng = (int) (location.getLongitude());
        latitude = String.valueOf(lat);
        longitude = String.valueOf(lat);


		String urls = Property.WEATHER_API_URL.replace("{0}", latitude)
				.replace("{1}", longitude);
		
		Weather weather = new Weather(this);
		weather.execute(urls);
        try {
			String s = weather.get();
			TextView weatherView = (TextView) findViewById(R.id.weather);
			weatherView.setText(s);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();

		}
        } else {
        	//zrobic dialoga
        	showDialog();
        }

        

	}

	@Override
	public void onLocationChanged(Location location) {
		System.out.println("location --------------------------------------------");
		System.out.println(location.toString());


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
	
	@Override
	protected void onResume() {
	    super.onResume();
	}

	@Override
	protected void onPause() {
	    super.onPause();
	    locationManager.removeUpdates(this);
	}
	
	private void showDialog() {
    	Toast.makeText(getApplicationContext(), "sprawdz polaczenie internetowe", Toast.LENGTH_SHORT).show();       

	}
}
