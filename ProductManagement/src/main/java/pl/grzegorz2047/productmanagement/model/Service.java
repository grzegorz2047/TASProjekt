package pl.grzegorz2047.productmanagement.model;

import javax.persistence.*;

public class Service {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}
