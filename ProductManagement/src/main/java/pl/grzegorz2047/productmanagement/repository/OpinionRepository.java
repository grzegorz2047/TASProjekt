package pl.grzegorz2047.productmanagement.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.grzegorz2047.productmanagement.model.ProductOpinion;

import java.util.LinkedList;
import java.util.List;

public interface OpinionRepository extends CrudRepository<ProductOpinion, Long> {

/*
    @Query("select new map(id as id, generalOpinion as generalOpinion, pros as pros, cons as cons, score as score, product_id.name as productName ) from product_opinion o")
    Iterable<ProductOpinion> findAll();
*/


    @Query("FROM product_opinion o WHERE product_id = :id")
    Iterable<ProductOpinion> opinionsForProduct(@Param("id") long id);

    @Query("FROM product_opinion o WHERE product_id = :id")
    Iterable<ProductOpinion> opinionsForProductSortedById(@Param("id") long id, Sort pageable);

//    @Query("select (nam")
//    LinkedList<ProductOpinion> opinionsForProduct(long product);

    @Query("select AVG(score) from product_opinion o WHERE productId.id = :id")
    double getAvgForProduct(@Param("id") long id);
}