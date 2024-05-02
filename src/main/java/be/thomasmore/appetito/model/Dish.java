package be.thomasmore.appetito.model;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

import java.sql.Time;
import java.util.Collection;

@Entity
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String dietPreferences;

    @Temporal(TemporalType.TIME)
    private Time preparationTime;
    private String occasion;
    private String imgFileName;
    @Length(max=10000)
    private String preparation;
    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Ingredient> ingredients;

    @OneToMany
    private Collection<Nutrition> nutritions;

    public Dish() {
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

    public Collection<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Collection<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }


    public Time getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Time preparationTime) {
        this.preparationTime = preparationTime;
    }

    public Collection<Nutrition> getNutritions() {
        return nutritions;
    }

    public void setNutritions(Collection<Nutrition> nutritions) {
        this.nutritions = nutritions;
    }
}
