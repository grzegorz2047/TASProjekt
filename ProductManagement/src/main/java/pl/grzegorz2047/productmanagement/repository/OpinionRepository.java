package pl.grzegorz2047.productmanagement.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.grzegorz2047.productmanagement.model.Product;
import pl.grzegorz2047.productmanagement.model.ProductOpinion;

import java.util.LinkedList;
import java.util.List;

public interface OpinionRepository extends CrudRepository<ProductOpinion, Long> {

/*
    @Query("select new map(id as id, generalOpinion as generalOpinion, pros as pros, cons as cons, score as score, product_id.name as productName ) from product_opinion o")
    Iterable<ProductOpinion> findAll();
*/


//    @Query("select new list(id as id, generalOpinion as generalOpinion, pros as pros, cons as cons, score as score, product_id.name as productName ) from product_opinion o WHERE product_id.id = :id")
//    LinkedList<ProductOpinion> getSortedOpinions(@Param("id") long id, Pageable pageRequest);

    LinkedList<ProductOpinion> findAllByProductId(long productId, Pageable pageRequest);

    @Query("select AVG(score) from product_opinion o WHERE productId.id = :id")
    double getAvgForProduct(@Param("id") long id);
}