package pl.mateusz.drozdz.fishing_essentials.core;

import java.text.SimpleDateFormat;

public class Property {
	public static final String DB_NAME = "ryby-db";
	public static final String WEATHER_API_URL ="http://api.openweathermap.org/data/2.5/weather?lang=pl&cnt=1&lat={0}&lon={1}";
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat ("dd-MM-yyyy HH:mm:ss");
    public static final String FISH_PHOTO_DIR = "fishes/";
    public static final String CAUGHT_FISH_PHOTO_DIR = "myCaughtFishes/";
}
