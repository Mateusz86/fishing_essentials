package pl.mateusz.drozdz.fishing_essentials.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table PHOTOS.
 */
public class Photos {

    private Long id;
    /** Not-null value. */
    private String photos;
    private java.util.Date date;
    private Long methodsId;
    private Long fishesId;

    public Photos() {
    }

    public Photos(Long id) {
        this.id = id;
    }

    public Photos(Long id, String photos, java.util.Date date, Long methodsId, Long fishesId) {
        this.id = id;
        this.photos = photos;
        this.date = date;
        this.methodsId = methodsId;
        this.fishesId = fishesId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getPhotos() {
        return photos;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public Long getMethodsId() {
        return methodsId;
    }

    public void setMethodsId(Long methodsId) {
        this.methodsId = methodsId;
    }

    public Long getFishesId() {
        return fishesId;
    }

    public void setFishesId(Long fishesId) {
        this.fishesId = fishesId;
    }

}
