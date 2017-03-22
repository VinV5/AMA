package ama.controllers;

import ama.model.AMA;
import ama.model.Answer;
import ama.model.Category;
import ama.model.Question;
import ama.repositories.AMARepository;
import ama.repositories.AnswerRepository;
import ama.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class AMAController {
    @Autowired
    private AMARepository amaRepository;
    @Autowired
    private QuestionRepository questionRepository;
    private Long id;
    @Autowired
    private AnswerRepository answerRepository;

    @GetMapping("/")
    public String getHomePage() {
        return "AMAHomePage";
    }

    @GetMapping("/create")
    public String getCreationPage(Model m) {
        m.addAttribute("questionCategories", Arrays.asList(Category.values()));
        m.addAttribute("ama", new AMA());

        return "AMACreationPage";
    }

    @PostMapping("/create")
    public String createAMA(@ModelAttribute(name = "ama") AMA ama, Model m) {
        amaRepository.save(ama);
        m.addAttribute("question", new Question());
        m.addAttribute("answer", new Answer());
        return "AMASoloPage";
    }

    @GetMapping("/ama/list")
    public @ResponseBody List<AMA> getAMAList() {
        List<AMA> amaList = new ArrayList<>();
        amaRepository.findAll().forEach(ama -> amaList.add(ama));
        return amaList;
    }


    @GetMapping("/question/list")
    public @ResponseBody List<Question> getQuestionList() {
        List<Question> questionList = new ArrayList<>();
        questionRepository.findAll().forEach(q -> questionList.add(q));
        return questionList;
    }

    @GetMapping("/ama/{id}")
    public String getAMA(Model m, @PathVariable long id){
        AMA ama = amaRepository.findById(id);
        m.addAttribute("ama", ama);
        m.addAttribute("question", new Question());
        m.addAttribute("answer", new Answer());
        return "AMASoloPage";
    }
    @GetMapping("/ama/{id}/question/{id2}")
    public String getQuestion(Model m, @PathVariable long id,@PathVariable long id2){
        AMA ama = amaRepository.findById(id);
        Question question = ama.getQuestion(id2-1);
        m.addAttribute("ama", ama);
        m.addAttribute("question", question);
        m.addAttribute("answer", new Answer());
        return "QuestionSoloPage";
    }

    @PostMapping("/ama/{id}/addquestion")
    public String addAMAQuestion(@ModelAttribute(name = "question") Question temp, Model m, @PathVariable Long id) {
        m.addAttribute("question", new Question() );
        AMA ama = amaRepository.findById(id);
        ama.addQuestion(new Question(temp.getContent()));
        m.addAttribute("ama", ama);
        m.addAttribute("answer", new Answer());
        amaRepository.save(ama);
        return "AMASoloPage";
    }

    @PostMapping("/ama/{id}/addanswer")
    public String addQuestionAnswer(@ModelAttribute(name = "answer") Answer temp, Model m, @PathVariable Long id) {
        Answer answer = temp;
        AMA ama = amaRepository.findById(id);
        Question question = ama.getQuestion(id-1);
        question.addAnswer(answer);
        ama.addQuestion(question);
        m.addAttribute("ama", ama);
        m.addAttribute("question",question);
        m.addAttribute("answer",answer);
        amaRepository.save(ama);
        return "QuestionSoloPage";
    }

    @GetMapping("/ama/{id}/questions")
    public @ResponseBody List<Question> getAMAQuestions(@PathVariable Long id) {
        AMA ama = amaRepository.findById(id);
        return ama.getQuestionList();
    }
    @GetMapping("/ama/{id}/answer")
    public @ResponseBody List<Answer> getQuestionAnswer(@PathVariable Long id) {
        AMA ama = amaRepository.findById(id);
        return ama.getQuestion(id).getAnswerList();
    }

}
