package pl.mateusz.drozdz.fishing_essentials.fragments;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import pl.mateusz.drozdz.fishing_essantials.dialog.DataTimePickerDialogFragment;
import pl.mateusz.drozdz.fishing_essantials.interfaces.WeatherInterface;
import pl.mateusz.drozdz.fishing_essentials.FishingActivity;
import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.core.Base64;
import pl.mateusz.drozdz.fishing_essentials.core.DataBase;
import pl.mateusz.drozdz.fishing_essentials.core.Property;
import pl.mateusz.drozdz.fishing_essentials.core.WeatherAsyncTask;
import pl.mateusz.drozdz.fishing_essentials.dao.DaoSession;
import pl.mateusz.drozdz.fishing_essentials.dao.Fishing;
import pl.mateusz.drozdz.fishing_essentials.dao.Places;
import pl.mateusz.drozdz.fishing_essentials.dao.PlacesDao;
import pl.mateusz.drozdz.fishing_essentials.dao.PlacesDao.Properties;
import pl.mateusz.drozdz.fishing_essentials.utils.GpsCallbackEvent;
import pl.mateusz.drozdz.fishing_essentials.utils.GpsSwitcher;
import pl.mateusz.drozdz.fishing_essentials.utils.MyLinearLayout;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class FishingFragment_Form extends Fragment implements
		OnItemClickListener, WeatherInterface, GpsCallbackEvent {

	ChangeFragmenOnFragmentMap changeFragmentOnFragmentMap;

	public interface ChangeFragmenOnFragmentMap {
		void changeFragmentOnFragmentMap();
	}

	public void setChangeFragmentOnFragmentMap(
			ChangeFragmenOnFragmentMap listner) {
		this.changeFragmentOnFragmentMap = listner;
	}

	private View view;

	static final int DATE_PICKER_ID = 01;
	static final int TIME_PICKER_ID = 02;

	private WeatherAsyncTask weatherAsync;

	private EditText description;
	private TextView latitude, longitude;
	private Button date, form_submit;
	private ArrayAdapter<String> adapter;
	private String[] existing_places_name;
	private AutoCompleteTextView places_name;
	private DaoSession daoSession;

	private Long place_id = null;

	private int year;
	private int month;
	private int day;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.fragment_fishing_form, container,
				false);
		if (view != null) {

			/*
			 * prepare
			 */
			daoSession = DataBase.getInstance(getActivity()).getDaoSession();

			latitude = (TextView) view
					.findViewById(R.id.fishing_places_latidude);
			longitude = (TextView) view
					.findViewById(R.id.fishing_places_longitude);
			description = (EditText) view
					.findViewById(R.id.fishing_places_description);
			// weatherText = (EditText)
			// view.findViewById(R.id.fishing_weather_text);
			date = (Button) view.findViewById(R.id.fishing_date);
			form_submit = (Button) view.findViewById(R.id.show_form_submit);
			
			
			Location location = Property.getLocation();
			latitude.setText(String.valueOf(location.getLatitude()));
			longitude.setText(String.valueOf(location.getLongitude()));

			/*
			 * prepare Autocomplete
			 */
			final DaoSession daoSession = DataBase.getInstance(getActivity())
					.getDaoSession();
			PlacesDao placesDao = daoSession.getPlacesDao();
			List<Places> placesList = placesDao.queryBuilder().list();
			existing_places_name = new String[placesList.size()];
			int i = 0;
			for (Places pl : placesList) {
				existing_places_name[i] = pl.getName();
				i++;
			}
			adapter = new ArrayAdapter<String>(getActivity(),
					android.R.layout.simple_dropdown_item_1line,
					existing_places_name);

			places_name = (AutoCompleteTextView) view
					.findViewById(R.id.fishing_places_name);
			places_name.setAdapter(adapter);

			places_name.setOnItemClickListener(this);
			places_name.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					place_id = null;
				}
			});

			/*
			 * prepare Data Time picker
			 */
			final Calendar c = Calendar.getInstance();
			year = c.get(Calendar.YEAR);
			month = c.get(Calendar.MONTH);
			day = c.get(Calendar.DAY_OF_MONTH);

			Date d = new Date();
			date.setText(day + "-" + month + "-" + year);

			date.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					getFragmentManager().popBackStack();
					new DataTimePickerDialogFragment().show(
							getFragmentManager(), "ss");
				}
			});
			
			
			

			/*
			 * submit form
			 */
			form_submit.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					Places place;
					if (place_id == null) {
						place = new Places();
						place.setName(places_name.getText().toString());
						place.setDescription(description.getText().toString());
						place.setLatitude(latitude.getText().toString());
						place.setLongitude(longitude.getText().toString());
						place.setDate(new Date());
						PlacesDao pd = daoSession.getPlacesDao();
						pd.insert(place);

					} else {
						place = daoSession.getPlacesDao().load(place_id);
					}
					Fishing fishing = new Fishing();
					fishing.setPlaces(place);

					try {
						String s = Base64.encodeObject(weatherAsync
								.getWeather());
						System.out.println(s);
						fishing.setWeather(s);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					fishing.setDate(new Date());
					daoSession.getFishingDao().insert(fishing);

					Intent intent = new Intent(getActivity(),
							FishingActivity.class);
					startActivity(intent);
				}
			});

		}
		
		System.out.println("restum");

		return view;
		
	}

	@Override
	public void onResume() {
		super.onResume();
		System.out.println("restum");
		if (place_id == null) {
			ImageButton gps_swicher = (ImageButton) view
					.findViewById(R.id.fishing_form_gps_on);
			gps_swicher.setOnClickListener(new GpsSwitcher(getActivity(),
					gps_swicher, this));
			//gpsCalbackEvent(null);
		}
		
		
		//gpsCalbackEvent(null);
		setLocation();

		ImageButton mapButton = (ImageButton) view
				.findViewById(R.id.fishing_form_map_on);
		mapButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				changeFragmentOnFragmentMap.changeFragmentOnFragmentMap();
			}
		});

	}

	@Override
	public void gpsCalbackEvent(Location location) {
		if(location == null){
			location = Property.getLocation();
			latitude.setText(String.valueOf(location.getLatitude()));
			longitude.setText(String.valueOf(location.getLongitude()));
		}else{
			latitude.setText(String.valueOf(location.getLatitude()));
			longitude.setText(String.valueOf(location.getLongitude()));
		}
		
		setLocation();
		//this.setNewPlace(location);
	}
	
	private void setLocation(){
		Location tmp_location = new Location("null");
		tmp_location.setLatitude(Double.valueOf(latitude.getText().toString()));
		tmp_location.setLongitude(Double.valueOf(longitude.getText().toString()));
		setWeather(tmp_location);
	}


	private void setWeather(Location location) {
		System.out.println("http:    pobieranie pogody    ");
		weatherAsync = new WeatherAsyncTask(this, location);
		weatherAsync.execute();
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		String str = (String) arg0.getItemAtPosition(arg2);

		PlacesDao placesDao = daoSession.getPlacesDao();
		Places places = placesDao.queryBuilder().where(Properties.Name.eq(str))
				.list().get(0);
		latitude.setText(places.getLatitude());
		longitude.setText(places.getLongitude());
		description.setText(places.getDescription());
		place_id = places.getId();

		Location l = new Location("");
		l.setLatitude(Double.valueOf(places.getLatitude()));
		l.setLongitude(Double.valueOf(places.getLongitude()));
		setWeather(l);

		InputMethodManager imm = (InputMethodManager) getActivity()
				.getSystemService(getActivity().INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(places_name.getWindowToken(), 0);

		Toast.makeText(getActivity(), "Wybrano " + str, Toast.LENGTH_LONG)
				.show();

	}

	@Override
	public MyLinearLayout getWeaterContener() {
		return (MyLinearLayout) view.findViewById(R.id.fishing_weather_wrapper);

	}

	@Override
	public Context getContext() {
		return getActivity();
	}

	@Override
	public int getWeatherType() {
		return 0;
	}

	@Override
	public ProgressBar getProgressBar() {
		return (ProgressBar) view.findViewById(R.id.progressBar);
	}

}
