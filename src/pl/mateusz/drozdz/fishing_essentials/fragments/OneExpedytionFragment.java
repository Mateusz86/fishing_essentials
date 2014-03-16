package pl.mateusz.drozdz.fishing_essentials.fragments;

import pl.mateusz.drozdz.fishing_essentials.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

public class OneExpedytionFragment extends Fragment {

	private View view;
	private TabHost tab;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.fragment_one_expedytion, container,
				false);
		if(view != null){
			tab = (TabHost) getActivity().findViewById(R.id.tabhost);
			
			tab.newTabSpec("Moja wyprawa");
//			tab.
		}
		
		return view;

	}

}
