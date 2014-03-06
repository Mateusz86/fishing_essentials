package pl.mateusz.drozdz.fishing_essentials.fragments;

import java.util.List;

import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.core.DataBase;
import pl.mateusz.drozdz.fishing_essentials.dao.Fishing;
import pl.mateusz.drozdz.fishing_essentials.dao.FishingDao;
import pl.mateusz.drozdz.fishing_essentials.list_adapter.MyExpeditionAdapter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

public class FishingFragment_List extends Fragment {
	
	
	public interface ChangeFragment {
		
		public void changeFragment();
	}
	
	private ChangeFragment changeFragmentListener;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_fishing_list, container,
				false);
		if (view != null) {
			Button show_form = (Button) view.findViewById(R.id.show_form);
			ListView myExpenditionList = (ListView) view.findViewById(R.id.mojeWyprawyList);
			
			FishingDao fishingDao = DataBase.getInstance(getActivity()).getDaoSession().getFishingDao();			
			final List<Fishing> fishes = fishingDao.queryBuilder().list();
			Log.d("size fishes",fishes.size()+"");
			myExpenditionList.setAdapter(new MyExpeditionAdapter(getActivity(), fishes));

			
			show_form.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					changeFragmentListener.changeFragment();
				}
			});
		}

		return view;
	}

	public void setChangeFragmentListener(ChangeFragment changeFragmentListener) {
		this.changeFragmentListener = changeFragmentListener;
	}

	
}
