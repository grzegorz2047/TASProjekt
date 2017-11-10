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
    @OneToMany(targetEntity=ProductOpinion.class, mappedBy="user",
            fetch=FetchType.EAGER)
    private List<ProductOpinion> productOpinion;

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
    public List<ProductOpinion> getOpinions() {
        return productOpinion;
    }

    public void addOpinion(ProductOpinion opinion) {
        if (null == productOpinion) {
            productOpinion = new ArrayList<ProductOpinion>();
        }
        opinion.setUser(this);
        productOpinion.add(opinion);
    }
 }
