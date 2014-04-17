package pl.mateusz.drozdz.fishing_essentials;

import pl.mateusz.drozdz.fishing_essentials.fragments.UpdateFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class UpdateActivity extends FragmentActivity{
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update);		
		System.out.println("active delete");

		
	
		
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		UpdateFragment updateFragment = new UpdateFragment();        
	    ft.replace(R.id.fragmentContainerFishes, updateFragment);
	    ft.commit();
	
	}
	
	
}


