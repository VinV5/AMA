package ama.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class AMA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;
    private String description;

    @ManyToOne
    private User author;

    @ManyToOne
    private UserGroup authors;

    private int votes;

    @OneToMany(cascade = {CascadeType.ALL})

    public List<Question> questionList;

    private Category category;

    private int time;

    public AMA() {

    }

    public AMA(String description) {
        this.description = description;
    }
    public Question getQuestion(Long l)
    {
        int y = l.intValue();
        return this.questionList.get(y);
    }
    public Long getId()
    {
        return this.id;
    }

    public void addQuestion(Question q) {

        this.questionList.add(q);
    }

    public void vote() {
        votes++;
    }
}
