package be.thomasmore.appetito.repositories;

import be.thomasmore.appetito.model.Dishes;
import org.springframework.data.repository.CrudRepository;

public interface DishesRepository extends CrudRepository<Dishes,Integer> {

}
