package com.example.test_spring.test;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Emails {

    List<String> emails = new ArrayList<>();

    public Emails() {
        emails.add("ABC");
        emails.add("ABA");
        emails.add("ABF");
        emails.add("ABH");
        emails.add("ABG");
    }

    public List<String> getEmails() {
        return emails;
    }
}
