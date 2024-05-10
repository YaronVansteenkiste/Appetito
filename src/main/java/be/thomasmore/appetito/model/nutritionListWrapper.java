package be.thomasmore.appetito.model;

import java.util.ArrayList;
import java.util.List;

public class nutritionListWrapper {
    private List<Nutrition> nutritions;


    public nutritionListWrapper() {
        this.nutritions = new ArrayList<>();
    }

    public List<Nutrition> getNutritions() {
        return nutritions;
    }

    public void setNutritions(List<Nutrition> nutritions) {
        this.nutritions = nutritions;
    }
}
