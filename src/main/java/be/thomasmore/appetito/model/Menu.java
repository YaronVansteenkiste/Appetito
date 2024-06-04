package be.thomasmore.appetito.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id;



    @NotEmpty(message = "Naam mag niet leeg zijn")
    @NotNull(message = "Naam is vereist")
    private String name;

    @OneToMany (mappedBy = "menu")
    private List<MenuDay> MenuDay = new ArrayList<>();


    @ManyToOne
    private Chef chef;

    private Boolean active = true;

    @Min(value = 1, message = "Aantal personen moet minimaal 1 zijn")
    @Max(value = 100, message = "Het aantal personen mag maximaal 100 zijn")
    @NotNull(message = "Aantal personen is vereist")
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
