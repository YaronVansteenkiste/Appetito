package be.thomasmore.appetito.repositories;

import be.thomasmore.appetito.model.Chef;
import be.thomasmore.appetito.model.Dish;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

public interface DishRepository extends CrudRepository<Dish, Integer> {

    List<Dish> findAllByOrderByIdAsc();

    Optional<Dish> findFirstByActiveOrderByIdAsc(Boolean active);

    Optional<Dish> findFirstByActiveOrderByIdDesc(Boolean active);

    Optional<Dish> findFirstByIdGreaterThanAndActiveOrderByIdAsc(Integer id, Boolean active);
    List<Dish> findByConceptChef(Chef chef);
    Optional<Dish> findFirstByIdLessThanAndActiveOrderByIdDesc(Integer id, Boolean active);
    @Query("SELECT d FROM Dish d WHERE d.chef = :chef AND d.conceptDish = false")
    List<Dish> findByChefAndConceptDish(Chef chef);

    @Query("SELECT d FROM Dish d WHERE d.chef = :chef AND d.conceptDish = false ORDER BY d.creationDate DESC")
    List<Dish> findByChefAndConceptDishFalse(Chef chef, Pageable pageable);
    @Query("SELECT DISTINCT d.customDietPreferences FROM Dish d WHERE d.customDietPreferences IS NOT NULL")
    List<String> findDistinctCustomDietPreferences();

    @Query("select d from Dish d left join d.nutritions n where " +
            "(coalesce(:dietPreferences, '') = '' or d.dietPreferences IN :dietPreferences) and " +
            "(coalesce(:customDietPreferences, '') = '' or d.customDietPreferences IN :customDietPreferences) and " +
            "(coalesce(:minPreparationTime, '00:00:00') = '00:00:00' or d.preparationTime >= :minPreparationTime) and " +
            "(coalesce(:maxPreparationTime, '00:00:00') = '00:00:00' or d.preparationTime <= :maxPreparationTime) and " +
            "(coalesce(:occasion, '') = '' or d.occasion IN :occasion) and " +
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
            "(coalesce(:ratings, '') = '' or (select avg(r.rating) from Rating r where r.dish = d) in (:ratings)) and " +
            "d.active = true")
    Page<Dish> findFilteredDishes(@Param("dietPreferences") List<String> dietPreferences,
                                  @Param("customDietPreferences") String customDietPreferences,
                                  @Param("minPreparationTime") Time minPreparationTime,
                                  @Param("maxPreparationTime") Time maxPreparationTime,
                                  @Param("occasion") List<String> occasion,
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
                                  @Param("ratings") List<Integer> ratings,
                                  Pageable pageable);


@Query("SELECT d FROM Dish d LEFT JOIN d.ingredients i WHERE LOWER(d.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(i.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
Iterable<Dish> findByNameOrIngredients(@Param("keyword") String keyword);

    @Query("SELECT d FROM Dish d ORDER BY d.id ASC")
    List<Dish> findProductsPageable(int pageSize, int offset);

    @NotNull List<Dish> findAll();


    List<Dish> findByActive(boolean active);

    Page<Dish> findByActive(boolean active, Pageable pageable);

    long count();

    @Query("SELECT d FROM Dish d JOIN d.dietPreferences WHERE d.name IN :dietPreferences")
    List<Dish> findByDietPreferencesIn(List<String> dietPreferences);

    List<Dish> findByChefId(int chef_id);


    @Query("SELECT d FROM Dish d JOIN d.chef c WHERE c.username = :username AND (d.active = true OR :isAdmin = true)")
    List<Dish> findAllDishesForUser(String username, boolean isAdmin);

    List<Dish> findByActiveTrue();

    List<Dish> findAllByActive(Boolean active);

    Optional<Dish> findFirstByIdLessThanOrderByIdDesc(Integer id);

    Optional<Dish> findFirstByOrderByIdAsc();

    Optional<Dish> findFirstByIdGreaterThanOrderByIdAsc(Integer id);

    Optional<Dish> findFirstByOrderByIdDesc();

    @Query(value = "SELECT * FROM Dish WHERE occasion = ?1 ORDER BY RAND() LIMIT 3", nativeQuery = true)
    List<Dish> findRandomDishesByOccasion(String occasion);

    @Query("SELECT d FROM Dish d JOIN Rating r ON d.id = r.dish.id GROUP BY d.id ORDER BY AVG(r.rating) DESC limit 3")
    List<Dish> findTopDishes();


    List<Dish> findByCustomDietPreferencesIsNotNull();
}