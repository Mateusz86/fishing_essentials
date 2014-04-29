package pl.mateusz.drozdz.fishing_essentials.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

public class TabPagerAdapter extends FragmentPagerAdapter  {

	private	BaitFragment baitFragment;
	private GroundBaitFragment groundBaitFragment;
	private MethodsFragment methodsFragment;
	private PlacesFragment placesFragment;
	
	public TabPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	    @Override
	    public Fragment getItem(int index) {
	 
	        switch (index) {
	        case 0:
	        	baitFragment = new BaitFragment();
	            return baitFragment;
			case 1:
				groundBaitFragment = new GroundBaitFragment();
	            return groundBaitFragment;
	        case 2: 
	        	methodsFragment = new MethodsFragment();
	            return methodsFragment;
	        case 3: 
	        	placesFragment = new PlacesFragment();
	            return placesFragment;
	        }
	 
	        return null;
	    }
	 
	    @Override
	    public int getCount() {
	        return 4;
	    }
	
	   public void update() {
		   
		String boxName = FragmentBoxName.getName();
			
			
			if(boxName.equals(BaitFragment.NAME_FRAGMENT))
		    baitFragment.notifyAdapter();
			if(boxName.equals(GroundBaitFragment.NAME_FRAGMENT)) 
			groundBaitFragment.notifyAdapter();	
		    Log.e("box","ground");
			if(boxName.equals(MethodsFragment.NAME_FRAGMENT)) 
			methodsFragment.notifyAdapter();	
			Log.e("box","method");
			if(boxName.equals(PlacesFragment.NAME_FRAGMENT)) 
			placesFragment.notifyAdapter();		
			Log.e("box","places");
	   }
}
