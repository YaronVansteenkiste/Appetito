package be.thomasmore.appetito.repositories;

import be.thomasmore.appetito.model.Dish;
import be.thomasmore.appetito.model.Menu;
import be.thomasmore.appetito.model.MenuDay;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MenuDayRepository extends CrudRepository<MenuDay, Integer> {

    List<MenuDay> findByMenu(Optional<Menu> menu);
}
