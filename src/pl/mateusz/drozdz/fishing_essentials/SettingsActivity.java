package pl.mateusz.drozdz.fishing_essentials;

import pl.mateusz.drozdz.fishing_essentials.fragments.TabPagerAdapter;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;

//public class SettingsActivity extends FragmentActivity  implements ActionBar.TabListener{
public class SettingsActivity extends ActionBarActivity  implements TabListener{
		
   private ViewPager viewPager;
   private TabPagerAdapter mAdapter;
   private android.support.v7.app.ActionBar actionBar;
   private String[] tabs = { "Przynêty", "Zanêty", "Metody","Miejsca" };
   
   
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(android.R.style.Theme_Holo);
		setContentView(R.layout.activity_settings);

		viewPager = (ViewPager) findViewById(R.id.pager);
		actionBar= getSupportActionBar();

        
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

}
