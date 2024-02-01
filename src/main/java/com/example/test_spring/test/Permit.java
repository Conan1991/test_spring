package com.example.test_spring.test;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class Permit {
    private Integer reserveId;

    private Instant beginPlanTime;

    public Permit(Integer reserveId, Instant beginPlanTime) {
        this.reserveId = reserveId;
        this.beginPlanTime = beginPlanTime;
    }

    @Override
    public String toString() {
        return "Permit{" +
               "reserveId=" + reserveId +
               ", beginPlanTime=" + beginPlanTime +
               '}';
    }

    public Permit(Integer reserveId) {
        this.reserveId = reserveId;
    }
}
