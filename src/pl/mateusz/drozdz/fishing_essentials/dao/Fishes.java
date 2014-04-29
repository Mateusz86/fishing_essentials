package pl.mateusz.drozdz.fishing_essentials.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table FISHES.
 */
public class Fishes {

    private Long id;
    /** Not-null value. */
    private String name;
    private String type;
    private String description;
    private String foot;
    private String tips;
    private String law;
    private String photos;

    public Fishes() {
    }

    public Fishes(Long id) {
        this.id = id;
    }

    public Fishes(Long id, String name, String type, String description, String foot, String tips, String law, String photos) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.foot = foot;
        this.tips = tips;
        this.law = law;
        this.photos = photos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getName() {
        return name;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getLaw() {
        return law;
    }

    public void setLaw(String law) {
        this.law = law;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    @Override
    public String toString(){
    	return name;
    }
}
