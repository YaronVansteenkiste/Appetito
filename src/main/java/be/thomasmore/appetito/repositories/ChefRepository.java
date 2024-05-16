package be.thomasmore.appetito.repositories;

import be.thomasmore.appetito.model.Chef;
import be.thomasmore.appetito.model.Dish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface ChefRepository extends CrudRepository<Chef, Integer>{

    Chef findByUsername(String name);

    @Query("SELECT d FROM Dish d JOIN d.chefs c WHERE c.id = :chefId")
    List<Dish> getFavoriteDishesByChefId(int chefId);

    @Query("SELECT DISTINCT c FROM Chef c LEFT JOIN FETCH c.favoriteDishes WHERE c.username = :username")
    Chef findByUsernameWithDishes(String username);

    @Query("SELECT d FROM Dish d JOIN d.chefs c WHERE c.username = :username")
    Page<Dish> findDishesByChefUsername(String username, Pageable pageable);

    @Query("SELECT d FROM Dish d ORDER BY d.id ASC")
    List<Dish> findProductsPageable(int pageSize, int offset);
}
