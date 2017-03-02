package ama.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class UserGroup {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToMany (mappedBy = "groups",  cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<User> members;

    public UserGroup() {
        members = new ArrayList<>();
    }

    public void addUser(User user) {
        members.add(user);
    }

}
