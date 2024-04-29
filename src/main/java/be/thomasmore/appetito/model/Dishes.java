package be.thomasmore.appetito.model;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
public class Dishes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String image;

    private String dietPreferences;

    private Date preparationTime;

    private Integer calories;

    private String occasion;

    private String imgFileName;

    @Length(max=10000)
    private String preparation;

    @ManyToMany
    private Collection<Nutritions> nutritionsValue;

    public Dishes() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getDietPreferences() {
        return dietPreferences;
    }

    public void setDietPreferences(String dietPreferences) {
        this.dietPreferences = dietPreferences;
    }

    public Date getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Date preparationTime) {
        this.preparationTime = preparationTime;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    public String getImgFileName() {
        return imgFileName;
    }

    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }
}
