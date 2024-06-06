package be.thomasmore.appetito.repositories;


import be.thomasmore.appetito.model.Chef;
import be.thomasmore.appetito.model.Menu;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MenuRepository extends CrudRepository<Menu, Integer> {

    Iterable<Menu> findByChef(Chef chef);
    Iterable<Menu> findAllByActiveTrue();

    Optional<Menu> getMenuById(Integer id);

    Iterable<Menu> findAllByActiveTrueAndChef(Chef chef);
}
