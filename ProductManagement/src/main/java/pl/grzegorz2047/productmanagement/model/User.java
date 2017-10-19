package pl.grzegorz2047.productmanagement.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class User {

    @Getter
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;
    @Getter
    @Setter
    String name;
    @Getter
    @Setter
    String password;
    @Getter
    @Setter
    Date date;

    public User() {

    }

    public User( String name, String password, Date date) {
        this.name = name;
        this.password = password;
        this.date = date;
    }

    //getters and setters and toString...
}
