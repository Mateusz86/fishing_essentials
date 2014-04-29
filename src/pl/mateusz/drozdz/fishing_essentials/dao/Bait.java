package pl.mateusz.drozdz.fishing_essentials.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table BAIT.
 */
public class Bait {

    private Long id;
    /** Not-null value. */
    private String name;
    private String description;

    public Bait() {
    }

    public Bait(Long id) {
        this.id = id;
    }

    public Bait(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
	public String toString() {
		return name;
	}

}
