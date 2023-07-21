package com.example.test_spring.test;

import java.util.Arrays;

public enum Sex {
    EMPTY, // «пусто»

    MALE, // мужчина

    FEMALE, // женщина

    ;

    public static Sex findByValue(String value) {
        return Arrays.stream(values())
                .filter(sex -> value.equalsIgnoreCase(sex.getValue()))
                .findAny()
                .orElse(EMPTY);
    }

    public String getValue() {
        return this.toString();
    }
}
