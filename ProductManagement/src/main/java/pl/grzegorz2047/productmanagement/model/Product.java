package pl.grzegorz2047.productmanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Product {

    @Getter
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter
    private String name;

    @Getter
    @Setter
    private double averageScore;

    @Getter
    @Setter
    private int opinionNumber;

    @Getter
    @Setter
    @OneToMany(targetEntity = ProductOpinion.class, fetch = FetchType.EAGER)
    @JsonBackReference
    // W productOpinions, obiekt product jest polaczony poprzez swoje id w product_id
    private List<ProductOpinion> productOpinions;

    public Product() {
    }

    public Product(String productName) {
        this.name = productName;
    }

    public Product(long id, String productName, LinkedList<ProductOpinion> productOpinions) {
        this.name = productName;
        this.id = id;
        this.productOpinions = productOpinions;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productOpinions=" + productOpinions +
                '}';
    }

}
