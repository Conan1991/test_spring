package com.example.test_spring.test;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Notes {

    List<String> notes = new ArrayList<>();

    public Notes() {
        notes.add("note1");
        notes.add("note2");
        notes.add("note5");
        notes.add("note3");
        notes.add("note4");
    }

    public List<String> getNotes() {
        return notes;
    }
}
