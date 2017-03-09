package ama.controllers;

import ama.model.AMA;
import ama.model.Category;
import ama.model.Question;
import ama.repositories.AMARepository;
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
    public String createAMA(@ModelAttribute(name = "ama") AMA ama) {
        amaRepository.save(ama);
        return "AMASoloPage";
    }


    @PostMapping("/qcreate")
    public String createQuestion(@ModelAttribute(name = "ama") AMA ama) {

        if(amaRepository.exists(ama.getId()+1))
        {
            AMA amaR = amaRepository.findById(ama.getId()+1);
            // update the current AMA in repo
            amaR.addQuestion(new Question(ama.getQuestion()));
            amaRepository.save(amaR);
        }
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
        return "AMASoloPage";
    }
}
