package pl.mateusz.drozdz.fishing_essentials.core;

import pl.mateusz.drozdz.fishing_essentials.dao.utils.MyLinearLayout;

import android.app.Activity;
import android.content.Context;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

public interface WeatherInterface {
	 public ProgressBar getProgressBar();
     public MyLinearLayout getWeaterContener();
     public Context getContext();
     public Activity getActivity();
     public int getWeatherType();
}
