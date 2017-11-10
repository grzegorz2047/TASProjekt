package pl.grzegorz2047.productmanagement.model;

import javax.persistence.*;


@Entity
public class Service {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}
