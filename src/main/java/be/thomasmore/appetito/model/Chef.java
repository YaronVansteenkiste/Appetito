package be.thomasmore.appetito.model;


import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

@Entity

public class Chef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    private String surname;

    private String username;

    private String email;
    @OneToMany(mappedBy = "chef", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Dish> dishes ;


    @OneToMany(mappedBy = "chef")
    private Collection<Grocery> groceries;


    public Chef() {
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

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Grocery> getGroceries() {
        return groceries;
    }

    public void setGroceries(Collection<Grocery> groceries) {
        this.groceries = groceries;
    }
    public void addDish(Dish dish) {
        dishes.add(dish);
        dish.setChef(this);
    }
    public void removeDish(Dish dish) {
        dishes.remove(dish);
        dish.setChef(null);
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

}
