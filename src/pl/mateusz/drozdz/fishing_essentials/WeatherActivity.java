package pl.mateusz.drozdz.fishing_essentials;

import pl.mateusz.drozdz.fishing_essantials.interfaces.WeatherInterface;
import pl.mateusz.drozdz.fishing_essentials.core.WeatherAsyncTask;
import pl.mateusz.drozdz.fishing_essentials.utils.MyLinearLayout;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ProgressBar;

public class WeatherActivity extends Activity implements WeatherInterface {

	
	private String latitude, longitude;

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weather);

			WeatherAsyncTask weather = new WeatherAsyncTask(this,null);
			weather.execute();

//			try {
//				String s = weather.get() + "";
//
//				weather.getWeather();
//
//				TextView city = (TextView) findViewById(R.id.city);
//				city.setText(weather.getCity()+"\n"+weather.getLatitude()+" "+weather.getLongitude());
//
//				TextView temaperature = (TextView) findViewById(R.id.temperature);
//				temaperature.setText(weather.getTemp().toString() + "^C");
//
//				TextView presure = (TextView) findViewById(R.id.pressure);
//				presure.setText(weather.getPressure().toString() + "hPa");
//
//				TextView humidity = (TextView) findViewById(R.id.humidity);
//				humidity.setText(weather.getHumidity().toString() + "%");
//
//				TextView windSpeed = (TextView) findViewById(R.id.windSpeed);
//				windSpeed.setText("Prêdkoœæ wiatru: "+weather.getWindSpeed().toString() + "");
//
//				TextView windDeg = (TextView) findViewById(R.id.windDeg);
//				windDeg.setText("Kierunek Wiatru: "+weather.getWindDeg().toString() + "");
//
//				TextView clouds = (TextView) findViewById(R.id.clouds);
//				clouds.setText("Zachmurzeneie: "+weather.getClouds().toString() + "");
//
//				ImageView icon = (ImageView) findViewById(R.id.icon);
//				icon.setImageResource(Property.WEATHER_ICONS.get(weather.getIcon()));
//				/*
//				 * TextView weatherView = (TextView) findViewById(R.id.weather);
//				 * weatherView.setText(s+"");
//				 */
//
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			} catch (ExecutionException e) {
//				e.printStackTrace();
//
//			} catch (NullPointerException e) {
//
//			}


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




	@Override
	public MyLinearLayout getWeaterContener() {
		return null; // (EditText) findViewById(R.id.weather_wrapper);
	}




	@Override
	public Context getContext() {
		return this;
	}




	@Override
	public Activity getActivity() {
		// TODO Auto-generated method stub
		return this;
	}




	@Override
	public int getWeatherType() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public ProgressBar getProgressBar() {
		// TODO Auto-generated method stub
		return (ProgressBar)findViewById(R.id.progressBar);
	}
	
	
}
