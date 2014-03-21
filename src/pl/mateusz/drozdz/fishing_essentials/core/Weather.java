package pl.mateusz.drozdz.fishing_essentials.core;

import java.io.Serializable;

import pl.mateusz.drozdz.fishing_essentials.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Weather implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String city;
	private String sunrise; // wschód s³oñca
	private String sunset; // zachód s³oñca
	private Float temp;
	private Float tempMin;
	private Float tempMax;
	private Integer pressure; // ciœnienie
	private Integer humidity; // wilgotnosc
	private Float windSpeed;
	private Float windDeg;
	private Integer clouds;

	private String icon;
	private String description;
	
	
	

	public Weather() {
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSunrise() {
		return sunrise;
	}

	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}

	public String getSunset() {
		return sunset;
	}

	public void setSunset(String sunset) {
		this.sunset = sunset;
	}

	public Float getTemp() {
		return temp;
	}

	public String getTempD() {
		return String.valueOf(temp) + "°C";
	}

	public void setTemp(Float temp) {
		this.temp = temp - (float) 273.15;
	}

	public Float getTempMin() {
		return tempMin;
	}

	public String getTempMinD() {
		return String.valueOf(tempMin) + "°C";
	}

	public void setTempMin(Float tempMin) {
		this.tempMin = tempMin - (float) 273.15;
	}

	public Float getTempMax() {
		return tempMax;
	}

	public String getTempMaxD() {
		return String.valueOf(tempMax) + "°C";
	}

	public void setTempMax(Float tempMax) {
		this.tempMax = tempMax - (float) 273.15;
	}

	public Integer getPressure() {
		return pressure;
	}

	public String getPressureD() {
		return String.valueOf(pressure) + "hPa";
	}

	public void setPressure(Integer pressure) {
		this.pressure = pressure;
	}

	public Integer getHumidity() {
		return humidity;
	}

	public String getHumidityD() {
		return String.valueOf(humidity) + "%";
	}

	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}

	public Float getWindSpeed() {
		return windSpeed;
	}

	public String getWindSpeedD() {
		return String.valueOf(windSpeed) + " m/s";
	}

	public void setWindSpeed(Float windSpeed) {
		this.windSpeed = windSpeed;
	}

	public Float getWindDeg() {
		return windDeg;
	}

	public String getWindDegD() {
		String wiatr = "N";
		String[] des = { "N", "NE", "E", "SE", "S", "SW", "W", "NW" };
		if (windDeg < 22.5) {
			wiatr = des[0];
		} else if (22.5 < windDeg && windDeg < 67.5) {
			wiatr = des[1];
		} else if (67.5 < windDeg && windDeg < 112.5) {
			wiatr = des[2];
		} else if (112.5 < windDeg && windDeg < 157.5) {
			wiatr = des[3];
		} else if (157.5 < windDeg && windDeg < 202.5) {
			wiatr = des[4];
		} else if (202.5 < windDeg && windDeg < 247.5) {
			wiatr = des[5];
		} else if (247.5 < windDeg && windDeg < 292.5) {
			wiatr = des[6];
		} else if (292.5 < windDeg && windDeg < 337.5) {
			wiatr = des[7];
		} else if (237.5 < windDeg) {
			wiatr = des[1];
		}
		return wiatr;
	}

	public void setWindDeg(Float windDeg) {
		this.windDeg = windDeg;
	}

	public Integer getClouds() {
		return clouds;
	}

	public String getCloudsD() {
		return String.valueOf(clouds) + "%";
	}

	public void setClouds(Integer clouds) {
		this.clouds = clouds;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@SuppressLint("NewApi")
	public void generateWeatherOutput(LinearLayout l) {

	
		l.removeAllViews();

		Context context = Property.getContext();
		LinearLayout l1 = new LinearLayout(context);
		l1.setOrientation(LinearLayout.HORIZONTAL);

		ImageView icon = new ImageView(context);
		icon.setImageResource(Property.WEATHER_ICONS.get(getIcon()));

		l1.addView(icon);
		l.addView(l1);

		TextView t1, t2;

		t1 = new TextView(context);
		t1.setText("Temperatura: ");
		t1.setTextAppearance(context, R.style.labelText);

		t2 = new TextView(context);
		t2.setText(getTempD());
		t2.setTextAppearance(context, R.style.normalText);

		l1 = new LinearLayout(context);
		l1.addView(t1);
		l1.addView(t2);
		l.addView(l1);

		t1 = new TextView(context);
		t1.setText("Ciœnieie: ");
		t1.setTextAppearance(context, R.style.labelText);

		t2 = new TextView(context);
		t2.setText(getPressureD());
		t2.setTextAppearance(context, R.style.normalText);

		l1 = new LinearLayout(context);
		l1.addView(t1);
		l1.addView(t2);
		l.addView(l1);

		t1 = new TextView(context);
		t1.setText("Wiatr: ");
		t1.setTextAppearance(context, R.style.labelText);

		t2 = new TextView(context);
		t2.setText(getWindDegD());
		t2.setTextAppearance(context, R.style.normalText);

		l1 = new LinearLayout(context);
		l1.addView(t1);
		l1.addView(t2);
		l.addView(l1);

		t1 = new TextView(context);
		t1.setText("Wilgotnoœæ: ");
		t1.setTextAppearance(context, R.style.labelText);

		t2 = new TextView(context);
		t2.setText(getHumidityD());
		t2.setTextAppearance(context, R.style.normalText);

		l1 = new LinearLayout(context);
		l1.addView(t1);
		l1.addView(t2);
		l.addView(l1);

		t1 = new TextView(context);
		t1.setText("Opis: ");
		t1.setTextAppearance(context, R.style.labelText);

		t2 = new TextView(context);
		t2.setText(getDescription());
		t2.setTextAppearance(context, R.style.normalText);

		l1 = new LinearLayout(context);
		l1.addView(t1);
		l1.addView(t2);
		l.addView(l1);
	}

}
