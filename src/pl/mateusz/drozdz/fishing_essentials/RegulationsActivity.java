package pl.mateusz.drozdz.fishing_essentials;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class RegulationsActivity extends Activity implements View.OnClickListener{
    
	private static final String[] htmlFiles= {"rapr.html"};
    private int i;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regulations);

		findViewById(R.id.regulations_rapr).setOnClickListener(this);
		findViewById(R.id.regulations_pw).setOnClickListener(this);
		findViewById(R.id.regulations_rapr_sea).setOnClickListener(this);
		findViewById(R.id.regulations_uor).setOnClickListener(this);
	
		
	}

	private void startHtmlView(String fileName){
		Intent intent = new Intent(this, HtmlViewActivity.class);
		intent.putExtra("fileName", fileName);
		startActivity(intent);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.regulations_rapr:
			startHtmlView("rapr.html");
		case R.id.regulations_pw:
			startHtmlView("prawo_wodne.html");
		case R.id.regulations_uor:
			startHtmlView("ustawa_o_rybactwie.html");
		case R.id.regulations_rapr_sea:
			startHtmlView("rapr_na_morzu.html");
		}
		
	}
	
	
}
