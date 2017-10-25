package pl.grzegorz2047.productmanagement.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.grzegorz2047.productmanagement.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select new map(id as id, name as name, date as date) from User u")
    Iterable<User> findAll();

}