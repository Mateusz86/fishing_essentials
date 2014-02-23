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
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

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

		
/*		BaitDao baitDao = DataBase.getInstance(this).getDaoSession().getBaitDao();
		
		Bait bait= new Bait();
		bait.setName("Nazwa");
		bait.setDescription("Opis");
		baitDao.insert(bait);
		Log.e("bait"," "+bait.getId());*/
		

		/*
		 * Regulations btn
		 */
		
		Button regulations = (Button) findViewById(R.id.regulations);
		regulations.setOnClickListener(this);
		Button weather = (Button) findViewById(R.id.weather);
		weather.setOnClickListener(this); 
		Button records = (Button) findViewById(R.id.mojeRekordyId);
		records.setOnClickListener(this);
		
	}


	@Override
	public void onClick(View v) {
    	Intent intent;
		switch(v.getId()) {
		case R.id.mojeRekordyId:
			intent= new Intent(MainActivity.this,
					 MyRecordsActivity.class);
					 startActivity(intent);	
		break;	
		case R.id.weather:
		intent= new Intent(MainActivity.this,
					 WeatherActivity.class);
					 startActivity(intent);
		break;
		case R.id.regulations:
	    intent= new Intent(MainActivity.this,
					 RegulationsActivity.class);
					 startActivity(intent);
		break;
		}
	}
}


		


