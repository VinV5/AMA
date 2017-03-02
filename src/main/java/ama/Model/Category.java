package ama.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum Category {
    Science("Science"),
    Personal("Personal"),
    Weird("Weird"),
    Education("Education"),
    Random("Random");

    private final String value;

    Category(String value) {
        this.value = value;
    }

}



