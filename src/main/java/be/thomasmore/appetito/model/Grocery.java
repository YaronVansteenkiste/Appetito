package be.thomasmore.appetito.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Grocery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Chef chef;

    @ManyToMany
    @JoinTable(
            name = "grocery_ingredients",
            joinColumns = @JoinColumn(name = "grocery_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredients_id")
    )
    private Collection<Ingredient> ingredients;

    public Grocery() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

    public Collection<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Collection<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }


}
