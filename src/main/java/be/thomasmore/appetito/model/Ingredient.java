package be.thomasmore.appetito.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Ingredient {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String name;
    private double quantity;
    private String unit;

    private double estimatedPrice;

    @ManyToMany()
    @JoinTable(name = "errands_ingredients")
    private List<Errandslist> shoppingCar;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;


    public Ingredient() {
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

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public double getEstimatedPrice() {
        return estimatedPrice;
    }

    public void setEstimatedPrice(double estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
    }

    public List<Errandslist> getShoppingCar() {
        return shoppingCar;
    }

    public void setShoppingCar(List<Errandslist> shoppingCar) {
        this.shoppingCar = shoppingCar;
    }


}
