package pl.mateusz.drozdz.fishing_essentials;


import pl.mateusz.drozdz.fishing_essentials.fragments.FishingFragment_Form;
import pl.mateusz.drozdz.fishing_essentials.fragments.FishingFragment_List;
import pl.mateusz.drozdz.fishing_essentials.fragments.FishingFragment_List.ChangeFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class FishingActivity extends FragmentActivity implements ChangeFragment {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fishing);
		
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
	    FishingFragment_List fishingFragment = new FishingFragment_List();    	 
	    fishingFragment.setChangeFragmentListener(this);
	    ft.replace(R.id.fragmentContainerFishing, fishingFragment);
	    ft.commit();
		
	
	}

	@Override
	public void changeFragment() {
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
	    FishingFragment_Form fishingFragment = new FishingFragment_Form();    	 
	    ft.replace(R.id.fragmentContainerFishing, fishingFragment);
	    ft.addToBackStack(null);
	    ft.commit();
	}
}
