package pl.mateusz.drozdz.fishing_essentials.core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import pl.mateusz.drozdz.fishing_essentials.dao.DaoSession;
import pl.mateusz.drozdz.fishing_essentials.dao.Fishes;
import pl.mateusz.drozdz.fishing_essentials.dao.FishesDao;
import android.content.Context;
import android.util.Log;

public class Bootstrap {

	private static final String csvFile = "atlas_utf8.csv";
	private Float version;
	private Context context;
	private FishesDao fishesDao;

	public Bootstrap(Context context) {
		this.context = context;
		DaoSession daoSession =DataBase.getInstance(context).getDaoSession();
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
				fish= new Fishes();
				fish.setName(f[0]);
				fish.setType(f[1]);
				fish.setDescription(f[2]);
				fish.setFoot(f[3]);
				fish.setTips(f[4]);
				fish.setLaw(f[5]);
				fish.setPhotos(f[6]);
//				f[6]- photos
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

}
