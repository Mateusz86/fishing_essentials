package pl.mateusz.drozdz.fishing_essentials.fragments;

import pl.mateusz.drozdz.fishing_essentials.FishesActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ExpedytionTabPagerAdapter extends FragmentPagerAdapter {

	private Long fishing_pk;

	public ExpedytionTabPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	public Long getExpedytionId() {
		return fishing_pk;
	}

	public void setExpedytionId(Long expedytionId) {
		this.fishing_pk = expedytionId;
	}

	@Override
	public Fragment getItem(int index) {

		Bundle args = new Bundle();
		args.putLong(FishesActivity.ARG_PK, fishing_pk);

		System.out.println("console index "+index);
//		System.out.println(fishing_pk);
		switch (index) {
		case 0:
			OneExpedytionFragment f = new OneExpedytionFragment();
			f.setArguments(args);
			return f;
		case 1:
			OneExpedytionFishesFragment f1 = new OneExpedytionFishesFragment();
			f1.setArguments(args);
			return f1;
		case 2:
			CaughtFishForm f2 = new CaughtFishForm();
			f2.setArguments(args);
			return f2;


		}

		return null;
	}

	@Override
	public int getCount() {
		return 3;
	}

}
