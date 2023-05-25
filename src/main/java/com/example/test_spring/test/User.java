package com.example.test_spring.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Slf4j
@CacheConfig(cacheNames={"users"})
public class User {

    @Autowired
    Emails emails;

    @Autowired
    Notes notes;

    @Cacheable(key = "#root.method.name")
    public List<String> getAllEmails() {
        List<String> all = emails.getEmails();
        log.info("getting all emails: " + all);

        return all;
    }


    @Cacheable(key = "#root.method.name")
    public List<String> getAllNotes() {
        List<String> all = notes.getNotes();
        log.info("getting all notes: " + all);

        return all;
    }

    //@Cacheable
    public String getByEmail(int id){
        log.info("getting user by id: {}", id);
        return emails.getEmails().get(id);
    }



}
