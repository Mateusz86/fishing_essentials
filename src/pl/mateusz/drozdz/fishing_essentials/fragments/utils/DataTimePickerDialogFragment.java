package pl.mateusz.drozdz.fishing_essentials.fragments.utils;

import pl.mateusz.drozdz.fishing_essentials.R;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

public class DataTimePickerDialogFragment extends DialogFragment  {
	
	private Context context;
	private DialogFragment fragment;
	
//	public intarface Set
	
	public DataTimePickerDialogFragment(){
		this.context= getActivity();
		this.fragment= this;
		
	}
	
	static DataTimePickerDialogFragment newInstance(){
		
		DataTimePickerDialogFragment f = new DataTimePickerDialogFragment();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("num", 1);
        f.setArguments(args);

        return f;
	}
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	     super.onCreate(savedInstanceState); 
		 setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Holo_Dialog);
	    }
	 
	 @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,
             Bundle savedInstanceState) {
         View v = inflater.inflate(R.layout.dialog_datatime, container, false);
         DatePicker  datePicker = (DatePicker) v.findViewById(R.id.date_picker);
         TimePicker  timePicker = (TimePicker) v.findViewById(R.id.time_picker);
         Button okButton = (Button) v.findViewById(R.id.DateTime_confirm);
         Button cancelButton = (Button) v.findViewById(R.id.DateTime_cancel);
         
         cancelButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				FragmentTransaction transaction = getFragmentManager().beginTransaction();
				
				transaction.remove(fragment);
				transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
				transaction.commit();
				
			}
		});

         return v;
     }
}
		