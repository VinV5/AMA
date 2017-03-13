package test;

import ama.model.User;
import ama.model.UserGroup;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Created by Vincent on 2017-03-13.
 */
public class UserGroupTest {

    @Test
    public void testAddUser(){
        User u = new User();
        UserGroup ug = new UserGroup();
        ug.addUser(u);
        assertTrue(ug.getMembers().size() > 0);
    }
}
