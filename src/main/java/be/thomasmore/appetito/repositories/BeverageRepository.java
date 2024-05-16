package be.thomasmore.appetito.repositories;

import be.thomasmore.appetito.model.Beverage;
import org.springframework.data.repository.CrudRepository;

public interface BeverageRepository extends CrudRepository<Beverage, Integer> {

}
