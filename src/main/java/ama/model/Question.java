package ama.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class Question extends Rankable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(cascade = {CascadeType.ALL})
    public List<Answer> answerList;

    private String content;
   // private Answer answer;

    public Question() {
        this("");
    }

    public Question(String content) {
        this.content = content;
    }

    public Long getId(){
        return this.id;
    }
    public void addAnswer(Answer a){
        this.answerList.add(a);
    }
    public Answer getAnswer(Long l){
        int y = l.intValue();
        return this.answerList.get(y);
    }
}
