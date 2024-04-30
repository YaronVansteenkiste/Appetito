package be.thomasmore.appetito.repositories;

import be.thomasmore.appetito.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient,Integer> {
}
