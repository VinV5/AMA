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

    private static final List<String> values;
    private final String value;

    static {
        values = new ArrayList<>();
        for (Category someEnum : Category.values()) {
            values.add(someEnum.value);
        }
    }

    private Category(String value) {
        this.value = value;
    }

    public static List<String> getValues() {
        return Collections.unmodifiableList(values);
    }

}



