package ama.model;
import lombok.Data;
import javax.persistence.*;

/**
* Created by ahmadholpa on 3/16/2017.
*/
@Entity
@Data
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String content;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public Answer() {
        this("");
    }

    public Answer (String content) {
        this(content, null);
    }

    public Answer (String content, Question question) {
        this.content = content;
        this.question = question;
    }
}