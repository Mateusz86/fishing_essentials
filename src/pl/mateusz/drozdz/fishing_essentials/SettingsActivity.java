package pl.mateusz.drozdz.fishing_essentials;

import pl.mateusz.drozdz.fishing_essantials.dialog.CallFragmentToUpdateList;
import pl.mateusz.drozdz.fishing_essantials.dialog.CloseDialog;
import pl.mateusz.drozdz.fishing_essantials.dialog.DeleteDataFromDatabaseDialog;
import pl.mateusz.drozdz.fishing_essantials.interfaces.UpdateAdapterListInterface;
import pl.mateusz.drozdz.fishing_essantials.interfaces.WhichFragmentClick;
import pl.mateusz.drozdz.fishing_essentials.fragments.BaitFragment;
import pl.mateusz.drozdz.fishing_essentials.fragments.FragmentBoxName;
import pl.mateusz.drozdz.fishing_essentials.fragments.GroundBaitFragment;
import pl.mateusz.drozdz.fishing_essentials.fragments.MethodsFragment;
import pl.mateusz.drozdz.fishing_essentials.fragments.PlacesFragment;
import pl.mateusz.drozdz.fishing_essentials.fragments.TabPagerAdapter;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;

public class SettingsActivity extends ActionBarActivity  implements TabListener,WhichFragmentClick,UpdateAdapterListInterface{
		
   private ViewPager viewPager;
   private TabPagerAdapter mAdapter;
   private android.support.v7.app.ActionBar actionBar;
   private String[] tabs = { "Przynêty", "Zanêty", "Metody","Miejsca" };
   private Intent intent;
   private CallFragmentToUpdateList L;
   private static int pos;
      
   
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(android.R.style.Theme_Holo);
		setContentView(R.layout.activity_settings);

		viewPager = (ViewPager) findViewById(R.id.pager);
		actionBar= getSupportActionBar();
		FragmentBoxName.setName(BaitFragment.NAME_FRAGMENT);

        
        mAdapter = new TabPagerAdapter(getSupportFragmentManager());
 
        viewPager.setAdapter(mAdapter);
        actionBar.setHomeButtonEnabled(false);
     // actionBar.setDisplayShowTitleEnabled(false);
     // actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);       
 
      for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name).setTabListener(SettingsActivity.this));
        }
      
      viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
    	  
    	    @Override
    	    public void onPageSelected(int position) {
    	        actionBar.setSelectedNavigationItem(position);
    	        pos=position;
    			switch (position) {
				case 0:
	    			FragmentBoxName.setName(BaitFragment.NAME_FRAGMENT);
					break;
				case 1:
					FragmentBoxName.setName(GroundBaitFragment.NAME_FRAGMENT);
					break;
				case 2:
					FragmentBoxName.setName(MethodsFragment.NAME_FRAGMENT);
					break;
				case 3:
					FragmentBoxName.setName(PlacesFragment.NAME_FRAGMENT);
					break;
				default:
	    			FragmentBoxName.setName(BaitFragment.NAME_FRAGMENT);
					break;
				}

    	    }
    	 
    	    @Override
    	    public void onPageScrolled(int arg0, float arg1, int arg2) {

    	    }
    	 
    	    @Override
    	    public void onPageScrollStateChanged(int arg0) {

    	    }
    	});
	}



	@Override
	public void onTabReselected(android.support.v7.app.ActionBar.Tab arg0,
			android.support.v4.app.FragmentTransaction arg1) {
		
	}

	@Override
	public void onTabSelected(android.support.v7.app.ActionBar.Tab arg0,
			android.support.v4.app.FragmentTransaction arg1) {
            viewPager.setCurrentItem(arg0.getPosition());
		
	}

	@Override
	public void onTabUnselected(android.support.v7.app.ActionBar.Tab arg0,
			android.support.v4.app.FragmentTransaction arg1) {
		
	}


	@Override
	public void startDeleteActivity() {
		DeleteDataFromDatabaseDialog dialog = new DeleteDataFromDatabaseDialog(
				SettingsActivity.this, "Czy na pewno chcesz usun¹æ element z bazydanych",SettingsActivity.this,SettingsActivity.this);
		dialog.show();
		
	
	}



	@Override
	public void startUpdateActivity() {
		  intent= new Intent(SettingsActivity.this,
		    		UpdateActivity.class);
				    startActivity(intent);		
	}



	@Override
	public void updateAdapterList() {
		mAdapter.update();
	}

}
