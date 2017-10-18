package pl.grzegorz2047.productmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import pl.grzegorz2047.productmanagement.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}