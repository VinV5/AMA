package ama.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by robertfernandes on 2/28/2017.
 */
@Entity
@Data
public class Question extends Rankable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String content;

    public Question() {
        this("");
    }

    public Question(String content) {
        this.content = content;
    }
}
