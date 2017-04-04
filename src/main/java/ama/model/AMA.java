package ama.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.*;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ama")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Question> questionList;

    private Category category;

    private int time;

    public AMA() {
        this("");
    }

    public AMA(String description) {
        questionList = new ArrayList<>();
        this.description = description;
    }

    public void addQuestion(Question q) {
        questionList.add(q);
    }

    public void vote() {
        votes++;
    }
}
