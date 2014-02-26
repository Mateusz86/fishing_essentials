package pl.mateusz.drozdz.fishing_essentials;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import pl.mateusz.drozdz.fishing_essentials.core.Property;
import pl.mateusz.drozdz.fishing_essentials.core.Weather;
import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
			String s = weather.get()+"";
			
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
			windSpeed.setText(weather.getWindSpeed().toString()+"");
			
			TextView windDeg = (TextView) findViewById(R.id.windDeg);
			windDeg.setText(weather.getWindDeg().toString()+"");
			
			TextView clouds = (TextView) findViewById(R.id.clouds);
			clouds.setText(weather.getClouds().toString()+"");
			
			ImageView icon = (ImageView) findViewById(R.id.icon);
			icon.setImageResource(icons.get(weather.getIcon()));
/*			TextView weatherView = (TextView) findViewById(R.id.weather);
			weatherView.setText(s+"");*/
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();

		}
        catch (NullPointerException e) {
			
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
