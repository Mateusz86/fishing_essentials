package pl.mateusz.drozdz.fishing_essentials.dao.factory;

import android.content.Context;
import pl.mateusz.drozdz.fishing_essentials.core.DataBase;
import pl.mateusz.drozdz.fishing_essentials.dao.DaoSession;
import pl.mateusz.drozdz.fishing_essentials.dao.Fishing;
import pl.mateusz.drozdz.fishing_essentials.dao.Places;
import pl.mateusz.drozdz.fishing_essentials.dao.PlacesDao;

public class FishingFactory extends Fishing{

	private DaoSession daoSession;
	private Places places;

	public FishingFactory(Context context) {
		super();
		daoSession = DataBase.getInstance(context).getDaoSession();
		places = new Places();
	}

	public void setPlacesName(String placesName) {
		PlacesDao placesDao = daoSession.getPlacesDao();
		places.setName(placesName);
		super.setPlaces(places);
	}
	public void setPlacesDescription(String placesDescription) {
		PlacesDao placesDao = daoSession.getPlacesDao();
		places.setName(placesDescription);
		super.setPlaces(places);
	}

	public Fishing getFishing(){
		return (Fishing) this;
	}

}
