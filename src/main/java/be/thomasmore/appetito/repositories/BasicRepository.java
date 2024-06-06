package be.thomasmore.appetito.repositories;

import be.thomasmore.appetito.model.Basic;
import be.thomasmore.appetito.model.Dish;
import be.thomasmore.appetito.model.Technique;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BasicRepository extends CrudRepository<Basic, Integer> {


  @Query("SELECT b FROM Basic b LEFT JOIN b.techniques t WHERE LOWER(b.action) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(t.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
Iterable<Basic> findByActionOrTechniques(@Param("keyword") String keyword);
    Page<Basic> findAll(Pageable pageable);


    Optional<Basic> findFirstByOrderByIdAsc();

    Optional<Basic> findFirstByOrderByIdDesc();

    Optional<Basic> findFirstByIdLessThanOrderByIdDesc(Integer id);

    Optional<Basic> findFirstByIdGreaterThanOrderByIdAsc(Integer id);
}
