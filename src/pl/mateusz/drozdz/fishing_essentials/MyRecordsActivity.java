package pl.mateusz.drozdz.fishing_essentials;



import pl.mateusz.drozdz.fishing_essentials.fragments.MyRecordsFragment;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MyRecordsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_record);
		
		 FragmentTransaction ft = getFragmentManager().beginTransaction();
	        MyRecordsFragment myRecordFragment = new MyRecordsFragment();
	        	        
	        ft.replace(R.id.fragmentContainer, myRecordFragment);
	        ft.commit();
		
	}

	
}
