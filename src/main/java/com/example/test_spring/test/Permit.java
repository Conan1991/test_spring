package com.example.test_spring.test;

public class Permit {
    private Integer reserveId;

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
