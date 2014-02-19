package pl.mateusz.drozdz.fishing_essentials;

import java.io.File;

import pl.mateusz.drozdz.fishing_essentials.dao.Bait;
import pl.mateusz.drozdz.fishing_essentials.dao.BaitDao;
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
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
 
		/*
		 * BaitDao baitDao =
		 * DataBase.getInstance(this).getDaoSession().getBaitDao();
		 * 
		 * Bait bait= new Bait(); bait.setName("Nazwa");
		 * bait.setDescription("Opis"); baitDao.insert(bait);
		 * Log.e("bait"," "+bait.getId());
		 */

		Button btn = (Button) findViewById(R.id.mojeRekordyId);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent a= new Intent(MainActivity.this, PdfReaderActivity.class);
				startActivity(a);
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
