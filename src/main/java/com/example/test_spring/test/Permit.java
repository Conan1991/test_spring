package com.example.test_spring.test;

import java.time.Instant;

public class Permit {
    private Integer reserveId;

    public Instant getBeginPlanTime() {
        return beginPlanTime;
    }

    public void setBeginPlanTime(Instant beginPlanTime) {
        this.beginPlanTime = beginPlanTime;
    }

    private Instant beginPlanTime;

    public Permit(Integer reserveId, Instant beginPlanTime) {
        this.reserveId = reserveId;
        this.beginPlanTime = beginPlanTime;
    }

    public Permit(Integer reserveId) {
        this.reserveId = reserveId;
    }

    public Integer getReserveId() {
        return reserveId;
    }

    public void setReserveId(Integer reserveId) {
        this.reserveId = reserveId;
    }
}
