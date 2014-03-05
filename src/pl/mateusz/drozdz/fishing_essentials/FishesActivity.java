package pl.mateusz.drozdz.fishing_essentials;

import pl.mateusz.drozdz.fishing_essentials.fragments.FishesFragment_List;
import pl.mateusz.drozdz.fishing_essentials.fragments.FishesFragment_List.OnFishesSelectedListener;
import pl.mateusz.drozdz.fishing_essentials.fragments.FishesFragment_View;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

public class FishesActivity extends FragmentActivity implements OnFishesSelectedListener{
	
	public static final String ARG_PK = "arg_pk";
	
	public interface callFragmentListClickedBack {
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fishes);		
		System.out.println("active activity");
	
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		FishesFragment_List fishesFragment = new FishesFragment_List();    	 
	    ft.replace(R.id.fragmentContainerFishes, fishesFragment);
	    ft.commit();
	
	}

	@Override
	public void onFishSelected(Long pk) {
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
