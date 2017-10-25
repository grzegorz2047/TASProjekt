package pl.grzegorz2047.productmanagement.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Opinion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;
    int score;
    String generalOpinion;
    Date date;


    public Opinion() {
    }

    public Opinion(User user, String opinionText, Date date) {
        this.generalOpinion = opinionText;
        this.date = date;
        this.user = user;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
