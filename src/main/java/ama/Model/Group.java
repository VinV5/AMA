package ama.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Group {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToMany
    private List<User> members;

    public Group() {
        members = new ArrayList<>();
    }

    public void addUser(User user) {
        members.add(user);
    }

}
