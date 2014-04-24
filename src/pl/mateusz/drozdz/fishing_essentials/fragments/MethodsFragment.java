package pl.mateusz.drozdz.fishing_essentials.fragments;

import java.util.List;

import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.core.DataBase;
import pl.mateusz.drozdz.fishing_essentials.core.ObjectHelperPositionList;
import pl.mateusz.drozdz.fishing_essentials.core.WhichFragmentClick;
import pl.mateusz.drozdz.fishing_essentials.dao.Methods;
import pl.mateusz.drozdz.fishing_essentials.dao.MethodsDao;
import pl.mateusz.drozdz.fishing_essentials.list_adapter.MethodsAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ListView;

public class MethodsFragment extends Fragment {
	
	private ListView methodstList;
	private MethodsAdapter methodsAdapter;
	private List<Methods> methods;
	WhichFragmentClick whichFragmentClickListener;
	public static String NAME_FRAGMENT="MethodsFragment";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

	View view = inflater.inflate(R.layout.fragment_methods, container,
				false);
		if(view != null){
		 MethodsDao methodsDao= DataBase.getInstance(getActivity()).getDaoSession().getMethodsDao();
		 methods=methodsDao.queryBuilder().list();
		
		 this.methodstList = (ListView) view.findViewById(R.id.methodsList);
		 methodsAdapter = new MethodsAdapter(getActivity(),methods);
		 methodstList.setAdapter(methodsAdapter);
			
			OnClickListener buttonsListener = new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					ObjectHelperPositionList helper = (ObjectHelperPositionList) v.getTag();
					
					if(helper!=null) {
					switch(v.getId()) {
					case R.id.delete:
						Log.e("click ","delete "+helper.getPosition()+"");
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
			
			methodsAdapter.setListener(buttonsListener);
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

}
