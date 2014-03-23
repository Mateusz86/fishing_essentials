package pl.mateusz.drozdz.fishing_essentials.fragments;

import java.util.List;

import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.core.DataBase;
import pl.mateusz.drozdz.fishing_essentials.dao.Bait;
import pl.mateusz.drozdz.fishing_essentials.dao.Methods;
import pl.mateusz.drozdz.fishing_essentials.dao.MethodsDao;
import pl.mateusz.drozdz.fishing_essentials.list_adapter.BaitAdapter;
import pl.mateusz.drozdz.fishing_essentials.list_adapter.MethodsAdapter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class MethodsFragment extends Fragment {
	
	private ListView methodstList;
	private MethodsAdapter methodsAdapter;
	private List<Methods> methods;

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
		 
		}
		
		return view;

	}

}
