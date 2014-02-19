package pl.mateusz.drozdz.fishing_essentials;



import net.sf.andpdf.pdfviewer.PdfViewerActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class PdfReaderActivity extends Activity {

	public int getPreviousPageImageResource() { return R.drawable.left_arrow; }
    public int getNextPageImageResource() { return R.drawable.right_arrow; }
    public int getZoomInImageResource() { return R.drawable.zoom_in; }
    public int getZoomOutImageResource() { return R.drawable.zoom_out; }
    public int getPdfPasswordLayoutResource() { return R.layout.pdf_file_password; }
    public int getPdfPageNumberResource() { return R.layout.dialog_pagenumber; }
    public int getPdfPasswordEditField() { return R.id.etPassword; }
    public int getPdfPasswordOkButton() { return R.id.btOK; }
    public int getPdfPasswordExitButton() { return R.id.btExit; }
    public int getPdfPageNumberEditField() { return R.id.pagenum_edit; }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pdfreader);
		
		Intent intent = new Intent(this, PdfViewerActivity.class);
	     intent.putExtra("Regulamin", "file:///android_asset/pdfviewer/regulamin_amatorskiego_polowu_ryb.pdf");
	     startActivity(intent);
		
//		webView = (WebView) findViewById(R.id.webview);
//		WebSettings settings = webView.getSettings();
//		settings.setJavaScriptEnabled(true);
////		crash on tablet and unnecessary?
////		settings.setAllowFileAccessFromFileURLs(true);
////		settings.setAllowUniversalAccessFromFileURLs(true);
//		settings.setBuiltInZoomControls(true);
//		webView.setWebChromeClient(new WebChromeClient());
//		webView.loadUrl("file:///android_asset/pdfviewer/index.html");
	
	}


}
