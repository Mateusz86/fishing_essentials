package pl.mateusz.drozdz.fishing_essentials.fragments;

import java.util.List;

import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.core.DataBase;
import pl.mateusz.drozdz.fishing_essentials.dao.Fishes;
import pl.mateusz.drozdz.fishing_essentials.dao.FishesDao;
import pl.mateusz.drozdz.fishing_essentials.list_adapter.FishesListAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class FishesFragment_List extends Fragment {

	public interface ChangeFragment {

		public void changeFragment();
	}

	public interface OnFishesSelectedListener {
		public void onFishSelected(Long pk);
	}

	private Long pk;

	private OnFishesSelectedListener callback;
	private ChangeFragment changeFragmentListener;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_fishes_list, container,
				false);
		if (view != null) {

			FishesDao fishesDao = DataBase.getInstance(getActivity())
					.getDaoSession().getFishesDao();
			final List<Fishes> fishes = fishesDao.queryBuilder().list();
			ListView fishesList = (ListView) view
					.findViewById(R.id.fishes_list_view);
			fishesList.setAdapter(new FishesListAdapter(getActivity(), fishes));

			fishesList.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					System.out.println(arg2 + " " + arg3);
					callback.onFishSelected(fishes.get(arg2).getId());
					//changeFragmentListener.changeFragment();
				}
			});

		}

		return view;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			callback = (OnFishesSelectedListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnFishesSelectedListener");
		}
	}

	public void setChangeFragmentListener(ChangeFragment changeFragmentListener) {
		this.changeFragmentListener = changeFragmentListener;
	}

}
