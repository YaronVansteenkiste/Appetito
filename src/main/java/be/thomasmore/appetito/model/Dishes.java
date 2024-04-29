package be.thomasmore.appetito.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

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

    public Dishes(Integer id, String name, String image,
                  String dietPreferences, Date preparationTime,
                  Integer calories, String occasion, String imgFileName) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.dietPreferences = dietPreferences;
        this.preparationTime = preparationTime;
        this.calories = calories;
        this.occasion = occasion;
        this.imgFileName = imgFileName;
    }

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
}
