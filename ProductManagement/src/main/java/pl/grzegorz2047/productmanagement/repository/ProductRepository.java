package pl.grzegorz2047.productmanagement.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import pl.grzegorz2047.productmanagement.model.Product;

import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findTop10OrderByAverageScore(Sort sort);

}
