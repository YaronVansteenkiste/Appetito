package be.thomasmore.appetito.repositories;

import be.thomasmore.appetito.model.Step;
import be.thomasmore.appetito.model.Technique;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TechniqueRepository extends CrudRepository<Technique,Integer> {



    @Query("select t from Technique t where t.basic.id = ?1")
    Iterable<Technique> findByBasicId(Integer basicId);

}
