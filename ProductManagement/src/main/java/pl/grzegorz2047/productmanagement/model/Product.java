package pl.grzegorz2047.productmanagement.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity(name = "product")
public class Product {

    @Getter
    private String name;

    @OneToMany()
    private Collection<ProductOpinion> productOpinions = new ArrayList<ProductOpinion>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Product() {}

    public Product(String productName) {
        this.name = productName;
    }
}
