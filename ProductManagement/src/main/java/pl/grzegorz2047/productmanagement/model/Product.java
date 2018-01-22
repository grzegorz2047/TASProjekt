package pl.grzegorz2047.productmanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedList;

@Entity(name = "product")
public class Product {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter
    private String name;

    @Getter
    @JsonBackReference
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    // W productOpinions, obiekt product jest polaczony poprzez swoje id w product_id
    private Collection<ProductOpinion> productOpinions = new LinkedList<>();

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

    public void setProductOpinion(LinkedList<ProductOpinion> productOpinion) {
        this.productOpinions = productOpinion;
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
