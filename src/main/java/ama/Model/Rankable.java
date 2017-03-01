package ama.Model;

import lombok.Data;

import javax.persistence.Entity;

/**
 * Created by robertfernandes on 2/28/2017.
 */
@Data
public abstract class Rankable {

    protected int points;

    public Rankable() {
        points = 0;
    }

    public void upVote() {
        points += 1;
    }

    public void downVote() {
        points -= 1;
    }
}
