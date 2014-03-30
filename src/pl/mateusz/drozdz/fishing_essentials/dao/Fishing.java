package pl.mateusz.drozdz.fishing_essentials.dao;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table FISHING.
 */
public class Fishing {

    private Long id;
    private Long placesId;
    private java.util.Date date;
    private String weather;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient FishingDao myDao;

    private Places places;
    private Long places__resolvedKey;


    public Fishing() {
    }

    public Fishing(Long id) {
        this.id = id;
    }

    public Fishing(Long id, Long placesId, java.util.Date date, String weather) {
        this.id = id;
        this.placesId = placesId;
        this.date = date;
        this.weather = weather;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getFishingDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlacesId() {
        return placesId;
    }

    public void setPlacesId(Long placesId) {
        this.placesId = placesId;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    /** To-one relationship, resolved on first access. */
    public Places getPlaces() {
        Long __key = this.placesId;
        if (places__resolvedKey == null || !places__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PlacesDao targetDao = daoSession.getPlacesDao();
            Places placesNew = targetDao.load(__key);
            synchronized (this) {
                places = placesNew;
            	places__resolvedKey = __key;
            }
        }
        return places;
    }

    public void setPlaces(Places places) {
        synchronized (this) {
            this.places = places;
            placesId = places == null ? null : places.getId();
            places__resolvedKey = placesId;
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
