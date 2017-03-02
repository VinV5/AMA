package ama.Model;

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

    @ManyToMany
    @JoinColumn(name="Group_id")
    private List<UserGroup> groups;

    public User() {
        this("NoName");
    }

    public User(String name) {
        this.name = name;
    }
}
