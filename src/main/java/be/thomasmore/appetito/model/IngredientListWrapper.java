package be.thomasmore.appetito.model;

import java.util.ArrayList;
import java.util.List;

public class IngredientListWrapper {
    private List<Ingredient> ingredients;

    public IngredientListWrapper() {
        this.ingredients = new ArrayList<>();
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}