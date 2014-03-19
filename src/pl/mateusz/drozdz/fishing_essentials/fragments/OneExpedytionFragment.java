package pl.mateusz.drozdz.fishing_essentials.fragments;

import pl.mateusz.drozdz.fishing_essentials.R;

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
			tab.setup();
			
			TabSpec tab1 = tab.newTabSpec("Moja wyprawa");
			tab1.setContent(R.id.tab1);
			tab1.setIndicator("Moja wyprawa");
			
			TabSpec tab2 = tab.newTabSpec("Z³owione Ryby");
			tab2.setContent(R.id.tab1);
			tab2.setIndicator("Z³owione Ryby");
			
			tab.addTab(tab1);
			tab.addTab(tab2);
//			tab.
		}
		
		return view;

	}

}
