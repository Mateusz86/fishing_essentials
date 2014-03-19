package pl.mateusz.drozdz.fishing_essentials;

import pl.mateusz.drozdz.fishing_essentials.core.AnsyncHtmlLoader;

public class HtmlViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_htmlview);
		
		Bundle bundle = getIntent().getExtras();
		String fileName= bundle.getString("fileName");

		AnsyncHtmlLoader ahl = new AnsyncHtmlLoader(this);
		ahl.execute(fileName);

	}
}
