package pl.grzegorz2047.productmanagement.model;

import lombok.Getter;

import javax.persistence.*;

public class Product {

    @Getter
    private final String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    public Product(String productName) {
        this.name = productName;
    }
}
