package com.example.test_spring;

import com.example.test_spring.test.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class TestSpringApplicationTests {

    @Autowired
    private User user;

    @Test
    void contextLoads() {
        getAndPrint(1);
        getAndPrint(2);
        getAllNotes();
        getAllEmails();
        getAndPrint(1);
        getAndPrint(2);
        getAllNotes();
        getAndPrint(3);
        getAllEmails();
        getAllNotes();
        getAllEmails();
    }
    private void getAndPrint(Integer id) {
        log.info("user found: {}", user.getByEmail(id));
    }

    private void getAllEmails(){
        log.info("all emails found: {}", user.getAllEmails());
    }

    private void getAllNotes(){
        log.info("all emails found: {}", user.getAllNotes());
    }
}
