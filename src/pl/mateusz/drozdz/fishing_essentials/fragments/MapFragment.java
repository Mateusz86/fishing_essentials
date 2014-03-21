package pl.mateusz.drozdz.fishing_essentials.fragments;

import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.core.LocationHelper;
import pl.mateusz.drozdz.fishing_essentials.core.Property;
import pl.mateusz.drozdz.fishing_essentials.dao.FishingDao.Properties;
import pl.mateusz.drozdz.fishing_essentials.utils.GpsCallbackEvent;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerDragListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends SupportMapFragment implements OnMarkerDragListener,OnClickListener {
	
	private View v;
	private GoogleMap googleMap;
	private Marker m;
	private double latitude = 0;
	private double longitude = 0;
	private LatLng myPosition;
	private Location location;
	private GpsCallbackEvent callback;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		boolean services = false;

		v = inflater.inflate(R.layout.fragment_map, container, false);

		try {
			getActivity().getPackageManager().getApplicationInfo(
					"com.google.android.gms", 0);
			services = true;
		} catch (PackageManager.NameNotFoundException e) {
			services = false;
		}

		if (services&& v!=null) {
			v = super.onCreateView(inflater, container, savedInstanceState);
			
			this.location = Property.getLocation();

			this.latitude = location.getLatitude();
			this.longitude = location.getLongitude();
			this.myPosition = new LatLng(latitude, longitude);
			
			Button b = new Button(getActivity());
			b.setLayoutParams(new LayoutParams(
		            LayoutParams.FILL_PARENT,
		            LayoutParams.WRAP_CONTENT));
			b.setText("Zapisz");
			b.setTextColor(getResources().getColor(R.color.black));
			b.setTextAppearance(getActivity(), R.style.button_save_style);
			b.setOnClickListener(this);
			FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) v.getLayoutParams();
			if(params!=null) {
			params.gravity=Gravity.BOTTOM;
			v.setLayoutParams(params);
			}
			((FrameLayout)v).addView(b);
			
			initMap();


		} else {
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
					getActivity());

			// set dialog message
			alertDialogBuilder
					.setTitle("Google Play Services")
					.setMessage(
							"Obs¸uga map wymaga zainstalowania Google Play Services")
					.setCancelable(true)
					.setPositiveButton("Instaluj",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int id) {
									dialog.dismiss();
									try {
										Intent intent = new Intent(
												Intent.ACTION_VIEW,
												Uri.parse("http://play.google.com/store/apps/details?id=com.google.android.gms"));
										intent.setPackage("com.android.vending");
										startActivity(intent);
										getActivity().finish();

									} catch (ActivityNotFoundException e) {
										try {
											Intent intent = new Intent(
													Intent.ACTION_VIEW,
													Uri.parse("market://details?id=com.google.android.gms"));
											intent.setPackage("com.android.vending");
											startActivity(intent);
											getActivity().finish();

										} catch (ActivityNotFoundException f) {

											Intent intent = new Intent(
													Intent.ACTION_VIEW,
													Uri.parse("http://play.google.com/store/apps/details?id=com.google.android.gms"));
											startActivity(intent);
											getActivity().finish();
										}
									}
								}
							})
					.setNegativeButton("Anuluj",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int id) {
									dialog.cancel();
								}
							}).create().show();
		}

		return v;
	}


	private void initMap() {
		googleMap=getMap();
		if(googleMap!=null) {
		
		googleMap.setOnMarkerDragListener(MapFragment.this);
		CameraUpdate myLocationCamera = CameraUpdateFactory.newLatLngZoom(myPosition, 15);
		googleMap.animateCamera(myLocationCamera);

		m = googleMap.addMarker(new MarkerOptions()
					.position(myPosition)
					.icon(BitmapDescriptorFactory
							.fromResource(R.drawable.ic_launcher))
					.title("My position")
					.draggable(true));

		}
	
	}

	public GpsCallbackEvent getCallback() {
		return callback;
	}

	public void setCallback(GpsCallbackEvent callback) {
		this.callback = callback;
	}

	@Override
	public void onMarkerDrag(Marker arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMarkerDragEnd(Marker m) {
		LatLng latLng = m.getPosition();
		location.setLatitude(latLng.latitude);
		location.setLongitude(latLng.longitude);
	}

	@Override
	public void onMarkerDragStart(Marker arg0) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void onClick(View v) {
	 Log.e("http: lokalizacja zapisz", location.getLatitude()+"");	
     callback.gpsCalbackEvent(location);
	}
	
}
