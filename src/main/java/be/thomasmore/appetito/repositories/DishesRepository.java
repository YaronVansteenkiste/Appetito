package be.thomasmore.appetito.repositories;

import be.thomasmore.appetito.model.Dishes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DishesRepository extends CrudRepository<Dishes, Integer> {
    @Query("select d from Dishes d where d.dietPreferences " +
            "like %?1% and d.preparationTime <= ?2 and d.preparation " +
            "like %?3% and d.occasion like %?4%")
    Iterable<Dishes> findFilteredDishes(String dietPreferences, Integer preparationTime, String preparation, String occasion);
}
