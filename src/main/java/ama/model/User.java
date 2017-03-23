package ama.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String password;

    @ManyToMany
    @JoinColumn(name="Group_id")
    private List<UserGroup> groups;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }
}
