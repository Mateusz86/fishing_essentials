package pl.mateusz.drozdz.fishing_essentials.fragments;

import java.util.List;

import pl.mateusz.drozdz.fishing_essantials.interfaces.WhichFragmentClick;
import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.core.DataBase;
import pl.mateusz.drozdz.fishing_essentials.core.ObjectHelperPositionList;
import pl.mateusz.drozdz.fishing_essentials.dao.Bait;
import pl.mateusz.drozdz.fishing_essentials.dao.BaitDao;
import pl.mateusz.drozdz.fishing_essentials.dao.GroundBait;
import pl.mateusz.drozdz.fishing_essentials.dao.GroundBaitDao;
import pl.mateusz.drozdz.fishing_essentials.list_adapter.GroundBaitAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ListView;

public class GroundBaitFragment extends Fragment  {
	
	private ListView groundBaitList;
	private GroundBaitAdapter groundBaitAdapter;
	private List<GroundBait> grounds;
	public static String NAME_FRAGMENT="GroundBaitFragment";

	WhichFragmentClick whichFragmentClickListener;

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
		
		groundBaitAdapter.setListener(buttonsListener);
				
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
		
		GroundBait groundBaitDelete = (GroundBait) groundBaitAdapter.getItem(FragmentBoxName.getPosition());
		GroundBaitDao groundBaitDao = DataBase.getInstance(getActivity()).getDaoSession().getGroundBaitDao();
		groundBaitDao.delete(groundBaitDelete);
		grounds=groundBaitDao.queryBuilder().list();
		groundBaitAdapter.setGroundList(grounds);
		groundBaitAdapter.notifyDataSetChanged();

	}
}
