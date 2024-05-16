package be.thomasmore.appetito.repositories;


import be.thomasmore.appetito.model.Chef;
import be.thomasmore.appetito.model.Menu;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<Menu, Integer> {

    Iterable<Menu> findByChef(Chef chef);
}
