import ama.AMAApplication;
import ama.controllers.AMAController;
import ama.model.Question;
import ama.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by robertfernandes on 3/21/2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AMAApplication.class)
@AutoConfigureMockMvc

public class LoginTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AMAController amaController;

    private User user;

    private User user2;

    @Autowired
    private HttpSession httpSession;

    @Before
    public void setUp() {
        user = new User();
        user.setName("hello");
        user.setPassword("password");
        amaController.signUpUser(user);

        user2 = new User();
        user2.setName("user2");
        user.setPassword("password");
    }

    @Test
    public void testLoginLogout() {
        amaController.loginUser(user, httpSession);
        assertThat(httpSession.getAttribute("currentUser")).isEqualTo(user);
        assertThat(amaController.getCurrentUser()).isEqualTo(user);
        amaController.logoutUser(httpSession);
        assertThat(httpSession.getAttribute("currentUser")).isEqualTo(null);
        assertThat(amaController.getCurrentUser()).isEqualTo(null);
    }

    @Test
    public void testLoginValidation() {
        amaController.loginUser(user2, httpSession);
        assertThat(httpSession.getAttribute("currentUser")).isEqualTo(null);
        assertThat(amaController.getCurrentUser()).isEqualTo(null);
        amaController.signUpUser(user2);
        amaController.loginUser(user2, httpSession);
        assertThat(httpSession.getAttribute("currentUser")).isEqualTo(user2);
        assertThat(amaController.getCurrentUser()).isEqualTo(user2);
    }
}
