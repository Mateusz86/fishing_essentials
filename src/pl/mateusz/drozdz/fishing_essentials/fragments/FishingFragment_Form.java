package pl.mateusz.drozdz.fishing_essentials.fragments;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.core.DataBase;
import pl.mateusz.drozdz.fishing_essentials.core.Property;
import pl.mateusz.drozdz.fishing_essentials.dao.DaoSession;
import pl.mateusz.drozdz.fishing_essentials.dao.Places;
import pl.mateusz.drozdz.fishing_essentials.dao.PlacesDao;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FishingFragment_Form extends Fragment  implements OnItemSelectedListener{
	
	private EditText  latitude, longitude, description, weather, date;
	ArrayAdapter<String> adapter;
	String[] existing_places_name;
	AutoCompleteTextView  places_name;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_fishing_form, container,false);
		if (view != null) {
			
			latitude = (EditText) view.findViewById(R.id.fishing_places_latidude);
			longitude = (EditText) view.findViewById(R.id.fishing_places_longitude);
			description = (EditText) view.findViewById(R.id.fishing_places_description);
			weather = (EditText) view.findViewById(R.id.fishing_weather);
			date = (EditText) view.findViewById(R.id.fishing_date);
			 
			Date d = new Date();
			date.setText(Property.DATE_FORMAT.format(d));
			
			DaoSession daoSession = DataBase.getInstance(getActivity()).getDaoSession();
			PlacesDao placesDao = daoSession.getPlacesDao();
			List<Places> placesList = placesDao.queryBuilder().list();
			existing_places_name = new String[placesList.size()];
			int i=0;
			for (Places pl : placesList) {
				existing_places_name[i]=pl.getName();
				i++;
			}
			adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line, existing_places_name);
			
			places_name =(AutoCompleteTextView ) view.findViewById(R.id.fishing_places_name);
			places_name.setAdapter(adapter);
			places_name.setOnItemSelectedListener(this);
			
		}

		return view;
	}


	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		System.out.println("nic nie wybrano");
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		Toast.makeText(getActivity(),"Wybrano", Toast.LENGTH_LONG).show();
		String places_name = existing_places_name[arg2];
		System.out.println("wybrano: "+places_name);
		
	}
	
	

}
