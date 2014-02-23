package pl.mateusz.drozdz.fishing_essentials;

import pl.mateusz.drozdz.fishing_essentials.fragments.MyRecordsFragment;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


public class MyRecordsActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_record);
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
	    MyRecordsFragment myRecordFragment = new MyRecordsFragment();    	        
	    ft.replace(R.id.fragmentContainer, myRecordFragment);
	    ft.commit();
	}

}
