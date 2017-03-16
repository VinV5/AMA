import ama.AMAApplication;
import ama.model.Question;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;



import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by Vincent on 2017-03-13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AMAApplication.class)
@AutoConfigureMockMvc
public class AMATest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAddQuestion() {
        Question q = new Question();
        List<Question> questionList = new ArrayList<>();
        questionList.add(q);
        assertThat(questionList).contains(q);
    }

    @Test
    public void deleteAMA() throws Exception {
        mockMvc.perform(get("/ama/1/delete")).andReturn();
        mockMvc.perform(get("ama/1")).andExpect(status().isNotFound()).andReturn();
    }


}