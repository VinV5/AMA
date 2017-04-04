package ama.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "question")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Answer> answerList;

    @ManyToOne
    @JoinColumn(name = "ama_id")
    private AMA ama;

    private String content;

    public Question() {
        this("");
    }

    public Question(String content) {
        this(content, null);

    }

    public Question(String content, AMA ama) {
        this.content = content;
        this.ama = ama;
        answerList = new ArrayList<>();
    }

    public void addAnswer(Answer answer) {
        answerList.add(answer);
    }
}
