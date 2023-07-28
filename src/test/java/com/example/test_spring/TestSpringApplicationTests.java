package com.example.test_spring;

import com.example.test_spring.test.Permit;
import com.example.test_spring.test.Sex;
import com.example.test_spring.test.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


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
        Instant now = Instant.now();
        List<Permit> list = List.of(new Permit(0, now),
                new Permit(3, now.plus(5, ChronoUnit.HOURS)),
                new Permit(1, now.minus(5, ChronoUnit.HOURS)),
                new Permit(2, now.plus(6, ChronoUnit.HOURS)));
        //Stream<Permit> stream = Stream.of(new Permit(2, Instant.now()));


        Permit lastElement = list
                .stream()
                .max(Comparator.comparing(Permit::getBeginPlanTime))
                .orElse(null);

        List<Permit> sorted = list.stream().sorted(Comparator.comparing(Permit::getBeginPlanTime)).toList();

        Permit permit = sorted.stream().findFirst().orElse(null);

        sorted.forEach(p -> log.info("test all: {}, time: {}", p.getReserveId(), p.getBeginPlanTime()));
        log.info("test last: {}, time: {}", lastElement.getReserveId(), lastElement.getBeginPlanTime());
        log.info("test first: {}, time: {}", permit.getReserveId(), permit.getBeginPlanTime());
    }

    @Test
    void contextLoads6() {
        Instant now = LocalDateTime.of(2023, 7, 26, 13, 10 , 49).toInstant(ZoneOffset.UTC);
        Instant plus = LocalDateTime.of(2023, 7, 26, 18, 11 , 50).toInstant(ZoneOffset.UTC);
        BigDecimal bigDecimal = BigDecimal.valueOf(0.3465d);
        log.info("test now: {}", now);
        log.info("test plus: {}", plus);
        int intValue = BigDecimal.valueOf(Duration.between(now, plus).toMinutes()).multiply(bigDecimal).intValue();
        double d = Duration.between(now, plus).toMinutes() * bigDecimal.doubleValue();
        log.info("test double: {}", d);
        //log.info("test floor: {}", Math.floor(d));
        log.info("test int: {}", intValue);
    }
}
