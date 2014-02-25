package pl.mateusz.drozdz.fishing_essentials;

import pl.mateusz.drozdz.fishing_essentials.fragments.FishesFragment_List;
import pl.mateusz.drozdz.fishing_essentials.fragments.FishesFragment_List.ChangeFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class FishesActivity extends FragmentActivity implements ChangeFragment{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fishes);
		
		System.out.println("active activity");
		
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		FishesFragment_List fishesFragment = new FishesFragment_List();    	 
		fishesFragment.setChangeFragmentListener(this);
	    ft.replace(R.id.fragmentContainerFishes, fishesFragment);
	    ft.commit();
	
	}

	@Override
	public void changeFragment() {
		// TODO Auto-generated method stub
//		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//		FishesFragment_List fishesFragment = new FishesFragment_List(); 
//		ft.replace(R.id.fragmentContainerFishes, fishesFragment);
//	    ft.commit();
	}

}
