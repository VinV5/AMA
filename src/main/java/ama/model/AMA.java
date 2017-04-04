package ama.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
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
        //this.author = author;
        this.description = description;
    }

    public void addQuestion(Question q) {
        this.questionList.add(q);
    }

    public void vote() {
        votes++;
    }
}
