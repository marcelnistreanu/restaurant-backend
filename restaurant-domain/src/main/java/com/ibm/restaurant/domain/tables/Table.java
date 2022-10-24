package com.ibm.restaurant.domain.tables;

public class Table {

    private final Long id;
    private final String capacity;
    private String status;

    public Table(Long id, String capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
