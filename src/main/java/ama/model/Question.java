package ama.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
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
        this.answerList = new ArrayList<>();
    }

    public void addAnswer(Answer a){
        answerList.add(a);
    }
}
