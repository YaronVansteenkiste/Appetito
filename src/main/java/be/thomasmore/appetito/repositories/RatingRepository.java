package be.thomasmore.appetito.repositories;

import be.thomasmore.appetito.model.Rating;
import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating,Integer> {
}
