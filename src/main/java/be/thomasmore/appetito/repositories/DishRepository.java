package be.thomasmore.appetito.repositories;

import be.thomasmore.appetito.model.Dish;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import java.sql.Time;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface DishRepository extends CrudRepository<Dish, Integer> {

    List<Dish> findAllByOrderByIdAsc();

    Optional<Dish> findFirstByOrderByIdAsc();

    Optional<Dish> findFirstByOrderByIdDesc();

    Optional<Dish> findFirstByIdGreaterThanOrderByIdAsc(Integer id);

    Optional<Dish> findFirstByIdLessThanOrderByIdDesc(Integer id);




@Query("select d from Dish d inner join d.nutritions n where " +
        "(coalesce(:dietPreferences, '') = '' or d.dietPreferences = :dietPreferences) and " +
        "(coalesce(:minPreparationTime, '00:00:00') = '00:00:00' or d.preparationTime >= :minPreparationTime) and " +
        "(coalesce(:maxPreparationTime, '00:00:00') = '00:00:00' or d.preparationTime <= :maxPreparationTime) and " +
        "(coalesce(:occasion, '') = '' or d.occasion = :occasion) and " +
        "(coalesce(:minCarbs, 0) = 0 or n.carbs >= :minCarbs) and " +
        "(coalesce(:maxCarbs, 0) = 0 or n.carbs <= :maxCarbs) and " +
        "(coalesce(:minFiber, 0) = 0 or n.fiber >= :minFiber) and " +
        "(coalesce(:maxFiber, 0) = 0 or n.fiber <= :maxFiber) and " +
        "(coalesce(:minSalt, 0) = 0 or n.salt >= :minSalt) and " +
        "(coalesce(:maxSalt, 0) = 0 or n.salt <= :maxSalt) and " +
        "(coalesce(:minSugar, 0) = 0 or n.sugar >= :minSugar) and " +
        "(coalesce(:maxSugar, 0) = 0 or n.sugar <= :maxSugar) and " +
        "(coalesce(:minSaturatedFat, 0) = 0 or n.saturatedFat >= :minSaturatedFat) and " +
        "(coalesce(:maxSaturatedFat, 0) = 0 or n.saturatedFat <= :maxSaturatedFat) and " +
        "(coalesce(:minFat, 0) = 0 or n.fat >= :minFat) and " +
        "(coalesce(:maxFat, 0) = 0 or n.fat <= :maxFat) and " +
        "(coalesce(:minProteins, 0) = 0 or n.proteins >= :minProteins) and " +
        "(coalesce(:maxProteins, 0) = 0 or n.proteins <= :maxProteins) and " +
        "d.active = true")
Page<Dish> findFilteredDishes(@Param("dietPreferences") String dietPreferences,
                              @Param("minPreparationTime") Time minPreparationTime,
                              @Param("maxPreparationTime") Time maxPreparationTime,
                              @Param("occasion") String occasion,
                              @Param("minCarbs") Integer minCarbs,
                              @Param("maxCarbs") Integer maxCarbs,
                              @Param("minFiber") Integer minFiber,
                              @Param("maxFiber") Integer maxFiber,
                              @Param("minSalt") Integer minSalt,
                              @Param("maxSalt") Integer maxSalt,
                              @Param("minSugar") Integer minSugar,
                              @Param("maxSugar") Integer maxSugar,
                              @Param("minSaturatedFat") Integer minSaturatedFat,
                              @Param("maxSaturatedFat") Integer maxSaturatedFat,
                              @Param("minFat") Integer minFat,
                              @Param("maxFat") Integer maxFat,
                              @Param("minProteins") Integer minProteins,
                              @Param("maxProteins") Integer maxProteins,
                              Pageable pageable);

    @Query("select d from Dish d where lower(d.name) like lower(concat('%', :keyword, '%'))")
    Iterable<Dish> findByName(@Param("keyword") String keyword);

    @Query("SELECT d FROM Dish d ORDER BY d.id ASC")
    List<Dish> findProductsPageable(int pageSize, int offset);

    Iterable<Dish> findAll();
    List<Dish> findByActive(boolean active);
    Page<Dish> findByActive(boolean active, Pageable pageable);
    long count();

    @Query("SELECT d FROM Dish d JOIN d.dietPreferences WHERE d.name IN :dietPreferences")
    List<Dish> findByDietPreferencesIn(List<String> dietPreferences);
}