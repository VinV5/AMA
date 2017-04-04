import ama.AMAApplication;
import ama.model.AMA;
import ama.model.Question;
import ama.repositories.AMARepository;
import ama.repositories.QuestionRepository;
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

    @Autowired
    AMARepository amaRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Test
    public void testAddQuestion() {
        Question q = new Question();
        List<Question> questionList = new ArrayList<>();
        questionList.add(q);
        assertThat(questionList).contains(q);
    }

    @Test
    public void testVote() {
        AMA ama = new AMA();
        int votes = ama.getVotes();
        ama.vote();
        assertThat(ama.getVotes()).isEqualTo(votes + 1);
    }

    @Test
    public void deleteAMA() throws Exception {
        AMA ama = new AMA();
        amaRepository.save(ama);
        mockMvc.perform(get("/ama/" + ama.getId() + "/delete")).andReturn();
        mockMvc.perform(get("ama/" + ama.getId())).andExpect(status().isNotFound()).andReturn();
    }

    @Test
    public void answerAMA()throws Exception{
        assertThat(amaRepository.findById(1l).getQuestionList().get(0).getAnswerList().get(0).getContent()).contains("bye");
    }

}