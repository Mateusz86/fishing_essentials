package pl.mateusz.drozdz.fishing_essentials.fragments;

import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.core.DataBase;
import pl.mateusz.drozdz.fishing_essentials.dao.Fishes;
import pl.mateusz.drozdz.fishing_essentials.dao.FishesDao;
import pl.mateusz.drozdz.fishing_essentials.list_adapter.FishesListAdapter;

public class FishesFragment_List extends Fragment {

	int position =0;
	
	public interface OnFishesSelectedListener {
		public void onFishSelected(Long pk,int position);
	}

	private Long pk;

	private OnFishesSelectedListener callback;

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
			Log.d("Position",position+"");
			fishesList.setSelection(position);
			fishesList.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					System.out.println(arg2 + " " + arg3);
					callback.onFishSelected(fishes.get(arg2).getId(),arg2);
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

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	
}
