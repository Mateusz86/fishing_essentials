package pl.mateusz.drozdz.fishing_essentials.fragments;

import java.io.IOException;
import java.io.InputStream;

import pl.mateusz.drozdz.fishing_essentials.FishesActivity;
import pl.mateusz.drozdz.fishing_essentials.R;
import pl.mateusz.drozdz.fishing_essentials.core.DataBase;
import pl.mateusz.drozdz.fishing_essentials.dao.Fishes;
import pl.mateusz.drozdz.fishing_essentials.dao.FishesDao;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

public class FishesFragment_View extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_fishes_view, container,
				false);
		if (view != null) {

			Bundle args = getArguments();
			Long pk = args.getLong(FishesActivity.ARG_PK);
			System.out.println("Wybrane pk " + pk);
			FishesDao fishesDao = DataBase.getInstance(getActivity())
					.getDaoSession().getFishesDao();
			Fishes fish = fishesDao.loadByRowId(pk);
			if (fish != null) {
				{
					TextView name = (TextView) view
							.findViewById(R.id.fish_view_name);
					name.setText(fish.getName());
				}
				{
					TextView description = (TextView) view
							.findViewById(R.id.fish_view_description);
					description.setText(fish.getDescription());
				}
				{
					TextView wystepowanie = (TextView) view
							.findViewById(R.id.fish_view_wystepowanie);
					wystepowanie.setText(fish.getLaw());
				}
				{
					TextView food = (TextView) view
							.findViewById(R.id.fish_view_food);
					food.setText(fish.getFoot());
				}
				{
					TextView tips = (TextView) view
							.findViewById(R.id.fish_view_tips);
					tips.setText(fish.getTips());
				}
				
				InputStream ims;
				try {
					String[] f = fish.getPhotos().split("#");
					if(f.length >=1){
						ims = getActivity().getAssets().open("fishes/"+f[0]);
					    Drawable d = Drawable.createFromStream(ims, null);
					    ImageView main_photo = (ImageView) view.findViewById(R.id.fish_view_main_photp);
					    main_photo.setImageDrawable(d);
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	            
	            
				// WebView fish_content = (WebView)
				// view.findViewById(R.id.fish_content);
				// String content =
				// "<h1>Opis</h1><article>"+fish.getDescription()+"</article>"
				// +"<h2>Po¿ywienie</h2><article>"+fish.getFoot()+"</article>"
				// +"<h2>Wystêpowanie</h2><article>"+fish.getLaw()+"</article>"
				// +"<h2>Porady</h2><article>"+fish.getTips()+"</article>";
				// fish_content.loadData(content, "text/html", null);
			}
		}
		return view;
	}

}
