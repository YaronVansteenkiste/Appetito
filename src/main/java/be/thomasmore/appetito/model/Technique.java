package be.thomasmore.appetito.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Entity
public class Technique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Length(max = 1000)
    @NotNull
    private String techniqueDescription;

    @NotNull
    private String name;

    private String imgFileName;

    @ManyToOne
    private Basic basic;

    @Transient
    private MultipartFile imageFile;


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

    public String getImgFileName() {
        return imgFileName;
    }

    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }

    public Basic getBasic() {
        return basic;
    }

    public void setBasic(Basic basic) {
        this.basic = basic;
    }

    public void setBasicActionId(Integer basicActionId) {
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }
}
