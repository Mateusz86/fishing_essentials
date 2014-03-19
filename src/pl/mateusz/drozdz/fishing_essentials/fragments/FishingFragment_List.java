package pl.mateusz.drozdz.fishing_essentials.fragments;

import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.core.DataBase;
import pl.mateusz.drozdz.fishing_essentials.dao.Fishing;
import pl.mateusz.drozdz.fishing_essentials.dao.FishingDao;
import pl.mateusz.drozdz.fishing_essentials.list_adapter.MyExpeditionAdapter;

public class FishingFragment_List extends Fragment {
	
	
	public interface ChangeFragment {
		
		public void changeFragment();
	}
	
	public interface OnExpedytionSelected{
		public void onExpedytionSelected(Long id);
	}
	
	
	private OnExpedytionSelected onExpedytionSelected;
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
			final List<Fishing> fishing = fishingDao.queryBuilder().list();
			Log.d("size fishes",fishing.size()+"");
			myExpenditionList.setAdapter(new MyExpeditionAdapter(getActivity(), fishing));
			
			myExpenditionList.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					System.out.println(arg2);
					Long id = fishing.get(arg2).getId();
					onExpedytionSelected.onExpedytionSelected(id);
					
				}
				
			});

			
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
		System.out.println("klik111");
		this.changeFragmentListener = changeFragmentListener;
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			onExpedytionSelected = (OnExpedytionSelected) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnFishesSelectedListener");
		}
	}

	
}
