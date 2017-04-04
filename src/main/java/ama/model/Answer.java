package ama.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import javax.persistence.*;

/**
* Created by ahmadholpa on 3/16/2017.
*/
@Entity
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String content;
    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonManagedReference
    private Question question;

    private int votes = 0;

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