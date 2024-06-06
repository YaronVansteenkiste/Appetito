package be.thomasmore.appetito.model;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;

import java.util.Date;
import java.util.List;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String review;
    @Timestamp
    private Date date;

    private String name;

    @ManyToOne
    @JoinColumn(name = "chef_id")
    private Chef chef;

    @ManyToMany
    private List<Dish> dishes;

    public Review() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setGames(List<Dish> dishes) {
        this.dishes = dishes;
    }


    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}