package pl.grzegorz2047.productmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import pl.grzegorz2047.productmanagement.model.Product;

import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("SELECT new map(id as id, name as name) FROM product")
    Iterable<Product> findAll();

}
