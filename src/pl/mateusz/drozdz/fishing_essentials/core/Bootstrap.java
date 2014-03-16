package pl.mateusz.drozdz.fishing_essentials.core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;


import pl.mateusz.drozdz.fishing_essentials.dao.Bait;
import pl.mateusz.drozdz.fishing_essentials.dao.BaitDao;
import pl.mateusz.drozdz.fishing_essentials.dao.CaughtFish;
import pl.mateusz.drozdz.fishing_essentials.dao.CaughtFishDao;
import pl.mateusz.drozdz.fishing_essentials.dao.DaoSession;
import pl.mateusz.drozdz.fishing_essentials.dao.Fishes;
import pl.mateusz.drozdz.fishing_essentials.dao.FishesDao;
import pl.mateusz.drozdz.fishing_essentials.dao.Fishing;
import pl.mateusz.drozdz.fishing_essentials.dao.FishingDao;
import pl.mateusz.drozdz.fishing_essentials.dao.GroundBait;
import pl.mateusz.drozdz.fishing_essentials.dao.GroundBaitDao;
import pl.mateusz.drozdz.fishing_essentials.dao.Methods;
import pl.mateusz.drozdz.fishing_essentials.dao.MethodsDao;
import pl.mateusz.drozdz.fishing_essentials.dao.Places;
import pl.mateusz.drozdz.fishing_essentials.dao.PlacesDao;
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
		
		PlacesDao placesDao = daoSession.getPlacesDao();
		placesDao.deleteAll();
		Places places, places1 = null;
		
		places = new Places();
		places.setName("Wis³a");
		places.setDescription("Pod mostem");
		places.setLatitude("50.052649");
		places.setLongitude("19.998777");
		places.setDate(new Date());
		placesDao.insert(places);
		
		places = new Places();
		places.setName("wis³a1");
		places.setDescription("Ko³o drogi");
		places.setLatitude("51.052649");
		places.setLongitude("19.998777");
		places.setDate(new Date());
		placesDao.insert(places);
		
		places = new Places();
		places.setName("Wis³a2");
		places.setDescription("Pod wawelem");
		places.setLatitude("50.052649");
		places.setLongitude("18.098777");
		places.setDate(new Date());
		placesDao.insert(places);
		
		places1 = new Places();
		places1.setName("Przylasek Rusiecki");
		places1.setDescription("Staw nr 15");
		places1.setLatitude("50.054895");
		places1.setLongitude("20.156825");
		places1.setDate(new Date());
		placesDao.insert(places1);
		
		
		BaitDao baitDao = daoSession.getBaitDao();
		baitDao.deleteAll();
		Bait bait = new Bait();
		bait.setName("Kukurydza");
		bait.setDescription("Lorem impsum");
		baitDao.insert(bait);
		
		Bait bait1 = new Bait();
		bait1.setName("Wobler");
		bait1.setDescription("Lorem impsum");
		baitDao.insert(bait1);
		
		GroundBaitDao groundBaitDao = daoSession.getGroundBaitDao();
		groundBaitDao.deleteAll();
		GroundBait groundBait = new GroundBait();
		groundBait.setName("Kasza");
		groundBait.setDescription("Lorem Impsum");
		groundBaitDao.insert(groundBait);
		
		MethodsDao methodsDao = daoSession.getMethodsDao();
		methodsDao.deleteAll();
		Methods methods = new Methods();
		methods.setName("Na gund");
		methodsDao.insert(methods);
		
		Methods methods1 = new Methods();
		methods1.setName("Spining");
		methodsDao.insert(methods1);
		
		
		FishingDao fishingDao = daoSession.getFishingDao(); // moje po³owy
		fishingDao.deleteAll();
		Fishing fishing =  new Fishing();
		fishing.setPlaces(places);
		fishing.setWeather("Pogodnie");
		fishing.setDate(new Date());
		fishingDao.insert(fishing);
		
		Fishing fishing1 =  new Fishing();
		fishing1.setPlaces(places1);
		fishing1.setWeather("Pochmurnie");
		fishing1.setDate(new Date());
		fishingDao.insert(fishing1);
		
		FishesDao fishesDao = daoSession.getFishesDao(); // atlas ryb
		
		Fishes fishes1 = fishesDao.loadByRowId(5);
		Fishes fishes2 = fishesDao.loadByRowId(6);
		Fishes fishes3 = fishesDao.loadByRowId(2);
		
		CaughtFishDao caughtFishDao = daoSession.getCaughtFishDao();
		caughtFishDao.deleteAll();
		CaughtFish ryba1 = new CaughtFish();
		ryba1.setFishes(fishes1);
		ryba1.setFishing(fishing);
		ryba1.setFishLength(15);
		ryba1.setWeight(0.5);
		ryba1.setBait(bait);
		ryba1.setGroundBait(groundBait);
		ryba1.setMethods(methods);
		ryba1.setDate(new Date());
		ryba1.setPhotos("pobrane.jpg");
		caughtFishDao.insert(ryba1);
		
		CaughtFish ryba2 = new CaughtFish();
		ryba2.setFishes(fishes2);
		ryba2.setFishing(fishing);
		ryba2.setFishLength(35);
		ryba2.setWeight(1.5);
		ryba2.setBait(bait1);
		ryba2.setMethods(methods1);
		ryba2.setDate(new Date());
		ryba2.setPhotos("images.jpg");
		caughtFishDao.insert(ryba2);
		
		CaughtFish ryba3 = new CaughtFish();
		ryba3.setFishes(fishes3);
		ryba3.setFishing(fishing1);
		ryba3.setFishLength(35);
		ryba3.setWeight(1.15);
		ryba3.setBait(bait);
		ryba3.setDate(new Date());
		ryba3.setPhotos("pobrane.jpg");
		caughtFishDao.insert(ryba3);
		
		ryba3 = new CaughtFish();
		ryba3.setFishes(fishes3);
		ryba3.setFishing(fishing1);
		ryba3.setFishLength(50);
		ryba3.setWeight(1.35);
		ryba3.setBait(bait);
		ryba3.setDate(new Date());
		ryba3.setPhotos("pobrane.jpg");
		caughtFishDao.insert(ryba3);
		
		ryba3 = new CaughtFish();
		ryba3.setFishes(fishes3);
		ryba3.setFishing(fishing1);
		ryba3.setFishLength(19);
		ryba3.setWeight(1.01);
		ryba3.setBait(bait);
		ryba3.setDate(new Date());
		ryba3.setPhotos("pobrane.jpg");
		caughtFishDao.insert(ryba3);
		

		
	}



}
