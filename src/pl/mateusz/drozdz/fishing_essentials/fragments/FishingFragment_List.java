package pl.mateusz.drozdz.fishing_essentials.fragments;

import pl.mateusz.drozdz.fishing_essentials.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FishingFragment_List extends Fragment {
	
	
	public interface ChangeFragment {
		
		public void changeFragment();
	}
	
	private ChangeFragment changeFragmentListener;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_fishing_list, container,
				false);
		if (view != null) {
			Button show_form = (Button) view.findViewById(R.id.show_form);
			show_form.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					changeFragmentListener.changeFragment();
				}
			});
		}

		return view;
	}

	public void setChangeFragmentListener(ChangeFragment changeFragmentListener) {
		this.changeFragmentListener = changeFragmentListener;
	}

	
}
