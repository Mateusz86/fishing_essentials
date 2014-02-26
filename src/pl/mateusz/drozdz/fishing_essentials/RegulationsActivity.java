package pl.mateusz.drozdz.fishing_essentials;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class RegulationsActivity extends Activity{
    
	private static final String[] htmlFiles= {"rapr.html"};
    private int i;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regulations);

		Button button = (Button) findViewById(R.id.rapr);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startHtmlView("rapr.html");
			}
		});
	}

	private void startHtmlView(String fileName){
		Intent intent = new Intent(this, HtmlViewActivity.class);
		intent.putExtra("fileName", fileName);
		startActivity(intent);
	}
}
