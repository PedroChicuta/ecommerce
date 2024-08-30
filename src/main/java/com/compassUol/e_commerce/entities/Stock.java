package com.compassUol.e_commerce.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_STOCK")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String adress;
    private String phone;

    public Stock(){

    }

    public Stock(Long id, String adress, String phone) {
        this.id = id;
        this.adress = adress;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
