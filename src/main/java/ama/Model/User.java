package ama.Model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    public User() {
        this("NoName");
    }

    public User(String name) {
        this.name = name;
    }
}
