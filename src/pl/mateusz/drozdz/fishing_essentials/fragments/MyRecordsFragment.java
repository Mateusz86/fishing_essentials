package pl.mateusz.drozdz.fishing_essentials.fragments;

import java.util.List;

import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;
import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.core.DataBase;
import pl.mateusz.drozdz.fishing_essentials.core.Property;
import pl.mateusz.drozdz.fishing_essentials.dao.CaughtFish;
import pl.mateusz.drozdz.fishing_essentials.dao.CaughtFishDao;
import pl.mateusz.drozdz.fishing_essentials.dao.CaughtFishDao.Properties;
import pl.mateusz.drozdz.fishing_essentials.dao.DaoSession;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MyRecordsFragment extends Fragment {

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
			List<CaughtFish> coughtFishes = qu.list();
			System.out.println("all");
			for (CaughtFish caughtFish : coughtFishes) {
				System.out.println(caughtFish.getFishes().getName() + " "
						+ caughtFish.getFishLength() + "cm ");
			}

			
			// rekordy jeszce hujowo dzia³aja ale narazie moze byæ
			try {

				String sql = " GROUP BY T." + Properties.FishesId.columnName+" ORDER BY T." + Properties.FishLength.columnName
						+ ", T." + Properties.Date.columnName
						+ " ASC ";

      			coughtFishes = caughtFishDao.queryRawCreate(sql).list();
			
				System.out.println("moje rekordy");
				for (CaughtFish caughtFish : coughtFishes) {
					System.out.println(caughtFish.getFishes().getName() + " "
							+ caughtFish.getFishLength() + "cm ");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}

		}
		return view;
	}

}
