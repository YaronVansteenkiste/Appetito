package be.thomasmore.appetito.model;

import com.google.api.client.util.Value;
import com.google.firebase.remoteconfig.User;
import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String dietPreferences;
    private boolean conceptDish = false;
    private String customDietPreferences;
    private String videoUrl;

    @Temporal(TemporalType.TIME)
    private Time preparationTime;
    private String occasion;
    private String imgFileName;

    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ingredient> ingredients;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    private Boolean active = true;
    @ManyToMany
    private Collection<Chef> chefs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "concept_chef_id")
    private Chef conceptChef;

    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Nutrition> nutritions;

    @ManyToMany
    private Collection<Beverage> beverages;

    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rating> ratings;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chef_id")
    private Chef chef;

    @ManyToMany(mappedBy = "favoriteDishes")
    private Collection<Chef> favoritedByChefs;

    private Integer numberOfPeople;

    public Dish() {
        this.active = true;
        this.beverages = new ArrayList<>();
    }
    @PrePersist
    protected void onCreate() {
        creationDate = new Date();
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

    public void setActive(boolean active) {
        this.active = active;
    }

    public Collection<Beverage> getBeverages() {
        return beverages;
    }

    public void setBeverages(Collection<Beverage> beverages) {
        this.beverages = beverages;
    }

    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
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

    public double getAverageRating() {
        if (ratings.isEmpty()) return 0;
        double sum = 0;
        for (Rating rating : ratings) {
            sum += rating.getRating();
        }
        return sum / ratings.size();
    }

    public Integer getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Integer numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getCustomDietPreferences() {
        return customDietPreferences;
    }

    public void setCustomDietPreferences(String customDietPreferences) {
        this.customDietPreferences = customDietPreferences;
    }

    public boolean isConceptDish() {
        return conceptDish;
    }

    public void setConceptDish(boolean conceptDish) {
        this.conceptDish = conceptDish;
    }

    public Chef getConceptChef() {
        return conceptChef;
    }

    public void setConceptChef(Chef conceptChef) {
        this.conceptChef = conceptChef;
    }
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}