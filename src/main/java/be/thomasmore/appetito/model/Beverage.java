package be.thomasmore.appetito.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Beverage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    private String imgFile;

    private Boolean active = true;

    @ManyToMany(mappedBy = "beverages")
    private Collection<Dish> dishes;

    public Beverage(){this.active=true;}

    public Beverage(Integer id, String name, String imgFile) {
        this.id = id;
        this.name = name;
        this.imgFile = imgFile;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public String getImgFile() {
        return imgFile;
    }

    public void setImgFile(String imgFile) {
        this.imgFile = imgFile;
    }

    public Collection<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Collection<Dish> dishes) {
        this.dishes = dishes;
    }
}
