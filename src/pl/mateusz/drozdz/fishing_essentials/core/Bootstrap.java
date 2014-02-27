package pl.mateusz.drozdz.fishing_essentials.core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import pl.mateusz.drozdz.fishing_essentials.dao.CaughtFishDao;
import pl.mateusz.drozdz.fishing_essentials.dao.DaoSession;
import pl.mateusz.drozdz.fishing_essentials.dao.Fishes;
import pl.mateusz.drozdz.fishing_essentials.dao.FishesDao;
import pl.mateusz.drozdz.fishing_essentials.dao.Fishing;
import pl.mateusz.drozdz.fishing_essentials.dao.FishingDao;
import pl.mateusz.drozdz.fishing_essentials.dao.factory.FishingFactory;
import android.content.Context;

public class Bootstrap {

	private static final String csvFile = "atlas_utf8.csv";
	private Float version;
	private Context context;
	private FishesDao fishesDao;

	public Bootstrap(Context context) {
		this.context = context;
		DaoSession daoSession = DataBase.getInstance(context).getDaoSession();
		fishesDao = daoSession.getFishesDao();

	}

	public void run() {
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";
		Fishes fish;

		try {
			InputStream is = context.getAssets().open(csvFile);
			br = new BufferedReader(new InputStreamReader(is));
			fishesDao.deleteAll();
			while ((line = br.readLine()) != null) {
				String[] f = line.split(cvsSplitBy);
				System.out.println("dlugosc = " + f.length);
				System.out.println(f[0]);
				System.out.println(f[1]);
				System.out.println(f[2]);
				System.out.println(f[3]);
				System.out.println(f[4]);
				System.out.println(f[5]);
				// System.out.println(f[6]);

				fish = new Fishes();
				fish.setName(f[0]);
				fish.setType(f[1]);
				fish.setDescription(f[2]);
				fish.setFoot(f[3]);
				fish.setTips(f[4]);
				fish.setLaw(f[5]);
				if (f.length > 6) {
					fish.setPhotos(f[6]);
				}
				fishesDao.insert(fish);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	public void initDevepoData(){
		
		/*
		 * Generate fishings
		 */
		DaoSession daoSession = DataBase.getInstance(context).getDaoSession();
		FishesDao fishesDao = daoSession.getFishesDao(); // atlas ryb
		FishingDao fishingDao = daoSession.getFishingDao(); // moje po³owy
		CaughtFishDao aughtFishDao = daoSession.getCaughtFishDao(); // z³apane ryby
		
		FishingFactory fishingFactory = new FishingFactory(context);
		fishingFactory.setPlacesName("Wis³a");
		fishingFactory.setPlacesDescription("Pod drzewem na zakrêcie");
		fishingFactory.setWeather("£adnie");
		Fishing fishing = fishingFactory.getFishing();
		
		fishingDao.insert(fishing);
		
		
		
		// test
		List<Fishing> fishingest = fishingDao.queryBuilder().list();
		for (Fishing f : fishingest) {
			System.out.println(f.getPlaces().getName()+" "+f.getPlaces().getDescription()+" "+f.getWeather());
		}
		
		
	}



}
