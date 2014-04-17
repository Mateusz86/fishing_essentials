package pl.mateusz.drozdz.fishing_essentials;

import pl.mateusz.drozdz.fishing_essentials.fragments.DeleteFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class DeleteActivity extends FragmentActivity{
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_delete);		
		System.out.println("active delete");

				
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		DeleteFragment deleteFragment = new DeleteFragment();    
	    
	    ft.replace(R.id.fragmentContainerFishes, deleteFragment);
	    ft.commit();
	
	}
	
	
}


