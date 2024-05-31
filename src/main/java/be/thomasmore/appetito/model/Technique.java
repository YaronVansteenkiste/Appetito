package be.thomasmore.appetito.model;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

@Entity
public class Technique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Length(max = 1000)
    private String techniqueDescription;

    private String name;

    private String image;

    @ManyToOne
    private Basic basic;

    public Technique() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTechniqueDescription() {
        return techniqueDescription;
    }

    public void setTechniqueDescription(String techniqueDescription) {
        this.techniqueDescription = techniqueDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Basic getBasic() {
        return basic;
    }

    public void setBasic(Basic basic) {
        this.basic = basic;
    }
}
