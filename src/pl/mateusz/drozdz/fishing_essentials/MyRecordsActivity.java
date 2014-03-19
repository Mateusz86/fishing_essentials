package pl.mateusz.drozdz.fishing_essentials;

import pl.mateusz.drozdz.fishing_essentials.fragments.MyRecordsFragment;


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
