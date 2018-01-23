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

@Entity(name = "product")
public class Product {

    @Getter
    @Id
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

//    @Getter

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
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

    public List<ProductOpinion> getProductOpinions() {
        return productOpinions;
    }
}
