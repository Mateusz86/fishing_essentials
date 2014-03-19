package pl.mateusz.drozdz.fishing_essentials.dao;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table CAUGHT_FISH.
 */
public class CaughtFish {

    private Long id;
    private Integer fishLength;
    private Double weight;
    private Long fishingId;
    private Long fishesId;
    private Long baitId;
    private Long groundBaitId;
    private Long methodsBaitId;
    private java.util.Date date;
    private String photos;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient CaughtFishDao myDao;

    private Fishing fishing;
    private Long fishing__resolvedKey;

    private Fishes fishes;
    private Long fishes__resolvedKey;

    private Bait bait;
    private Long bait__resolvedKey;

    private GroundBait groundBait;
    private Long groundBait__resolvedKey;

    private Methods methods;
    private Long methods__resolvedKey;


    public CaughtFish() {
    }

    public CaughtFish(Long id) {
        this.id = id;
    }

    public CaughtFish(Long id, Integer fishLength, Double weight, Long fishingId, Long fishesId, Long baitId, Long groundBaitId, Long methodsBaitId, java.util.Date date, String photos) {
        this.id = id;
        this.fishLength = fishLength;
        this.weight = weight;
        this.fishingId = fishingId;
        this.fishesId = fishesId;
        this.baitId = baitId;
        this.groundBaitId = groundBaitId;
        this.methodsBaitId = methodsBaitId;
        this.date = date;
        this.photos = photos;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCaughtFishDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFishLength() {
        return fishLength;
    }

    public void setFishLength(Integer fishLength) {
        this.fishLength = fishLength;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Long getFishingId() {
        return fishingId;
    }

    public void setFishingId(Long fishingId) {
        this.fishingId = fishingId;
    }

    public Long getFishesId() {
        return fishesId;
    }

    public void setFishesId(Long fishesId) {
        this.fishesId = fishesId;
    }

    public Long getBaitId() {
        return baitId;
    }

    public void setBaitId(Long baitId) {
        this.baitId = baitId;
    }

    public Long getGroundBaitId() {
        return groundBaitId;
    }

    public void setGroundBaitId(Long groundBaitId) {
        this.groundBaitId = groundBaitId;
    }

    public Long getMethodsBaitId() {
        return methodsBaitId;
    }

    public void setMethodsBaitId(Long methodsBaitId) {
        this.methodsBaitId = methodsBaitId;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    /** To-one relationship, resolved on first access. */
    public Fishing getFishing() {
        Long __key = this.fishingId;
        if (fishing__resolvedKey == null || !fishing__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            FishingDao targetDao = daoSession.getFishingDao();
            Fishing fishingNew = targetDao.load(__key);
            synchronized (this) {
                fishing = fishingNew;
            	fishing__resolvedKey = __key;
            }
        }
        return fishing;
    }

    public void setFishing(Fishing fishing) {
        synchronized (this) {
            this.fishing = fishing;
            fishingId = fishing == null ? null : fishing.getId();
            fishing__resolvedKey = fishingId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public Fishes getFishes() {
        Long __key = this.fishesId;
        if (fishes__resolvedKey == null || !fishes__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            FishesDao targetDao = daoSession.getFishesDao();
            Fishes fishesNew = targetDao.load(__key);
            synchronized (this) {
                fishes = fishesNew;
            	fishes__resolvedKey = __key;
            }
        }
        return fishes;
    }

    public void setFishes(Fishes fishes) {
        synchronized (this) {
            this.fishes = fishes;
            fishesId = fishes == null ? null : fishes.getId();
            fishes__resolvedKey = fishesId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public Bait getBait() {
        Long __key = this.baitId;
        if (bait__resolvedKey == null || !bait__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BaitDao targetDao = daoSession.getBaitDao();
            Bait baitNew = targetDao.load(__key);
            synchronized (this) {
                bait = baitNew;
            	bait__resolvedKey = __key;
            }
        }
        return bait;
    }

    public void setBait(Bait bait) {
        synchronized (this) {
            this.bait = bait;
            baitId = bait == null ? null : bait.getId();
            bait__resolvedKey = baitId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public GroundBait getGroundBait() {
        Long __key = this.groundBaitId;
        if (groundBait__resolvedKey == null || !groundBait__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            GroundBaitDao targetDao = daoSession.getGroundBaitDao();
            GroundBait groundBaitNew = targetDao.load(__key);
            synchronized (this) {
                groundBait = groundBaitNew;
            	groundBait__resolvedKey = __key;
            }
        }
        return groundBait;
    }

    public void setGroundBait(GroundBait groundBait) {
        synchronized (this) {
            this.groundBait = groundBait;
            groundBaitId = groundBait == null ? null : groundBait.getId();
            groundBait__resolvedKey = groundBaitId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public Methods getMethods() {
        Long __key = this.methodsBaitId;
        if (methods__resolvedKey == null || !methods__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MethodsDao targetDao = daoSession.getMethodsDao();
            Methods methodsNew = targetDao.load(__key);
            synchronized (this) {
                methods = methodsNew;
            	methods__resolvedKey = __key;
            }
        }
        return methods;
    }

    public void setMethods(Methods methods) {
        synchronized (this) {
            this.methods = methods;
            methodsBaitId = methods == null ? null : methods.getId();
            methods__resolvedKey = methodsBaitId;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
