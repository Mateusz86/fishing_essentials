package pl.mateusz.drozdz.fishing_essentials.core;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

public class LocationHelper implements LocationListener{
	
	private LocationManager locationManager;
	private Activity activity ;
	private String provider;
	private Location location;
	
	public LocationHelper(Activity activity){
		this.activity=activity;
		
	}
	
	public Location getLocation(){
		
		locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);

		Criteria criteria = new Criteria();
		provider = locationManager.getBestProvider(criteria, false);
		location = locationManager.getLastKnownLocation(provider);
		
		
		// TODO  - cos tu jest hujowo wiec ustawiam dla debuug domyœlnie
		location = new Location("dummyprovider");
		location.setLatitude(50.054315);
		location.setLongitude(20.001876);
		
		if (location != null) {
			System.out.println("Provider " + provider + " has been selected.");
			onLocationChanged(location);
			locationManager.requestLocationUpdates(provider, 400, 1, this);

			return location;        
		}else{
			return null;
		}
	}

	@Override
	public void onLocationChanged(android.location.Location location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

}
