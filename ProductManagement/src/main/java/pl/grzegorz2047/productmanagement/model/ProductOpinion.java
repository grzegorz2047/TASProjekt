package pl.grzegorz2047.productmanagement.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class ProductOpinion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;
    int score;
    String generalOpinion;
    List<String> pros;
    List<String> cons;
    Date date;

    public ProductOpinion(User user, String opinionText, Date date, List<String> pros, List<String> cons, int score) {
        this.generalOpinion = opinionText;
        this.date = date;
        this.user = user;
        this.pros = pros;
        this.cons = cons;
        this.score = score;//{1,5} Disallow score > 5
        assert (score <= 5);
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
