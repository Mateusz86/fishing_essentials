package pl.mateusz.drozdz.fishing_essentials.core;

public interface WeatherInterface {
	 public ProgressBar getProgressBar();
     public EditText getWeaterContener();
     public Context getContext();
     public Activity getActivity();
     public int getWeatherType();
}
