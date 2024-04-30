package be.thomasmore.appetito.repositories;

import be.thomasmore.appetito.model.Dish;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DishesRepository extends CrudRepository<Dish, Integer> {
    @Query("select d from Dish d where d.dietPreferences " +
            "like %?1% and d.preparationTime <= ?2 and d.preparation " +
            "like %?3% and d.occasion like %?4%")
    Iterable<Dish> findFilteredDishes(String dietPreferences, Integer preparationTime, String preparation, String occasion);

//    text field search
    @Query("select d from Dish d where d.name like %?1%")
    Iterable<Dish> findByName(String name);

}
