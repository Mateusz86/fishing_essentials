package pl.mateusz.drozdz.fishing_essentials.fragments;
import java.util.List;

import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.core.DataBase;
import pl.mateusz.drozdz.fishing_essentials.dao.Bait;
import pl.mateusz.drozdz.fishing_essentials.dao.BaitDao;
import pl.mateusz.drozdz.fishing_essentials.list_adapter.BaitAdapter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ListView;


public class BaitFragment extends Fragment {
	
	private ListView baitList;
	private BaitAdapter baitAdapter;
	private List<Bait> baits;
	private ImageButton delete;
	private ImageButton update;

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
					
				}
			};
			
		}
		
		return view;

	}

}
