package be.thomasmore.appetito.repositories;

import be.thomasmore.appetito.model.Dish;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DishRepository extends CrudRepository<Dish, Integer> {

    @Query("select d from Dish d where (:dietPreferences is null or d.dietPreferences = :dietPreferences) and " +
            "(:minPreparationTime is null or d.preparationTime >= :minPreparationTime) and " +
            "(:maxPreparationTime is null or d.preparationTime <= :maxPreparationTime) and " +
            "(:preparation is null or d.preparation = :preparation) and " +
            "(:occasion is null or d.occasion = :occasion)")
    Iterable<Dish> findFilteredDishes(@Param("dietPreferences") String dietPreferences,
                                      @Param("minPreparationTime") String minPreparationTime,
                                        @Param("maxPreparationTime") String maxPreparationTime,
                                      @Param("preparation") String preparation,
                                      @Param("occasion") String occasion);


    @Query("select d from Dish d where d.name like %?1%")
    Iterable<Dish> findByName(String name);

}
