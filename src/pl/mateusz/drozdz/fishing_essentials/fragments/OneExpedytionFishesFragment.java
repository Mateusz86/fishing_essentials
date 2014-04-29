package pl.mateusz.drozdz.fishing_essentials.fragments;

import java.util.List;

import pl.mateusz.drozdz.fishing_essentials.FishingActivity;
import pl.mateusz.drozdz.fishing_essentials.core.DataBase;
import pl.mateusz.drozdz.fishing_essentials.dao.CaughtFish;
import pl.mateusz.drozdz.fishing_essentials.dao.CaughtFishDao;
import pl.mateusz.drozdz.fishing_essentials.dao.CaughtFishDao.Properties;
import pl.mateusz.drozdz.fishing_essentials.dao.DaoSession;
import pl.mateusz.drozdz.fishing_essentials.list_adapter.CaughtFishesListAdapter;
import pl.mateusz.drozdz.fishing_essentials.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TabHost;

public class OneExpedytionFishesFragment extends Fragment {

	private static List<CaughtFish> caught_fishes;
	private static View view;
	private static TabHost tab;
	private static DaoSession daoSessioon;
	private static ListView list_view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.fragment_one_expedytion_fishes,
				container, false);
		if (view != null) {
			if (daoSessioon == null) {
				daoSessioon = DataBase.getInstance(getActivity())
						.getDaoSession();
			}

			Bundle args = getArguments();
			Long fishing_pk = args.getLong(FishingActivity.ARG_PK);
			if (fishing_pk != null && fishing_pk >= 0) {

				System.out.println("console id " + fishing_pk);

				if (list_view == null) {

					list_view = (ListView) view
							.findViewById(R.id.one_expedytion_fishes_list_view);

					CaughtFishDao caughtFishDao = daoSessioon
							.getCaughtFishDao();
					caught_fishes = caughtFishDao.queryBuilder()
							.where(Properties.FishesId.eq(fishing_pk)).list();
					CaughtFishesListAdapter caughtFishesListAdapter = new CaughtFishesListAdapter(view.getContext(),caught_fishes);
					list_view.setAdapter(caughtFishesListAdapter);

				}
			}

		}

		return view;

	}



}
