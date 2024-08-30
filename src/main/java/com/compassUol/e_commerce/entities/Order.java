package com.compassUol.e_commerce.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "TB_ORDER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant lastUpdate;
    private String status;
    public Order(){

    }
    public Order(Long id, Instant lastUpdate, String status) {
        this.id = id;
        this.lastUpdate = lastUpdate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

