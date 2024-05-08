package be.thomasmore.appetito.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Beverage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String type_of_beverage;

    @ManyToMany(mappedBy = "beverages")
    private Collection<Dish> dishes;

    public Beverage(){}

    public Beverage(Integer id, String name, String type_of_beverage) {
        this.id = id;
        this.name = name;
        this.type_of_beverage = type_of_beverage;
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

    public String getType_of_beverage() {
        return type_of_beverage;
    }

    public void setType_of_beverage(String type_of_beverage) {
        this.type_of_beverage = type_of_beverage;
    }

    public Collection<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Collection<Dish> dishes) {
        this.dishes = dishes;
    }
}
