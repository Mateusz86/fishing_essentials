package pl.mateusz.drozdz.fishing_essentials.fragments;

import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.core.DataBase;
import pl.mateusz.drozdz.fishing_essentials.dao.CaughtFish;
import pl.mateusz.drozdz.fishing_essentials.dao.CaughtFishDao;
import pl.mateusz.drozdz.fishing_essentials.dao.CaughtFishDao.Properties;
import pl.mateusz.drozdz.fishing_essentials.dao.DaoSession;
import pl.mateusz.drozdz.fishing_essentials.list_adapter.MyFishesRecordAdapter;

public class MyRecordsFragment extends Fragment {
	List<CaughtFish> coughtFishes;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_my_record, container,
				false);
		if (view != null) {
			// get records;
			DaoSession daoSession = DataBase.getInstance(getActivity())
					.getDaoSession();
			CaughtFishDao caughtFishDao = daoSession.getCaughtFishDao();

			// wszystkie ryby
			Query qu = caughtFishDao.queryBuilder().orderAsc(Properties.Date)
					.build();
			coughtFishes = qu.list();
			System.out.println("all");
			for (CaughtFish caughtFish : coughtFishes) {
				System.out.println(caughtFish.getFishes().getName() + " "
						+ caughtFish.getFishLength() + "cm ");
			}

			// rekordy jeszce hujowo dzia³aja ale narazie moze byæ
			try {

				String sql = " GROUP BY T." + Properties.FishesId.columnName
						+ " ORDER BY T." + Properties.FishLength.columnName
						+ ", T." + Properties.Date.columnName + " ASC ";

				coughtFishes = caughtFishDao.queryRawCreate(sql).list();
				// " T.ID IN ( SELECT id FROM CAUGHT_FISH GROUP BY FISHES_ID )"
//				coughtFishes = caughtFishDao
//						.queryRawCreate(
//								"WHERE  _ID IN ( SELECT _ID, MAX(FISH_LENGTH) AS FISH_LENGTH FROM CAUGHT_FISH GROUP BY FISHES_ID )")
//						.list();
				coughtFishes = caughtFishDao
						.queryRawCreate(
								"INNER JOIN ( SELECT _ID AS id, MAX(FISH_LENGTH) AS FISH_LENGTH  FROM CAUGHT_FISH GROUP BY FISHES_ID ) RECORDS ON RECORDS.id = _ID")
								.list();
//				coughtFishes = caughtFishDao
//						.queryRawCreate(
//								" GROUP BY FISHES_ID HAVING  MAX(FISH_LENGTH)")
//								.list();

				System.out.println("moje rekordy");
				for (CaughtFish caughtFish : coughtFishes) {
					System.out.println(caughtFish.getFishes().getName() + " "
							+ caughtFish.getFishLength() + "cm ");
				}

				ListView myRecordsListView = (ListView) view
						.findViewById(R.id.my_records_list_view);
				myRecordsListView.setAdapter(new MyFishesRecordAdapter(
						getActivity(), coughtFishes));

			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}

		}
		return view;
	}
}
