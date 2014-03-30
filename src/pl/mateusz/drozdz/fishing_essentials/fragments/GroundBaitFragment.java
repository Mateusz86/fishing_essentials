package pl.mateusz.drozdz.fishing_essentials.fragments;

import java.util.List;

import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.core.DataBase;
import pl.mateusz.drozdz.fishing_essentials.dao.Bait;
import pl.mateusz.drozdz.fishing_essentials.dao.GroundBait;
import pl.mateusz.drozdz.fishing_essentials.dao.GroundBaitDao;
import pl.mateusz.drozdz.fishing_essentials.list_adapter.BaitAdapter;
import pl.mateusz.drozdz.fishing_essentials.list_adapter.GroundBaitAdapter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class GroundBaitFragment extends Fragment {
	
	private ListView groundBaitList;
	private GroundBaitAdapter groundBaitAdapter;
	private List<GroundBait> grounds;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

	View view = inflater.inflate(R.layout.fragment_ground_bait, container,
				false);
		if(view != null){
		
		GroundBaitDao groundBaitDao = DataBase.getInstance(getActivity()).getDaoSession().getGroundBaitDao();
		grounds=groundBaitDao.queryBuilder().list();	
		this.groundBaitList = (ListView) view.findViewById(R.id.groundbaitList);
		groundBaitAdapter = new GroundBaitAdapter(getActivity(),grounds);
		groundBaitList.setAdapter(groundBaitAdapter);
			
		}
		
		return view;

	}

}
