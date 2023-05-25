package com.example.test_spring.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Cacheable("users")
@Component
@Slf4j
public class User {

    @Autowired
    Emails emails;
    public List<String> getAllEmails() {
        List<String> all = emails.getEmails();
        log.info("getting all emails: " + all);

        return all;
    }

    public String getByEmail(int id){
        log.info("getting user by id: {}", id);
        return emails.getEmails().get(id);
    }



}
