package be.thomasmore.appetito.repositories;

import be.thomasmore.appetito.model.Step;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StepRepository extends CrudRepository<Step, Integer>{
    @Query ("select s from Step s where s.dish.id = ?1")
    Iterable<Step> findByDishId(Integer dishId);


}
