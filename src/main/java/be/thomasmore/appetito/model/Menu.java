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

    private Integer numberOfPeople;

    private String description;

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

    public List<be.thomasmore.appetito.model.MenuDay> getMenuDay() {
        return MenuDay;
    }

    public void setMenuDay(List<be.thomasmore.appetito.model.MenuDay> menuDay) {
        MenuDay = menuDay;
    }

    public Integer getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Integer numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
