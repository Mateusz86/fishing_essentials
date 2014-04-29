package pl.mateusz.drozdz.fishing_essentials.fragments;
import java.io.Serializable;
import java.util.List;

import pl.mateusz.drozdz.fishing_essantials.interfaces.WhichFragmentClick;
import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.core.DataBase;
import pl.mateusz.drozdz.fishing_essentials.core.ObjectHelperPositionList;
import pl.mateusz.drozdz.fishing_essentials.dao.Bait;
import pl.mateusz.drozdz.fishing_essentials.dao.BaitDao;
import pl.mateusz.drozdz.fishing_essentials.list_adapter.BaitAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ListView;


public class BaitFragment extends Fragment implements Serializable{
	
	private ListView baitList;
	private BaitAdapter baitAdapter;
	private List<Bait> baits;
	public static String NAME_FRAGMENT="BaitFragment";
	
	WhichFragmentClick whichFragmentClickListener;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	View view = inflater.inflate(R.layout.fragment_bait, container,
				false);
		if(view != null){
			BaitDao baitDao = DataBase.getInstance(getActivity()).getDaoSession().getBaitDao();
			baits=baitDao.queryBuilder().list();
			
			this.baitList = (ListView) view.findViewById(R.id.baitList);
			baitAdapter = new BaitAdapter(getActivity(),baits);
			baitList.setAdapter(baitAdapter); 
			
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
						FragmentBoxName.setPosition(helper.getPosition());
						whichFragmentClickListener.startUpdateActivity();

					break;	
					
			    		}
					}

				}
			};
			
			baitAdapter.setListener(buttonsListener);
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
		
		Bait baitDelete = (Bait) baitAdapter.getItem(FragmentBoxName.getPosition());
		BaitDao baitDao = DataBase.getInstance(getActivity()).getDaoSession().getBaitDao();
		baitDao.delete(baitDelete);
		baits=baitDao.queryBuilder().list();
		baitAdapter.setBaitList(baits);
		baitAdapter.notifyDataSetChanged();

	}

}
