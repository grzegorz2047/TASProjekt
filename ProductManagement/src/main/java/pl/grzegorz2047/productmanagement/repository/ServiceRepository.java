package pl.grzegorz2047.productmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import pl.grzegorz2047.productmanagement.model.Service;

public interface ServiceRepository extends CrudRepository<Service, Long> {

}
