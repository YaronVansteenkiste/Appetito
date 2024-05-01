package be.thomasmore.appetito.model;


import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Time;


public class DishDto {
    @NotEmpty(message = "Naam is vereist")
    private String name;
    @NotEmpty(message = "Dieetvoorkeur is vereist")
    private String dietPreferences;

    @Temporal(TemporalType.TIME)
    private Time preparationTime;
    @NotEmpty(message = "Gelegenheid is vereist")
    private String occasion ;
   
    private MultipartFile multipartFile;
    @Size(min = 10,message = "Bereiding moet minstens 10 karakters bevatten")
    @Size(max = 10000,message = "Bereiding moet maximum 10000 karakters bevatten")
    private String preparation;


    public DishDto() {
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

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }
}



