package pl.mateusz.drozdz.fishing_essentials;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class HtmlViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_htmlview);
		
		Bundle bundle = getIntent().getExtras();
		String fileName= bundle.getString("fileName");

		WebView webView = (WebView) findViewById(R.id.htmlView);
		webView.loadUrl("file:///android_asset/regulations/"+fileName);

	}
}
