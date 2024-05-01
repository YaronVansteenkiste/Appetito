package be.thomasmore.appetito.repositories;

import be.thomasmore.appetito.model.Dish;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Time;

public interface DishRepository extends CrudRepository<Dish, Integer> {

    @Query("select d from Dish d join d.nutritions n where " +
            "(:dietPreferences is null or d.dietPreferences = :dietPreferences) and " +
            "(:minPreparationTime is null or d.preparationTime >= :minPreparationTime) and " +
            "(:maxPreparationTime is null or d.preparationTime <= :maxPreparationTime) and " +
            "(:preparation is null or d.preparation = :preparation) and " +
            "(:occasion is null or d.occasion = :occasion) and " +
            "(:minCarbs is null or n.carbs >= :minCarbs) and " +
            "(:maxCarbs is null or n.carbs <= :maxCarbs)")
    Iterable<Dish> findFilteredDishes(@Param("dietPreferences") String dietPreferences,
                                      @Param("minPreparationTime") Time minPreparationTime,
                                      @Param("maxPreparationTime") Time maxPreparationTime,
                                      @Param("preparation") String preparation,
                                      @Param("occasion") String occasion,
                                      @Param("minCarbs") Integer minCarbs,
                                      @Param("maxCarbs") Integer maxCarbs);

    @Query("select d from Dish d where lower(d.name) like lower(concat('%', :keyword, '%'))")
    Iterable<Dish> findByName(@Param("keyword") String keyword);



}