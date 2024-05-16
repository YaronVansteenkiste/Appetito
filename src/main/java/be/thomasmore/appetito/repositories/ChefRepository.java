package be.thomasmore.appetito.repositories;

import be.thomasmore.appetito.model.Chef;
import be.thomasmore.appetito.model.Dish;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChefRepository extends CrudRepository<Chef, Integer>{
    Chef findByUsername(String name);

    List<Dish> getFavoriteDishesByChefId(int id);
}
