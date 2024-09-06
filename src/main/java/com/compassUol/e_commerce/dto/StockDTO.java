package com.compassUol.e_commerce.dto;

import com.compassUol.e_commerce.entities.Stock;

public class StockDTO {
    private String address;
    private String phone;

    public StockDTO(String address, String phone) {
        this.address = address;
        this.phone = phone;
    }
    public StockDTO(Stock stock) {
        address = stock.getAddress();
        phone = stock.getPhone();
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
