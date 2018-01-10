package pl.grzegorz2047.productmanagement.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity(name = "product_opinion")
public class ProductOpinion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id")
    private Product product_id;
    ;
    int score;

    @Column(name = "general_opinion")
    String generalOpinion;

    private String pros;
    private String cons;
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
        this.product_id = product;
        assert (score <= 5);
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
