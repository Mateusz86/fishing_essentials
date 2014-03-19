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
		

	    // Get the location manager
	    locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
	    // Define the criteria how to select the locatioin provider -> use
	    // default
	    Criteria criteria = new Criteria();
	    provider = locationManager.getBestProvider(criteria, false);
	    location = locationManager.getLastKnownLocation(provider);

	    // Initialize the location fields
	    if (location != null) {
	      System.out.println("Provider " + provider + " has been selected.");
	      onLocationChanged(location);
	    } else {
	      System.out.println("Location not available");
	    }
		
	}
	
	public Location getLocation1(){
		
		locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);

		
		if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
			provider = LocationManager.GPS_PROVIDER;
		} else {
			Criteria criteria = new Criteria();
		    provider = locationManager.getBestProvider(criteria, false);
		}
		
		
		location = locationManager.getLastKnownLocation(provider);
		
		
		// TODO  - cos tu jest hujowo wiec ustawiam dla debuug domyœlnie
//		location = new Location("dummyprovider");
//		location.setLatitude(50.054315);
//		location.setLongitude(20.001876);
		
		if (location != null) {
			System.out.println("Provider " + provider + " has been selected.");
			onLocationChanged(location);
			locationManager.requestLocationUpdates(provider, 400, 1, this);

			return location;        
		}else{
			return null;
		}
	}
	
	public Location getLocation(){
		locationManager.requestLocationUpdates(provider, 400, 1, this);
		System.out.println(location.toString());
		return location;
	}
	

	@Override
	public void onLocationChanged(android.location.Location location) {
		this.location= location;
		System.out.println("change location");
		System.out.println(location.toString());
	}

	@Override
	public void onProviderDisabled(String provider) {
		System.out.println("Disabled "+provider);
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		System.out.println("Enable "+provider);
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		System.out.println("Status change "+provider);
	}

}
