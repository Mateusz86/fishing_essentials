package pl.mateusz.drozdz.fishing_essentials.core;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import android.content.Context;
import android.location.Location;
import pl.mateusz.drozdz.fishing_essentials.R;

public class Property {
	public static final String DB_NAME = "ryby-db";
	public static final String WEATHER_API_URL ="http://api.openweathermap.org/data/2.5/weather?lang=pl&cnt=1&lat={0}&lon={1}";
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat ("dd-MM-yyyy HH:mm:ss");
    public static final String FISH_PHOTO_DIR = "fishes/";
    public static final String METHODS_PHOTO_DIR = "methods/";
    public static final String CAUGHT_FISH_PHOTO_DIR = "myCaughtFishes/";
	public static final HashMap<String, Integer> WEATHER_ICONS = new HashMap<String, Integer>() {
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
	private static Context context;
	
	public static Location location;

	public static Location getLocation() {
		return location;
	}
	public static void setLocation(Location location) {
		Property.location = location;
	}
	
//	public static void setLocation(String latitude, String longitude){
//		location.setLatitude(Double.valueOf(latitude));
//		location.setLongitude(Double.valueOf(longitude));
//	}
//	
//	public static Double getLatitude(){
//		return location.getLatitude();
//	}
//	public static Double getLongitude(){
//		return location.getLongitude();
//	}
//	
//	
	
	public static Context getContext() {
		return context;
	}
	public static void setContext(Context context) {
		Property.context = context;
	}
	
	
}
