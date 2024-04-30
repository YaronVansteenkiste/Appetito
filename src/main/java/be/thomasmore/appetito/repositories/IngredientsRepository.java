package be.thomasmore.appetito.repositories;

import be.thomasmore.appetito.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientsRepository extends CrudRepository<Ingredient,Integer> {
}
