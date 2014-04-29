package pl.mateusz.drozdz.fishing_essentials.fragments;

import pl.mateusz.drozdz.fishing_essentials.FishesActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ExpedytionTabPagerAdapter extends FragmentPagerAdapter {

	private Long expedytionId;

	public ExpedytionTabPagerAdapter(FragmentManager fm) {
		super(fm);
	}
	
	

	public Long getExpedytionId() {
		return expedytionId;
	}



	public void setExpedytionId(Long expedytionId) {
		this.expedytionId = expedytionId;
	}



	@Override
	public Fragment getItem(int index) {
		
		 Bundle args = new Bundle();
         args.putLong(FishesActivity.ARG_PK,expedytionId);

		switch (index) {
		case 0:
			OneExpedytionFragment f = new OneExpedytionFragment();
			f.setArguments(args);
			return f;
		case 1:
			GroundBaitFragment f1 = new GroundBaitFragment();
			f1.setArguments(args);
			return f1;

		}

		return null;
	}

	@Override
	public int getCount() {
		return 2;
	}

}
