package be.thomasmore.appetito.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Errandslist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String boodschapNaam;

    private String imgFileName;

    private double prijs;


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

    public String getBoodschapNaam() {
        return boodschapNaam;
    }

    public void setBoodschapNaam(String boodschapNaam) {
        this.boodschapNaam = boodschapNaam;
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

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }
}
