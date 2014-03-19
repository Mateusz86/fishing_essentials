package pl.mateusz.drozdz.fishing_essentials.dao;

import pl.mateusz.drozdz.fishing_essentials.dao.CaughtFish;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table CAUGHT_FISH.
*/
public class CaughtFishDao extends AbstractDao<CaughtFish, Long> {

    public static final String TABLENAME = "CAUGHT_FISH";

    /**
     * Properties of entity CaughtFish.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property FishLength = new Property(1, Integer.class, "fishLength", false, "FISH_LENGTH");
        public final static Property Weight = new Property(2, Double.class, "weight", false, "WEIGHT");
        public final static Property FishingId = new Property(3, Long.class, "fishingId", false, "FISHING_ID");
        public final static Property FishesId = new Property(4, Long.class, "fishesId", false, "FISHES_ID");
        public final static Property BaitId = new Property(5, Long.class, "baitId", false, "BAIT_ID");
        public final static Property GroundBaitId = new Property(6, Long.class, "groundBaitId", false, "GROUND_BAIT_ID");
        public final static Property MethodsBaitId = new Property(7, Long.class, "methodsBaitId", false, "METHODS_BAIT_ID");
        public final static Property Date = new Property(8, java.util.Date.class, "date", false, "DATE");
        public final static Property Photos = new Property(9, String.class, "photos", false, "PHOTOS");
    };

    private DaoSession daoSession;


    public CaughtFishDao(DaoConfig config) {
        super(config);
    }
    
    public CaughtFishDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'CAUGHT_FISH' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'FISH_LENGTH' INTEGER," + // 1: fishLength
                "'WEIGHT' REAL," + // 2: weight
                "'FISHING_ID' INTEGER," + // 3: fishingId
                "'FISHES_ID' INTEGER," + // 4: fishesId
                "'BAIT_ID' INTEGER," + // 5: baitId
                "'GROUND_BAIT_ID' INTEGER," + // 6: groundBaitId
                "'METHODS_BAIT_ID' INTEGER," + // 7: methodsBaitId
                "'DATE' INTEGER," + // 8: date
                "'PHOTOS' TEXT);"); // 9: photos
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'CAUGHT_FISH'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, CaughtFish entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Integer fishLength = entity.getFishLength();
        if (fishLength != null) {
            stmt.bindLong(2, fishLength);
        }
 
        Double weight = entity.getWeight();
        if (weight != null) {
            stmt.bindDouble(3, weight);
        }
 
        Long fishingId = entity.getFishingId();
        if (fishingId != null) {
            stmt.bindLong(4, fishingId);
        }
 
        Long fishesId = entity.getFishesId();
        if (fishesId != null) {
            stmt.bindLong(5, fishesId);
        }
 
        Long baitId = entity.getBaitId();
        if (baitId != null) {
            stmt.bindLong(6, baitId);
        }
 
        Long groundBaitId = entity.getGroundBaitId();
        if (groundBaitId != null) {
            stmt.bindLong(7, groundBaitId);
        }
 
        Long methodsBaitId = entity.getMethodsBaitId();
        if (methodsBaitId != null) {
            stmt.bindLong(8, methodsBaitId);
        }
 
        java.util.Date date = entity.getDate();
        if (date != null) {
            stmt.bindLong(9, date.getTime());
        }
 
        String photos = entity.getPhotos();
        if (photos != null) {
            stmt.bindString(10, photos);
        }
    }

    @Override
    protected void attachEntity(CaughtFish entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public CaughtFish readEntity(Cursor cursor, int offset) {
        CaughtFish entity = new CaughtFish( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // fishLength
            cursor.isNull(offset + 2) ? null : cursor.getDouble(offset + 2), // weight
            cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3), // fishingId
            cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4), // fishesId
            cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5), // baitId
            cursor.isNull(offset + 6) ? null : cursor.getLong(offset + 6), // groundBaitId
            cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7), // methodsBaitId
            cursor.isNull(offset + 8) ? null : new java.util.Date(cursor.getLong(offset + 8)), // date
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9) // photos
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, CaughtFish entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setFishLength(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setWeight(cursor.isNull(offset + 2) ? null : cursor.getDouble(offset + 2));
        entity.setFishingId(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
        entity.setFishesId(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
        entity.setBaitId(cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5));
        entity.setGroundBaitId(cursor.isNull(offset + 6) ? null : cursor.getLong(offset + 6));
        entity.setMethodsBaitId(cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7));
        entity.setDate(cursor.isNull(offset + 8) ? null : new java.util.Date(cursor.getLong(offset + 8)));
        entity.setPhotos(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(CaughtFish entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(CaughtFish entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getFishingDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getFishesDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T2", daoSession.getBaitDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T3", daoSession.getGroundBaitDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T4", daoSession.getMethodsDao().getAllColumns());
            builder.append(" FROM CAUGHT_FISH T");
            builder.append(" LEFT JOIN FISHING T0 ON T.'FISHING_ID'=T0.'_id'");
            builder.append(" LEFT JOIN FISHES T1 ON T.'FISHES_ID'=T1.'_id'");
            builder.append(" LEFT JOIN BAIT T2 ON T.'BAIT_ID'=T2.'_id'");
            builder.append(" LEFT JOIN GROUND_BAIT T3 ON T.'GROUND_BAIT_ID'=T3.'_id'");
            builder.append(" LEFT JOIN METHODS T4 ON T.'METHODS_BAIT_ID'=T4.'_id'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected CaughtFish loadCurrentDeep(Cursor cursor, boolean lock) {
        CaughtFish entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Fishing fishing = loadCurrentOther(daoSession.getFishingDao(), cursor, offset);
        entity.setFishing(fishing);
        offset += daoSession.getFishingDao().getAllColumns().length;

        Fishes fishes = loadCurrentOther(daoSession.getFishesDao(), cursor, offset);
        entity.setFishes(fishes);
        offset += daoSession.getFishesDao().getAllColumns().length;

        Bait bait = loadCurrentOther(daoSession.getBaitDao(), cursor, offset);
        entity.setBait(bait);
        offset += daoSession.getBaitDao().getAllColumns().length;

        GroundBait groundBait = loadCurrentOther(daoSession.getGroundBaitDao(), cursor, offset);
        entity.setGroundBait(groundBait);
        offset += daoSession.getGroundBaitDao().getAllColumns().length;

        Methods methods = loadCurrentOther(daoSession.getMethodsDao(), cursor, offset);
        entity.setMethods(methods);

        return entity;    
    }

    public CaughtFish loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<CaughtFish> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<CaughtFish> list = new ArrayList<CaughtFish>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<CaughtFish> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<CaughtFish> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
