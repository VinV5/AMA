package ama.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
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

    private String title;

    @OneToMany
    private List<User> presenters;

    @OneToMany
    private List<Question> questionList;

    private Category category;
    private int time;

    public AMA() {
        this("");
    }

    public AMA(String title) {
        this.title = title;
        presenters = new ArrayList<>();
        questionList = new ArrayList<>();
    }

    public void addPresenter(User user) {
        presenters.add(user);
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void addQuestion(Question question) {
        questionList.add(question);
    }

}
