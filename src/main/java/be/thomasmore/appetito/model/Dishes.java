package be.thomasmore.appetito.model;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

import java.sql.Time;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
public class Dishes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Length(max=10000)
    private String ingredients;
    private String dietPreferences;

    @Temporal(TemporalType.TIME)
    private Time preparationTime;
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

    public String getDietPreferences() {
        return dietPreferences;
    }

    public void setDietPreferences(String dietPreferences) {
        this.dietPreferences = dietPreferences;
    }

    public Time getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Time preparationTime) {
        this.preparationTime = preparationTime;
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
    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Collection<Nutritions> getNutritionsValue() {
        return nutritionsValue;
    }

    public void setNutritionsValue(Collection<Nutritions> nutritionsValue) {
        this.nutritionsValue = nutritionsValue;
    }
}
