package be.thomasmore.appetito.model;

import jakarta.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Chef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String username;
    private String email;
  private String password;
    @OneToMany(mappedBy = "chef", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Dish> dishes;

    @OneToMany(mappedBy = "conceptChef", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Dish> conceptDishes;

    @OneToMany(mappedBy = "chef")
    private Collection<Grocery> groceries;

    @ManyToMany
    @JoinTable(
            name = "favorite_dishes",
            joinColumns = @JoinColumn(name = "chef_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id"))
    private Collection<Dish> favoriteDishes;

    @OneToMany(mappedBy = "chef", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Collection<Beverage> beverage;

    public Chef() {
    }

    // Getters and Setters

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

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public Collection<Dish> getFavoriteDishes() {
        return favoriteDishes;
    }

    public void setFavoriteDishes(Collection<Dish> favoriteDishes) {
        this.favoriteDishes = favoriteDishes;
    }

    public Collection<Beverage> getBeverage() {
        return beverage;
    }

    public void setBeverage(Collection<Beverage> beverage) {
        this.beverage = beverage;
    }

    public List<Dish> getConceptDishes() {
        return conceptDishes;
    }

    public void setConceptDishes(List<Dish> conceptDishes) {
        this.conceptDishes = conceptDishes;
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
        dish.setChef(this);
    }

    public void removeDish(Dish dish) {
        dishes.remove(dish);
        dish.setChef(null);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
