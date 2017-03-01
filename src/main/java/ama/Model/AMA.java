package ama.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by robertfernandes on 2/28/2017.
 */
@Entity
@Data
public class AMA extends Rankable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String description;

    @OneToMany
    private List<User> presenters;

    @OneToMany
    private List<Question> questionList;

    public AMA() {
        this("");
    }

    public AMA(String description) {

    }

    public void addPresenter(User user) {
        presenters.add(user);
    }

    public void addQuestion(Question question) {
        questionList.add(question);
    }

}
