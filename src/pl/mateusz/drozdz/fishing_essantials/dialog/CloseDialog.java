package pl.mateusz.drozdz.fishing_essantials.dialog;



import pl.mateusz.drozdz.fishing_essentials.R;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class CloseDialog extends Dialog {
	
	private String message;
	private Activity activity;
		
    public CloseDialog(Activity context,String messages) {
	super(context, R.style.CloseDialog);
	this.message=messages;
	
    }
	
    public CloseDialog(Activity context,String messages,Activity a) {
	super(context, R.style.CloseDialog);
	this.message=messages;
	this.activity=a;
	
    }
    
		
    @Override
	protected void onCreate(Bundle savedInstanceState) {
	setContentView(R.layout.dialog_close);
	super.onCreate(savedInstanceState);
	Button confirm = (Button) findViewById(R.id.confirm);
	Button cancel = (Button) findViewById(R.id.cancel);
	TextView info= (TextView) findViewById(R.id.message);
	info.setText(message+"");
	
	confirm.setOnClickListener(new View.OnClickListener() {
		  
		  @Override
		  public void onClick(View v) {
			  dismiss();
			  if(activity!=null){
				  activity.finish();
			  }
		  }
		 });
	
	cancel.setOnClickListener(new View.OnClickListener() {
		  
		  @Override
		  public void onClick(View v) {
			  dismiss();
		  }
		 });
					
	}	
	
}

