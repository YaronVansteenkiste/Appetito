package be.thomasmore.appetito.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class MenuDay {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    private Integer dayNumber;

    @ManyToMany (fetch = FetchType.LAZY)
    private List<Dish> dishes;


    @ManyToOne
    private Menu menu;

    public MenuDay() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(Integer dayNumber) {
        this.dayNumber = dayNumber;
    }


    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}
