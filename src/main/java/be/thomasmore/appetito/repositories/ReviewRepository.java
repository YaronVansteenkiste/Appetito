package be.thomasmore.appetito.repositories;

import be.thomasmore.appetito.model.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
}
