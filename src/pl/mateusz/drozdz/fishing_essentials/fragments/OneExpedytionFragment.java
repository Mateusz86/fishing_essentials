package pl.mateusz.drozdz.fishing_essentials.fragments;


import java.io.IOException;
import pl.mateusz.drozdz.fishing_essentials.FishesActivity;
import pl.mateusz.drozdz.fishing_essentials.FishingActivity;
import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.core.Base64;
import pl.mateusz.drozdz.fishing_essentials.core.DataBase;
import pl.mateusz.drozdz.fishing_essentials.core.Property;
import pl.mateusz.drozdz.fishing_essentials.dao.DaoSession;
import pl.mateusz.drozdz.fishing_essentials.dao.Fishing;
import pl.mateusz.drozdz.fishing_essentials.dao.utils.MyLinearLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class OneExpedytionFragment extends Fragment {

	private View view;
	private TabHost tab;
	private DaoSession daoSessioon;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.fragment_one_expedytion, container,
				false);
		if(view != null){
			createTabs();
			
			Bundle args = getArguments();
			Long pk = args.getLong(FishingActivity.ARG_PK);
			
			System.out.println(pk);
			daoSessioon = DataBase.getInstance(getActivity())
			.getDaoSession();
			
			DateFormat df = new DateFormat();
			Fishing fishing = daoSessioon.getFishingDao().loadByRowId(pk);
			((TextView) view.findViewById(R.id.one_expedition_data)).setText(Property.DATE_FORMAT.format(fishing.getDate()));
			((TextView) view.findViewById(R.id.one_expedition_name)).setText(fishing.getPlaces().getName());
			((TextView) view.findViewById(R.id.one_expedition_description)).setText(fishing.getPlaces().getDescription());
//			((TextView) view.findViewById(R.id.one_expedition_weather)).setText(fishing.getWeather());
			
			try {
				String s = fishing.getWeather();
				System.out.println(s);
				Object o = Base64.decodeToObject(s);
				System.out.println(0);
				MyLinearLayout l = (MyLinearLayout) o;
				LinearLayout ly = (LinearLayout) view.findViewById(R.id.xyz);
				l.addView(l);
			} catch (IOException e) {
				System.out.println("erro" + e.getMessage());
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("erro1" + e.getMessage());
				e.printStackTrace();
			}
			
		}
		
		return view;

	}
	
	private void createTabs(){
		tab = (TabHost) view.findViewById(R.id.tabHost);
			tab.setup();
			
			TabSpec tab1 = tab.newTabSpec("Moja wyprawa");
			tab1.setContent(R.id.tab1);
			tab1.setIndicator("Moja wyprawa");
			
			TabSpec tab2 = tab.newTabSpec("Z�owione Ryby");
			tab2.setContent(R.id.tab2);
			tab2.setIndicator("Z�owione Ryby");
			
			tab.addTab(tab1);
			tab.addTab(tab2);
	}

}
