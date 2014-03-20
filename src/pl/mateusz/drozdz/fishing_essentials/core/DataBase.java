package pl.mateusz.drozdz.fishing_essentials.core;

import pl.mateusz.drozdz.fishing_essentials.dao.DaoMaster;
import pl.mateusz.drozdz.fishing_essentials.dao.DaoMaster.DevOpenHelper;
import pl.mateusz.drozdz.fishing_essentials.dao.DaoSession;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public final class DataBase {

    // nale¿y zwróciæ uwagê na u¿ycie s³owa kluczowego volatile
    private static volatile DataBase instance = null;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private DevOpenHelper helper;
    
 
    public static DataBase getInstance(Context context) {
        if (instance == null) {
            synchronized (DataBase.class) {
                if (instance == null) {
                    instance = new DataBase(context);
                }
            }
        }
        return instance;
    }
 

    private DataBase(Context context) {
    	Property.setContext(context);
    	helper = new DaoMaster.DevOpenHelper(context, Property.DB_NAME, null);
    	db = helper.getWritableDatabase();
    	daoMaster= new DaoMaster(db);
    	daoSession= daoMaster.newSession();
    }


	public DaoSession getDaoSession() {
		return daoSession;
	}

    
}
