package pl.mateusz.drozdz.fishing_essentials;


import pl.mateusz.drozdz.fishing_essantials.dialog.CloseDialog;
import pl.mateusz.drozdz.fishing_essentials.core.Bootstrap;
import android.os.Bundle;
import android.app.Activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements OnClickListener {

	private Bootstrap bootsrap;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
<<<<<<< HEAD
=======
		// load data from file
		bootsrap = new Bootstrap(this);
		bootsrap.run();
		//bootsrap.initDevepoData();

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

		
>>>>>>> 2e93ccc4da8ff9c00c9ba69de956a1b7e2f50425
/*		BaitDao baitDao = DataBase.getInstance(this).getDaoSession().getBaitDao();
		
		Bait bait= new Bait();
		bait.setName("Nazwa");
		bait.setDescription("Opis");
		baitDao.insert(bait);
		Log.e("bait"," "+bait.getId());*/
<<<<<<< HEAD
=======
		

		/*
		 * Regulations btn
		 */
>>>>>>> 2e93ccc4da8ff9c00c9ba69de956a1b7e2f50425
		
		
		RelativeLayout regulations = (RelativeLayout) findViewById(R.id.regulations);
		regulations.setOnClickListener(this);
		RelativeLayout fishing = (RelativeLayout) findViewById(R.id.fishing);
		fishing.setOnClickListener(this);
		RelativeLayout weather = (RelativeLayout) findViewById(R.id.weather);
		weather.setOnClickListener(this); 
		RelativeLayout records = (RelativeLayout) findViewById(R.id.mojeRekordyId);
		records.setOnClickListener(this);
		RelativeLayout fishes = (RelativeLayout) findViewById(R.id.fishes);
		fishes.setOnClickListener(this);
		RelativeLayout close = (RelativeLayout) findViewById(R.id.closeId);
		close.setOnClickListener(this);
		
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
		case R.id.fishing:
			intent= new Intent(MainActivity.this,
					 FishingActivity.class);
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
		case R.id.fishes:
			System.out.println("click");
		    intent= new Intent(MainActivity.this,
						 FishesActivity.class);
						 startActivity(intent);
			break;
		case R.id.closeId:
			CloseDialog dialog = new CloseDialog(
					MainActivity.this, "Czy na pewno chcesz zamkna� aplikacj�?",MainActivity.this);
			dialog.show();
			
	    break;	
		}
	}
}


		


