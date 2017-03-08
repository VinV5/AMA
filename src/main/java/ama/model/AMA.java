package ama.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class AMA extends Rankable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String question;
    private String description;
//    @ManyToOne
//    private User author;
//    @ManyToOne
//    private UserGroup authors;

    @OneToMany
    private List<Question> questionList;
    private Category category;
    private int time;

    public enum urMOm {
        nur, rob, amh, vevo
    }

    public AMA() {

    }

    public AMA(String description) {
        //this.author = author;
        this.description = description;
    }
    public String getQuestion()
    {
        return this.question;
    }
}
