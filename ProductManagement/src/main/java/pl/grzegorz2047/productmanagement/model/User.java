package pl.grzegorz2047.productmanagement.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class User {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private Date date;
    @OneToMany(targetEntity=Opinion.class, mappedBy="user",
            fetch=FetchType.EAGER)
    private List<Opinion> opinions;

    public User() {

    }

    public User(String name, String password, Date date) {
        this.name = name;
        this.password = password;
        this.date = date;
    }

    @OneToMany
    public long getUserId() {
        return id;
    }


    @Cascade({org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
    public List<Opinion> getOpinions() {
        return opinions;
    }

    public void addOpinion(Opinion opinion) {
        if (null == opinions) {
            opinions = new ArrayList<Opinion>();
        }
        opinion.setUser(this);
        opinions.add(opinion);
    }
 }
