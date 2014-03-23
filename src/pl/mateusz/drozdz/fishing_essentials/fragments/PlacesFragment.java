package pl.mateusz.drozdz.fishing_essentials.fragments;

import java.util.List;

import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.core.DataBase;
import pl.mateusz.drozdz.fishing_essentials.dao.Bait;
import pl.mateusz.drozdz.fishing_essentials.dao.Places;
import pl.mateusz.drozdz.fishing_essentials.dao.PlacesDao;
import pl.mateusz.drozdz.fishing_essentials.list_adapter.BaitAdapter;
import pl.mateusz.drozdz.fishing_essentials.list_adapter.PlacesAdapter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class PlacesFragment extends Fragment {
	
	private ListView placesList;
	private PlacesAdapter placesAdapter;
	private List<Places> places;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

	View view = inflater.inflate(R.layout.fragment_places, container,
				false);
		if(view != null){
			PlacesDao placesDao = DataBase.getInstance(getActivity()).getDaoSession().getPlacesDao();
			places=placesDao.queryBuilder().list();
		
			
			this.placesList = (ListView) view.findViewById(R.id.placesList);
			placesAdapter = new PlacesAdapter(getActivity(),places);
			placesList.setAdapter(placesAdapter);	
		}
		
		return view;

	}

}