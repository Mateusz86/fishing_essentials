package pl.mateusz.drozdz.fishing_essentials;

import pl.mateusz.drozdz.fishing_essentials.dao.Bait;
import pl.mateusz.drozdz.fishing_essentials.dao.BaitDao;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
/*		BaitDao baitDao = DataBase.getInstance(this).getDaoSession().getBaitDao();
		
		Bait bait= new Bait();
		bait.setName("Nazwa");
		bait.setDescription("Opis");
		baitDao.insert(bait);
		Log.e("bait"," "+bait.getId());*/
		
		Button mojeRekordyId = (Button) findViewById(R.id.mojeRekordyId);
		
		mojeRekordyId.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent myRecordActivity = new Intent(MainActivity.this, MyRecordsActivity.class);
				startActivity(myRecordActivity);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


}
