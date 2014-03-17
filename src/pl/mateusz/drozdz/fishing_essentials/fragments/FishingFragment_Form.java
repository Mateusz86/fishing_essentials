package pl.mateusz.drozdz.fishing_essentials.fragments;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import pl.mateusz.drozdz.fishing_essentials.FishingActivity;
import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.core.DataBase;
import pl.mateusz.drozdz.fishing_essentials.core.LocationHelper;
import pl.mateusz.drozdz.fishing_essentials.core.Weather;
import pl.mateusz.drozdz.fishing_essentials.core.WeatherInterface;
import pl.mateusz.drozdz.fishing_essentials.dao.DaoSession;
import pl.mateusz.drozdz.fishing_essentials.dao.Fishing;
import pl.mateusz.drozdz.fishing_essentials.dao.Places;
import pl.mateusz.drozdz.fishing_essentials.dao.PlacesDao;
import pl.mateusz.drozdz.fishing_essentials.dao.PlacesDao.Properties;
import pl.mateusz.drozdz.fishing_essentials.dao.utils.GpsCallbackEvent;
import pl.mateusz.drozdz.fishing_essentials.dao.utils.GpsSwitcher;
import pl.mateusz.drozdz.fishing_essentials.fragments.utils.DataTimePickerDialogFragment;
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
import android.widget.Toast;

public class FishingFragment_Form extends Fragment implements
		OnItemClickListener, WeatherInterface, GpsCallbackEvent {

	ChangeFragmenOnFragmentMap changeFragmentOnFragmentMap;
	
	public interface ChangeFragmenOnFragmentMap {
	  void changeFragmentOnFragmentMap();	
	}
	public void setChangeFragmentOnFragmentMap(ChangeFragmenOnFragmentMap listner) {
		 this.changeFragmentOnFragmentMap=listner;
	 }
	
	
	private View view;

	static final int DATE_PICKER_ID = 01;
	static final int TIME_PICKER_ID = 02;

	private Weather weather;

	private EditText latitude, longitude, description, weatherText;
	private Button date, form_submit;
	private ArrayAdapter<String> adapter;
	private String[] existing_places_name;
	private AutoCompleteTextView places_name;
	private DaoSession daoSession;

	private Long place_id = null;

	private LocationHelper locationHelper;

	private int year;
	private int month;
	private int day;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.fragment_fishing_form, container,
				false);
		if (view != null) {

			locationHelper = new LocationHelper(getActivity());

			/*
			 * prepare
			 */
			daoSession = DataBase.getInstance(getActivity()).getDaoSession();

			latitude = (EditText) view
					.findViewById(R.id.fishing_places_latidude);
			longitude = (EditText) view
					.findViewById(R.id.fishing_places_longitude);
			description = (EditText) view
					.findViewById(R.id.fishing_places_description);
			weatherText = (EditText) view.findViewById(R.id.fishing_weather);
			date = (Button) view.findViewById(R.id.fishing_date);
			form_submit = (Button) view.findViewById(R.id.show_form_submit);

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
			date.setText(day+"-"+month+"-"+year);
//			date.setText(Property.DATE_FORMAT.format(d));

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
						place.setDescription(description.toString());
						place.setLatitude(latitude.toString());
						place.setLongitude(longitude.toString());
						place.setDate(new Date());
						PlacesDao pd = daoSession.getPlacesDao();
						pd.insert(place);

					} else {
						place = daoSession.getPlacesDao().load(place_id);
					}
					Fishing fishing = new Fishing();
					fishing.setPlaces(place);
					System.out.println(weatherText.toString());
					fishing.setWeather(weatherText.toString());
					fishing.setDate(new Date());
					daoSession.getFishingDao().insert(fishing);

					Intent intent = new Intent(getActivity(),
							FishingActivity.class);
					startActivity(intent);
				}
			});

		}

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
			gpsCalbackEvent();
		}
		setNewPlace();
		
		ImageButton mapButton = (ImageButton) view.findViewById(R.id.fishing_form_map_on);
		mapButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				changeFragmentOnFragmentMap.changeFragmentOnFragmentMap();
			}
		});
		
	}

	@Override
	public void gpsCalbackEvent() {
		setNewPlace();
	}

	private void setNewPlace() {
		Location location = locationHelper.getLocation();

		if (location != null) {
			latitude.setText(String.valueOf(location.getLatitude()));
			longitude.setText(String.valueOf(location.getLongitude()));

			setWeather(location);
		}

	}

	private void setWeather(Location location) {
		weather = new Weather(this, location);
		weather.execute();
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
	public EditText getWeaterContener() {
		return (EditText) (this.weatherText == null ? view
				.findViewById(R.id.fishing_weather) : this.weatherText);
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
