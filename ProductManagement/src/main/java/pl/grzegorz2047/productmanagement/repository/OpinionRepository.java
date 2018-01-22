package pl.grzegorz2047.productmanagement.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.grzegorz2047.productmanagement.model.ProductOpinion;

import java.util.LinkedList;

public interface OpinionRepository extends CrudRepository<ProductOpinion, Long> {

    @Query("select new map(id as id, generalOpinion as generalOpinion, pros as pros, cons as cons, score as score, product_id.name as productName ) from product_opinion o")
    Iterable<ProductOpinion> findAll();


    @Query("select new map(id as id, generalOpinion as generalOpinion, pros as pros, cons as cons, score as score, product_id.name as productName ) from product_opinion o WHERE product_id.id = :id")
    LinkedList<ProductOpinion> getSortedOpinions(@Param("id") long id, Pageable pageRequest);
}