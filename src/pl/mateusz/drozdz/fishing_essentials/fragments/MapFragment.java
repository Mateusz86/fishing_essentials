package pl.mateusz.drozdz.fishing_essentials.fragments;


import pl.mateusz.drozdz.fishing_essentials.R;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Marker;

public class MapFragment extends SupportMapFragment {
	
	private View v;
	private GoogleMap googleMap;
	private Marker m;

	
	
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

		if (services) {
			v = super.onCreateView(inflater, container, savedInstanceState);




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


}
