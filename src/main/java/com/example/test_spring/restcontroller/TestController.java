package com.example.test_spring.restcontroller;

import com.example.test_spring.dto.FlightTrainingRuleDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
@RequestMapping(value =  "/rules", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController {

    @PostMapping(path = "/")
    public ResponseEntity<Object> createTest(@NotNull @RequestBody @NotEmpty List<@Valid FlightTrainingRuleDto> dto) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
