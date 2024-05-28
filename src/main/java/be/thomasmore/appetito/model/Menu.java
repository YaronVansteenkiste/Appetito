package be.thomasmore.appetito.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany (mappedBy = "menu")
    private List<MenuDay> MenuDay = new ArrayList<>();


    @ManyToOne
    private Chef chef;

    private Boolean active = true;

    public Menu() {
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


    public void setChef(Chef chef) {
        this.chef = chef;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Chef getChef() {
        return chef;
    }

}
