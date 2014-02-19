package pl.mateusz.drozdz.fishing_essentials;

import java.io.File;
import java.util.List;

import pl.mateusz.drozdz.fishing_essentials.core.Bootstrap;
import pl.mateusz.drozdz.fishing_essentials.core.DataBase;
import pl.mateusz.drozdz.fishing_essentials.dao.Bait;
import pl.mateusz.drozdz.fishing_essentials.dao.BaitDao;
import pl.mateusz.drozdz.fishing_essentials.dao.DaoSession;
import pl.mateusz.drozdz.fishing_essentials.dao.Fishes;
import pl.mateusz.drozdz.fishing_essentials.dao.FishesDao;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Bootstrap bootsrap;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// load data from file
		bootsrap = new Bootstrap(this);
		//bootsrap.run();

		/*
		 *  Test correct loaded data
		 * 
		FishesDao fishesDao = DataBase.getInstance(this).getDaoSession().getFishesDao();
		EditText editText = (EditText) findViewById(R.id.editText1);
		List<Fishes> fishes = fishesDao.queryBuilder().list();
		for (Fishes f : fishes) {
			editText.append(f.getId().toString() + ": " + f.getName() + "\n");
		}
		*/

		
		/*
		 * Regulations btn
		 */
		Button btn = (Button) findViewById(R.id.regulations);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				 Intent intent= new Intent(MainActivity.this,
				 RegulationsActivity.class);
				 startActivity(intent);
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
