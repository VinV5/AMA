package ama.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class AMA extends Rankable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String description;
    @ManyToOne
    private User author;
    @ManyToOne
    private UserGroup authors;

    @OneToMany
    private List<Question> questionList;
    private Category category;
    private int time;


    public AMA() {
    }

}
