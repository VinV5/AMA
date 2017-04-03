package ama.model;

import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
public class UserGroup {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany (mappedBy = "groups",  cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<User> members;

    public UserGroup() {
        members = new HashSet<>();
    }

    public void addUser(User user) {
        members.add(user);
    }



}
