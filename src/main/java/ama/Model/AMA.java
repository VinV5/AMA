package ama.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
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
    private Group authors;

    @OneToMany
    private List<Question> questionList;
    private Category category;
    private int time;

    public AMA() {
        this("");
    }

    public AMA(String title) {
        this.description = title;
        questionList = new ArrayList<>();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return  "Description: " + this.description + "\n" +
                "Category: " + this.category + "\n" +
                "Time: " + this.time;
    }
}
