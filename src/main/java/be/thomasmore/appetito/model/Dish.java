package be.thomasmore.appetito.model;

import com.google.api.client.util.Value;
import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ingredient> ingredients;

    private Boolean active = true;

    @ManyToMany
    private Collection<Chef> chefs;

    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Nutrition> nutritions;

    @ManyToMany
    private Collection<Beverage> beverages;

    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rating>ratings;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chef_id")
    private Chef chef;

    @ManyToMany(mappedBy = "favoriteDishes")
    private Collection<Chef> favoritedByChefs;

    public Dish() {
        this.active=true;
        this.beverages = new ArrayList<>();
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }


    public Time getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Time preparationTime) {
        this.preparationTime = preparationTime;
    }

    public List<Nutrition> getNutritions() {
        return nutritions;
    }

    public void setNutritions(List<Nutrition> nutritions) {
        this.nutritions = nutritions;
    }

    public boolean isActive() {
        return active;
    }

    public Collection<Beverage> getBeverages() {
        return beverages;
    }

    public void setBeverages(Collection<Beverage> beverages) {
        this.beverages = beverages;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Collection<Chef> getChefs() {
        return chefs;
    }

    public void setChefs(Collection<Chef> chefs) {
        this.chefs = chefs;
    }

    public Collection<Chef> getFavoritedByChefs() {
        return favoritedByChefs;
    }

    public void setFavoritedByChefs(Collection<Chef> favoritedByChefs) {
        this.favoritedByChefs = favoritedByChefs;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}