package com.example.test_spring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

public record FlightTrainingRuleDto(@NotNull Integer id,
                                    @NotBlank(message = "поле «Наименование» не должно быть пустым") String name,
                                    @NotNull(message = "поле «Дата, с которой действует документ» не должно быть null") Instant fromDate,
                                    @NotNull(message = "поле «Дата по которую действует документ") Instant toDate
) implements  Serializable {
}