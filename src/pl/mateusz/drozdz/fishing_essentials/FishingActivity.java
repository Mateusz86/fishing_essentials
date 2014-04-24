package pl.mateusz.drozdz.fishing_essentials;

import pl.mateusz.drozdz.fishing_essentials.fragments.FishingFragment_Form;
import pl.mateusz.drozdz.fishing_essentials.fragments.FishingFragment_List;
import pl.mateusz.drozdz.fishing_essentials.fragments.FishingFragment_List.ChangeFragment;
import pl.mateusz.drozdz.fishing_essentials.fragments.FishingFragment_List.OnExpedytionSelected;
import pl.mateusz.drozdz.fishing_essentials.fragments.MapFragment;
import pl.mateusz.drozdz.fishing_essentials.fragments.OneExpedytionFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;



public class FishingActivity extends FragmentActivity  implements ChangeFragment,FishingFragment_Form.ChangeFragmenOnFragmentMap, OnExpedytionSelected {

	public static final String ARG_PK = "arg_pk";
	public FishingFragment_Form fishingFragment;
	
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
	    this.fishingFragment = new FishingFragment_Form(); 
	    fishingFragment.setChangeFragmentOnFragmentMap(this);
	    ft.replace(R.id.fragmentContainerFishing, fishingFragment);
	    ft.addToBackStack(null);
	    ft.commit();
	}

	@Override
	public void onExpedytionSelected(Long id) {
		System.out.println("Expedytion "+id);
		
//		Bundle args = new Bundle();
//        args.putLong(FishesActivity.ARG_PK,id);
        
        Intent intent= new Intent(FishingActivity.this,
        		OneExpedytionActivity.class);
        intent.putExtra(FishesActivity.ARG_PK,id);
				 startActivity(intent);
        
//		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//		OneExpedytionFragment fragment = new OneExpedytionFragment();
//
//		
//        
//        fragment.setArguments(args);
//		
//		ft.replace(R.id.fragmentContainerFishing, fragment);
//		ft.addToBackStack(null);
//		ft.commit();
	}
	

	@Override
	public void changeFragmentOnFragmentMap() {
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		MapFragment map = new MapFragment();
		map.setCallback(fishingFragment);
		ft.replace(R.id.fragmentContainerFishing, map);
	    ft.addToBackStack(null);
		ft.commit();

	}

}
