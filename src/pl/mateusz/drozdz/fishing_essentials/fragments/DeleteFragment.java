package pl.mateusz.drozdz.fishing_essentials.fragments;

import pl.mateusz.drozdz.fishing_essentials.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DeleteFragment  extends Fragment {
	
	TextView tempID;
	String boxName;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

	View view = inflater.inflate(R.layout.fragment_delete, container,
				false);
		if(view != null){

			tempID= (TextView) view.findViewById(R.id.tempID);
			boxName = FragmentBoxName.getName();
			
			
			if(boxName.equals(BaitFragment.NAME_FRAGMENT))
			Log.e("box","bait");
			if(boxName.equals(GroundBaitFragment.NAME_FRAGMENT)) 
		    Log.e("box","ground");
			if(boxName.equals(MethodsFragment.NAME_FRAGMENT)) 
			Log.e("box","method");
			if(boxName.equals(PlacesFragment.NAME_FRAGMENT)) 
			Log.e("box","places");
			
		}
		
		return view;

	}
	

}
