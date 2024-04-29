package be.thomasmore.appetito.repositories;

import be.thomasmore.appetito.model.Ingredients;
import org.springframework.data.repository.CrudRepository;

public interface IngredientsRepository extends CrudRepository<Ingredients,Integer> {
}
