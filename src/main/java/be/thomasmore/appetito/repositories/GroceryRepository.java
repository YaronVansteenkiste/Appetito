package be.thomasmore.appetito.repositories;

import be.thomasmore.appetito.model.Chef;
import be.thomasmore.appetito.model.Grocery;
import be.thomasmore.appetito.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GroceryRepository extends CrudRepository<Grocery,Integer> {
}
