package pl.grzegorz2047.productmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import pl.grzegorz2047.productmanagement.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
