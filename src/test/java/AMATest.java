package test;

import ama.model.Question;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Vincent on 2017-03-13.
 */
public class AMATest {

    @Test
    public void testAddQuestion(){
        Question q = new Question();
        List<Question> questionList = new ArrayList<>();
        questionList.add(q);
        assertTrue(questionList.contains(q));
    }

}