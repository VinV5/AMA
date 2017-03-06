package ama.model;

import lombok.Data;

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
