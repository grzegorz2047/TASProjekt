package pl.grzegorz2047.productmanagement.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.grzegorz2047.productmanagement.model.ProductOpinion;

public interface OpinionRepository extends CrudRepository<ProductOpinion, Long> {

    @Query("select new map(id as id, pros as pros, cons as cons, score as score, product_id.name as productname ) from product_opinion o")
    Iterable<ProductOpinion> findAll();

}