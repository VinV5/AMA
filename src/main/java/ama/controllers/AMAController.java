package ama.controllers;

import ama.model.*;
import ama.repositories.AMARepository;
import ama.repositories.AnswerRepository;
import ama.repositories.QuestionRepository;
import ama.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.*;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("user")
public class AMAController {
    @Autowired
    private AMARepository amaRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private UserRepository userRepository;
    private Map<Long, Set<User>> amaUpvoters = new HashMap<>();

    private Long id;
    @Autowired
    private AnswerRepository answerRepository;

    private User currentUser;

    @GetMapping("/")
    public String getHomePage(HttpSession session) {
        session.setAttribute("currentUser", currentUser);
        return "AMAHomePage";
    }

    @GetMapping("/create")
    public String getCreationPage(Model m) {
        m.addAttribute("questionCategories", Arrays.asList(Category.values()));
        m.addAttribute("ama", new AMA());

        return "AMACreationPage";
    }

    @GetMapping("/login")
    public String getLoginPage(Model m) {
        /*if (currentUser != null)
            return "AMAHomePage";*/
        m.addAttribute("user", new User());
        return "AMALoginPage";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") User user, HttpSession session) {
        if (userRepository.findByName(user.getName()) != null)
            currentUser = user;
        else
            currentUser = null;
        session.setAttribute("currentUser", currentUser);
        return "AMAHomePage";
    }

    @RequestMapping("/logout")
    public String logoutUser(HttpSession session, Model model) {
        currentUser = null;
        session.setAttribute("currentUser", currentUser);
        session.invalidate();
        if(model.containsAttribute("user")) model.asMap().remove("user");
        return "AMAHomePage";
    }

    @GetMapping("/signup")
    public String getSignUpPage(Model m) {
        m.addAttribute("user", new User());
        return "AMASignUpPage";
    }

    @PostMapping("/signup")
    public String signUpUser(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "AMAHomePage";
    }

    @GetMapping("/users/list")
    public @ResponseBody List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(q -> userList.add(q));
        return userList;
    }

    @PostMapping("/create")
    public String createAMA(@ModelAttribute(name = "ama") AMA ama, Model m) {
        amaRepository.save(ama);
        m.addAttribute("question", new Question());
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

    @PostMapping("/ama/{id}")
    public String addAMAQuestion(@ModelAttribute(name = "question") Question temp, Model m, @PathVariable Long id) {
        AMA ama = amaRepository.findById(id);
        Question question = new Question(temp.getContent(), ama);
        ama.addQuestion(question);
        m.addAttribute("question", question);
        m.addAttribute("ama", ama);
        m.addAttribute("answer", new Answer());
        amaRepository.save(ama);
        return "AMASoloPage";
    }

    @GetMapping("/ama/{id}/question/{qID}")
    public String getQuestion(Model m, @PathVariable long id,@PathVariable long qID){
        AMA ama = amaRepository.findById(id);
        Question question = questionRepository.findById(qID);
        m.addAttribute("ama", ama);
        m.addAttribute("question", question);
        m.addAttribute("answer", new Answer());
        return "QuestionSoloPage";
    }

    @PostMapping("/ama/{id}/question/{qID}")
    public String addQuestionAnswer(@ModelAttribute(name = "answer") Answer temp, Model m, @PathVariable Long id,@PathVariable Long qID) {
        Answer answer = new Answer(temp.getContent());
        AMA ama = amaRepository.findById(id);
        Question question = questionRepository.findById(qID);
        question.addAnswer(answer);
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

    @GetMapping("/ama/{id}/question/{qID}/answers")
    public @ResponseBody List<Answer> getQuestionAnswer(@PathVariable Long id,@PathVariable Long qID) {
        AMA ama = amaRepository.findById(id);
        Question qL = questionRepository.findById(qID);
        return qL.getAnswerList();
    }

    @RequestMapping("/ama/{id}/delete")
    public String deleteAMA(@PathVariable Long id) {
        amaRepository.delete(id);

        return "AMAHomePage";
    }

    @RequestMapping("/ama/{id}/vote")
    public @ResponseBody int upVoteAMA( @PathVariable Long id, @ModelAttribute("user") User user) {
        AMA ama = amaRepository.findById(id);
        if(amaUpvoters.containsKey(id)) {
            Set<User> upvoters = amaUpvoters.get(id);
            if(!upvoters.contains(user)) {
                upvoters.add(user);
                ama.vote();
                amaRepository.save(ama);
            }
        } else {
            amaUpvoters.put(id, new HashSet<>());
            amaUpvoters.get(id).add(user);
            ama.vote();
            amaRepository.save(ama);
        }
        return ama.getVotes();
    }

    @PostMapping("/ama/{id}/addvote")
    public String addAMAVote(@PathVariable Long id, Model m, @ModelAttribute("user") User user) {
        upVoteAMA(id, user);
        AMA ama = amaRepository.findById(id);
        m.addAttribute("question", new Question() );
        m.addAttribute("ama", ama);
        return "AMASoloPage";
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
