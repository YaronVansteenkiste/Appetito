package be.thomasmore.appetito.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Errandslist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String imgFileName;


    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "shoppingCar")


    private Collection<Ingredient> errands;

    public Errandslist() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = name;
    }

    public Collection<Ingredient> getErrands() {
        return errands;
    }

    public void setErrands(Collection<Ingredient> errands) {
        this.errands = errands;
    }

    public String getImgFileName() {
        return imgFileName;
    }

    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
    }

}
