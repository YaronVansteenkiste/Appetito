package be.thomasmore.appetito.model;


import jakarta.persistence.*;

import java.util.Collection;

@Entity

public class Chef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    private String surname;

    private String username;

    private String email;

    @OneToMany(mappedBy = "chef")
    private Collection<Beverage> beverage;


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

    public Collection<Beverage> getBeverage() {
        return beverage;
    }

    public void setBeverage(Collection<Beverage> beverage) {
        this.beverage = beverage;
    }
}
