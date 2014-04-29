package pl.mateusz.drozdz.fishing_essentials.fragments;

import java.util.List;

import pl.mateusz.drozdz.fishing_essentials.FishingActivity;
import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.core.DataBase;
import pl.mateusz.drozdz.fishing_essentials.dao.Bait;
import pl.mateusz.drozdz.fishing_essentials.dao.DaoSession;
import pl.mateusz.drozdz.fishing_essentials.dao.Fishes;
import pl.mateusz.drozdz.fishing_essentials.dao.GroundBait;
import pl.mateusz.drozdz.fishing_essentials.dao.Methods;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RelativeLayout;

public class CaughtFishForm extends Fragment {

	private View view;
	private DaoSession daoSessioon;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.fragment_caught_fish_form, container,
				false);
		if (view != null) {

			if (daoSessioon == null) {
				daoSessioon = DataBase.getInstance(getActivity())
						.getDaoSession();
			}

			Bundle args = getArguments();
			Long pk = args.getLong(FishingActivity.ARG_PK);

			System.out.println("console id " + pk);

			
			/*
			 * Set Fishesh adapter
			 */
			List<Fishes> fishes_list = daoSessioon.getFishesDao()
					.queryBuilder().list();
			AutoCompleteTextView fishesh = (AutoCompleteTextView) view.findViewById(R.id.caught_fish_fishes);
			fishesh.setAdapter(new ExtendsAdapter().getAdapter(getActivity(), android.R.layout.simple_dropdown_item_1line, fishes_list));

			
			/*
			 * Set Methods adapter
			 */
			List<Methods> method_list = daoSessioon.getMethodsDao().queryBuilder().list();		
			AutoCompleteTextView methods = (AutoCompleteTextView) view.findViewById(R.id.caught_fish_methods);
			methods.setAdapter(new ExtendsAdapter().getAdapter(getActivity(), android.R.layout.simple_dropdown_item_1line, method_list));
			
			/*
			 * Set Bait adapter
			 */
			List<Bait> baits_list = daoSessioon.getBaitDao().queryBuilder().list();		
			AutoCompleteTextView baits = (AutoCompleteTextView) view.findViewById(R.id.caught_fish_bait);
			baits.setAdapter(new ExtendsAdapter().getAdapter(getActivity(), android.R.layout.simple_dropdown_item_1line, baits_list));
			
			/*
			 * Set Methods adapter
			 */
			List<GroundBait> ground_bait_list = daoSessioon.getGroundBaitDao().queryBuilder().list();		
			AutoCompleteTextView ground_bait = (AutoCompleteTextView) view.findViewById(R.id.caught_fish_methods);
			ground_bait.setAdapter(new ExtendsAdapter().getAdapter(getActivity(), android.R.layout.simple_dropdown_item_1line, ground_bait_list));
			
			
//			Button saveButton = (Button) view.findViewById(R.id.caug);
			RelativeLayout saveButton= (RelativeLayout) view.findViewById(R.id.caught_fish_submit_wrapper);

		}

		return view;

	}
	
	private  final class ExtendsAdapter{
		private ArrayAdapter<String> adapter;
	
		public <T> ArrayAdapter<String> getAdapter(Context context,int list_layout_id, List<T> list){
			return  new ArrayAdapter<String>(context,list_layout_id,listAsArray(list)); 
			
		}
		
		private  <T> String[] listAsArray(List<T> list) {
			String[] stringArray = new String[list.size()];
			int i=0;
			for(T tmp1 : list){
				stringArray[i++]= tmp1.toString();
			}
			for(String ss: stringArray){
				System.out.print(ss+" ");
			}
			return stringArray;
		}
	}

}
