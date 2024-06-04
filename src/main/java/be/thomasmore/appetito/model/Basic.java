package be.thomasmore.appetito.model;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.util.Collection;

@Entity
public class Basic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String action;

    private String description;

    private String image;

    @OneToMany(mappedBy = "basic")
    Collection<Technique> techniques;

    public Basic() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public Collection<Technique> getTechniques() {
        return techniques;
    }

    public void setTechniques(Collection<Technique> techniques) {
        this.techniques = techniques;
    }

    public void setImgFileName(String uploadImage) {
    }
}
