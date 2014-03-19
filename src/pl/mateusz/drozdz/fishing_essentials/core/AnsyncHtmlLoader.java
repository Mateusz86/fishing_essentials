package pl.mateusz.drozdz.fishing_essentials.core;

import pl.mateusz.drozdz.fishing_essentials.R;
import android.app.Activity;
import android.os.AsyncTask;
import android.view.View;
import android.webkit.WebView;

public class AnsyncHtmlLoader extends AsyncTask<String, Void, Void> {
	
	private Activity activity;
	
	

	public AnsyncHtmlLoader(Activity activity) {
		this.activity = activity;
	}

	@Override
	protected Void doInBackground(String... params) {
		WebView webView = (WebView) activity.findViewById(R.id.htmlView);
		webView.loadUrl("file:///android_asset/regulations/"+params[0]);
		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
//		super.onPostExecute(result);
		activity.findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
	}

	@Override
	protected void onPreExecute() {
//		super.onPreExecute();
		activity.findViewById(R.id.progressBar).setVisibility(View.GONE);
	}
	
	

}
