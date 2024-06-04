package be.thomasmore.appetito.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

@Entity
public class Basic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String action;
    @NotNull
    private String description;

    @Transient
    @Column(name = "IMAGE")
    private MultipartFile image;

    private String imgFileName;

    @OneToMany(mappedBy = "basic")
    Collection<Technique> techniques;

    public Basic() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getImgFileName() {
        return imgFileName;
    }



    public Collection<Technique> getTechniques() {
        return techniques;
    }

    public void setTechniques(Collection<Technique> techniques) {
        this.techniques = techniques;
    }

    public void setImgFileName(String uploadImage) {
    }
}
