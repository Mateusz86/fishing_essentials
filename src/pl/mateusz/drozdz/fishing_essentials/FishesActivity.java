package pl.mateusz.drozdz.fishing_essentials;

import pl.mateusz.drozdz.fishing_essentials.fragments.FishesFragment_List;
import pl.mateusz.drozdz.fishing_essentials.fragments.FishesFragment_List.ChangeFragment;
import pl.mateusz.drozdz.fishing_essentials.fragments.FishesFragment_List.OnFishesSelectedListener;
import pl.mateusz.drozdz.fishing_essentials.fragments.FishesFragment_View;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class FishesActivity extends FragmentActivity implements ChangeFragment, OnFishesSelectedListener{
	
	public static final String ARG_PK = "arg_pk";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fishes);
		
		System.out.println("active activity");
		
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		FishesFragment_List fishesFragment = new FishesFragment_List();    	 
		fishesFragment.setChangeFragmentListener(this);
	    ft.replace(R.id.fragmentContainerFishes, fishesFragment);
	    ft.addToBackStack("Show Fishes list");
	    ft.commit();
	
	}

	@Override
	public void changeFragment() {
		// TODO Auto-generated method stub
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		FishesFragment_View fishesFragment = new FishesFragment_View(); 
		ft.replace(R.id.fragmentContainerFishes, fishesFragment);
	    ft.commit();
	}

	@Override
	public void onFishSelected(Long pk) {
		// TODO Auto-generated method stub
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		FishesFragment_View fishesFragment = new FishesFragment_View(); 
		
		Bundle args = new Bundle();
        args.putLong(FishesActivity.ARG_PK,pk);
        
        fishesFragment.setArguments(args);
		ft.replace(R.id.fragmentContainerFishes, fishesFragment);
		ft.addToBackStack(null);
	    ft.commit();
	}

}
