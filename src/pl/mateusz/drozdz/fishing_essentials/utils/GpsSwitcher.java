package pl.mateusz.drozdz.fishing_essentials.utils;

import pl.mateusz.drozdz.fishing_essentials.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class GpsSwitcher implements OnClickListener {

	private ImageButton button;
	private Activity activity;

	private GpsCallbackEvent e;
	private Boolean gps_enabled;

	public GpsSwitcher(Activity activity, ImageButton button,
			GpsCallbackEvent event) {
		this.button = button;
		this.activity = activity;

		this.e = event;
		gps_enabled = false;
		checkGpsStatus();

	}

	private void checkGpsStatus() {
		LocationManager locationManager = (LocationManager) activity
				.getSystemService(Context.LOCATION_SERVICE);
		if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
			button.setImageResource(R.drawable.gps_on);
			gps_enabled = true;
		} else {
			button.setImageResource(R.drawable.gps);
			gps_enabled = false;
		}
		//e.gpsCalbackEvent(null);
	}

	@Override
	public void onClick(View v) {
		Intent i = new Intent(
				android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
		activity.startActivity(i);
	}

}
