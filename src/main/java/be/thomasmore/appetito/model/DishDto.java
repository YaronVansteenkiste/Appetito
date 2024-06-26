package be.thomasmore.appetito.model;


import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Time;
import java.util.List;


public class DishDto {
    @NotEmpty(message = "Naam is vereist")
    private String name;
    @NotEmpty(message = "Dieetvoorkeur is vereist")
    private String dietPreferences;

    private String customDietPreferences;

    @Temporal(TemporalType.TIME)
    private Time preparationTime;
    @NotEmpty(message = "Gelegenheid is vereist")
    private String occasion ;

    private MultipartFile image;

    private Integer numberOfPeople;
    private String VideoUrl;

    private String imgFileName;

    public DishDto() {
    }


    public String getImgFileName() {
        return imgFileName;
    }

    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
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


    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }


    public Integer getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Integer numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }


    public String getCustomDietPreferences() {
        return customDietPreferences;
    }

    public void setCustomDietPreferences(String customDietPreferences) {
        this.customDietPreferences = customDietPreferences;
    }

    public String getVideoUrl() {
        return VideoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        VideoUrl = videoUrl;
    }
}



