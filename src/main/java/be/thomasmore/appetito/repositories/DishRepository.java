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




    @Query("select d from Dish d join d.nutritions n where " +
            "(:dietPreferences is null or d.dietPreferences = :dietPreferences) and " +
            "(:minPreparationTime is null or d.preparationTime >= :minPreparationTime) and " +
            "(:maxPreparationTime is null or d.preparationTime <= :maxPreparationTime) and " +
            "(:preparation is null or d.preparation = :preparation) and " +
            "(:occasion is null or d.occasion = :occasion) and " +
            "(:minCarbs is null or n.carbs >= :minCarbs) and " +
            "(:maxCarbs is null or n.carbs <= :maxCarbs) and " +
            "(:minFiber is null or n.fiber >= :minFiber) and " +
            "(:maxFiber is null or n.fiber <= :maxFiber) and " +
            "(:minSalt is null or n.salt >= :minSalt) and " +
            "(:maxSalt is null or n.salt <= :maxSalt) and " +
            "(:minSugar is null or n.sugar >= :minSugar) and " +
            "(:maxSugar is null or n.sugar <= :maxSugar) and " +
            "(:minSaturatedFat is null or n.saturatedFat >= :minSaturatedFat) and " +
            "(:maxSaturatedFat is null or n.saturatedFat <= :maxSaturatedFat) and " +
            "(:minFat is null or n.fat >= :minFat) and " +
            "(:maxFat is null or n.fat <= :maxFat) and " +
            "(:minProteins is null or n.proteins >= :minProteins) and " +
            "(:maxProteins is null or n.proteins <= :maxProteins) and " +
            "d.active = true")
    Page<Dish> findFilteredDishes(@Param("dietPreferences") String dietPreferences,
                                  @Param("minPreparationTime") Time minPreparationTime,
                                  @Param("maxPreparationTime") Time maxPreparationTime,
                                  @Param("preparation") String preparation,
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