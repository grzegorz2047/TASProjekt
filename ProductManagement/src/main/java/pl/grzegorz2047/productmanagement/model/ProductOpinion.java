package pl.grzegorz2047.productmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "product_opinion")
public class ProductOpinion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Column(name = "id", unique = true, nullable = false)
    long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    @Getter
    @Setter
    private User user;

    @Getter
    @ManyToOne(optional = false)
//    @JsonManagedReference
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product productId;

    @Getter
    int score;

    @Column(name = "general_opinion")
    @Getter
    String generalOpinion;
    @Column(name = "pros")
    @Getter
    private String pros;
    @Column(name = "cons")
    @Getter
    private String cons;
    @Getter
    Date date;

    protected ProductOpinion() {

    }

    public ProductOpinion(User user, Product product, String opinionText, Date date, String pros, String cons, int score) {
        this.generalOpinion = opinionText;
        this.date = date;
        this.user = user;
        this.pros = pros;
        this.cons = cons;
        this.score = score;//{1,5} Disallow score > 5
        this.productId = product;
        assert (score <= 5);
    }
}
