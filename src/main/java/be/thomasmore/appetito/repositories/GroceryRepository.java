package be.thomasmore.appetito.repositories;

import be.thomasmore.appetito.model.Chef;
import be.thomasmore.appetito.model.Grocery;
import be.thomasmore.appetito.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GroceryRepository extends CrudRepository<Grocery,Integer> {
    Optional<Grocery> findByChef(Chef chef);
    List<Grocery> findByIngredients(Ingredient ingredient);
}
