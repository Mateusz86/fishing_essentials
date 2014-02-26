package pl.mateusz.drozdz.fishing_essentials.fragments;

import java.util.List;

import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.core.DataBase;
import pl.mateusz.drozdz.fishing_essentials.dao.Fishes;
import pl.mateusz.drozdz.fishing_essentials.dao.FishesDao;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class FishesFragment_List extends Fragment {

public interface ChangeFragment {
		
		public void changeFragment();
	}
	
	private ChangeFragment changeFragmentListener;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_fishes_list, container,
				false);
		if (view != null) {
			
			FishesDao fishesDao = DataBase.getInstance(getActivity()).getDaoSession().getFishesDao();
			List<Fishes> fishes = fishesDao.queryBuilder().list();
			ListView fishesList = (ListView) view.findViewById(R.id.fishes_list_view);
			//fishesList.setAdapter(new FishesListAdapter(getActivity(), fishes));
//			for (Fishes f : fishes) {
//				fishesList.
//			}
		}

		return view;
	}
	
	public void setChangeFragmentListener(ChangeFragment changeFragmentListener) {
		this.changeFragmentListener = changeFragmentListener;
	}


}
