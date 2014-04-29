package pl.mateusz.drozdz.fishing_essentials;

import pl.mateusz.drozdz.fishing_essentials.fragments.ExpedytionTabPagerAdapter;
import pl.mateusz.drozdz.fishing_essentials.fragments.TabPagerAdapter;
import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar.TabListener;

public class OneExpedytionActivity extends ActionBarActivity implements
		TabListener {

	private ViewPager viewPager;
	private ExpedytionTabPagerAdapter mAdapter;
	private android.support.v7.app.ActionBar actionBar;
	private String[] tabs = { "Wyprawa", "Z³owione ryby" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(android.R.style.Theme_Holo);
		setContentView(R.layout.activity_settings);
		
		Bundle extras = getIntent().getExtras();
		Long pk = extras.getLong(FishingActivity.ARG_PK);
		
		System.out.println("Get exp "+pk);

		viewPager = (ViewPager) findViewById(R.id.pager);
		actionBar = getSupportActionBar();

		mAdapter = new ExpedytionTabPagerAdapter(getSupportFragmentManager());
        mAdapter.setExpedytionId(pk);
		viewPager.setAdapter(mAdapter);
		actionBar.setHomeButtonEnabled(false);
		// actionBar.setDisplayShowTitleEnabled(false);
		// actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		for (String tab_name : tabs) {
			actionBar.addTab(actionBar.newTab().setText(tab_name).setTabListener(OneExpedytionActivity.this));
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
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabSelected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub

	}

}
