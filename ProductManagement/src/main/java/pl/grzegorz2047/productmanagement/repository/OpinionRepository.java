package pl.grzegorz2047.productmanagement.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.grzegorz2047.productmanagement.model.Opinion;

public interface OpinionRepository extends CrudRepository<Opinion, Long> {

    @Query("select new map(id as id, generalOpinion as opinion, date as date) from Opinion o")
    Iterable<Opinion> findAll();

}