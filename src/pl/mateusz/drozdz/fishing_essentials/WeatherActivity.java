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

public class WeatherActivity extends Activity  {

	
	private String latitude, longitude;

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weather);

			Weather weather = new Weather(this,this,null);
			weather.execute();

			try {
				String s = weather.get() + "";

				weather.getWeather();

				TextView city = (TextView) findViewById(R.id.city);
				city.setText(weather.getCity()+"\n"+weather.getLatitude()+" "+weather.getLongitude());

				TextView temaperature = (TextView) findViewById(R.id.temperature);
				temaperature.setText(weather.getTemp().toString() + "^C");

				TextView presure = (TextView) findViewById(R.id.pressure);
				presure.setText(weather.getPressure().toString() + "hPa");

				TextView humidity = (TextView) findViewById(R.id.humidity);
				humidity.setText(weather.getHumidity().toString() + "%");

				TextView windSpeed = (TextView) findViewById(R.id.windSpeed);
				windSpeed.setText("Prêdkoœæ wiatru: "+weather.getWindSpeed().toString() + "");

				TextView windDeg = (TextView) findViewById(R.id.windDeg);
				windDeg.setText("Kierunek Wiatru: "+weather.getWindDeg().toString() + "");

				TextView clouds = (TextView) findViewById(R.id.clouds);
				clouds.setText("Zachmurzeneie: "+weather.getClouds().toString() + "");

				ImageView icon = (ImageView) findViewById(R.id.icon);
				icon.setImageResource(Property.WEATHER_ICONS.get(weather.getIcon()));
				/*
				 * TextView weatherView = (TextView) findViewById(R.id.weather);
				 * weatherView.setText(s+"");
				 */

			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();

			} catch (NullPointerException e) {

			}


	}


	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
		//locationManager.removeUpdates(this);
	}
//
//	private void showDialog() {
//		Toast.makeText(getApplicationContext(),
//				"sprawdz polaczenie internetowe", Toast.LENGTH_SHORT).show();
//
//	}
}
