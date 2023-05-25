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
        getAndPrint(1);
        getAndPrint(2);
        getAndPrint(3);

        getAll();
        getAll();
    }
    private void getAndPrint(Integer id) {
        log.info("user found: {}", user.getByEmail(id));
    }

    private void getAll(){
        log.info("all found: {}", user.getAllEmails());
    }
}
