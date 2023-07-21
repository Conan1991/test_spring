package com.example.test_spring;

import com.example.test_spring.test.Permit;
import com.example.test_spring.test.Sex;
import com.example.test_spring.test.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

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

    private void getAllEmails() {
        log.info("all emails found: {}", user.getAllEmails());
    }

    private void getAllNotes() {
        log.info("all emails found: {}", user.getAllNotes());
    }


    @Test
    void contextLoads1() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer rangeForCheck;
        int rangeToCheck = 0;
        while (rangeToCheck < integers.size() - 1) {
            rangeForCheck = integers.get(rangeToCheck);
            for (int i = rangeToCheck + 1; i < integers.size(); i++) {
                Integer currentRange = integers.get(i);
                log.info("check + {} range, current range is {}", rangeForCheck, currentRange);
            }
            rangeToCheck++;
            log.info("next check ----------{}", rangeToCheck);

        }
    }

    @Test
    void contextLoads2() {
        log.info("check + {}", Sex.findByValue("MALE"));
    }

    @Test
    void contextLoads3() {
        Integer parent_id = 5;
        log.info(Optional.ofNullable(parent_id)
                .filter(intq -> intq != 0)
                .isPresent() ? "not null" : "null");
    }

    @Test
    void contextLoads4() {
        Integer parent_id = null;
        testInt(parent_id);
    }

    void testInt(int test) {
        log.info("test int: {}", test);
    }

    @Test
    void contextLoads5() {
        //Stream<Permit> stream = Stream.of(new Permit(0), new Permit(0), new Permit(1), new Permit(2));
        Stream<Permit> stream = Stream.of(new Permit(2));

        Permit lastElement = stream.reduce((first, second) -> second)
                .orElse(null);

        log.info("test last: {}", lastElement.getReserveId());
    }
}
