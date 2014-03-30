package pl.mateusz.drozdz.fishing_essentials.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabPagerAdapter extends FragmentPagerAdapter  {

	public TabPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	    @Override
	    public Fragment getItem(int index) {
	 
	        switch (index) {
	        case 0:
	            return new BaitFragment();
	        case 1:
	            return new GroundBaitFragment();
	        case 2:
	            return new MethodsFragment();
	        case 3: 
	            return new PlacesFragment();  
	        }
	 
	        return null;
	    }
	 
	    @Override
	    public int getCount() {
	        return 4;
	    }
	
}
