package be.thomasmore.appetito.repositories;

import be.thomasmore.appetito.model.Basic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BasicRepository extends CrudRepository<Basic, Integer> {


    @Query("SELECT b FROM Basic b LEFT JOIN b.techniques t WHERE b.action LIKE %:keyword% OR t.name LIKE %:keyword%")
    Iterable<Basic> findByActionOrTechniques(@Param("keyword") String keyword);
}
