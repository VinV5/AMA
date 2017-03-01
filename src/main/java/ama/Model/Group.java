package ama.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nur-sh on 2017-03-01.
 */
public class Group {

    private List<User> members;

    public Group() {
        members = new ArrayList<>();
    }

    public void addUser(User user) {
        members.add(user);
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }
}
