package pl.mateusz.drozdz.fishing_essentials.fragments;

import java.util.List;

import pl.mateusz.drozdz.fishing_essantials.interfaces.WhichFragmentClick;
import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.core.DataBase;
import pl.mateusz.drozdz.fishing_essentials.core.ObjectHelperPositionList;
import pl.mateusz.drozdz.fishing_essentials.dao.Methods;
import pl.mateusz.drozdz.fishing_essentials.dao.MethodsDao;
import pl.mateusz.drozdz.fishing_essentials.dao.Places;
import pl.mateusz.drozdz.fishing_essentials.dao.PlacesDao;
import pl.mateusz.drozdz.fishing_essentials.list_adapter.PlacesAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ListView;

public class PlacesFragment extends Fragment {
	
	private ListView placesList;
	private PlacesAdapter placesAdapter;
	private List<Places> places;
	WhichFragmentClick whichFragmentClickListener;
	public static String NAME_FRAGMENT="PlacesFragment";


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

			
			OnClickListener buttonsListener = new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					ObjectHelperPositionList helper = (ObjectHelperPositionList) v.getTag();
					
					if(helper!=null) {
					switch(v.getId()) {
					case R.id.delete:
						Log.e("click","delete "+helper.getPosition()+"");
						FragmentBoxName.setPosition(helper.getPosition());
						whichFragmentClickListener.startDeleteActivity();
					break;	
					case R.id.update:
						Log.e("click ","update "+helper.getPosition()+"");
						whichFragmentClickListener.startUpdateActivity();

					break;	
					
			    		}
					}

				}
			};
			placesAdapter.setListener(buttonsListener);

		}
		
		return view;

	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try{
		whichFragmentClickListener=(WhichFragmentClick) activity;
		}
		catch(Exception e) {
			
		}
	}
	
	public void notifyAdapter() {		
		Places placeDelete = (Places) placesAdapter.getItem(FragmentBoxName.getPosition());
		PlacesDao placesDao = DataBase.getInstance(getActivity()).getDaoSession().getPlacesDao();
		placesDao.delete(placeDelete);
		places=placesDao.queryBuilder().list();
		placesAdapter.setPlacesList(places);
		placesAdapter.notifyDataSetChanged();

	}
}