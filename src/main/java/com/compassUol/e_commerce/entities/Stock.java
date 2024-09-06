package com.compassUol.e_commerce.entities;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "TB_STOCK")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String phone;

    @OneToMany(mappedBy = "id.stock")
    private Set<ProductInStock> productsInStock;

    public Stock(){

    }

    public Stock(Long id, String address, String phone) {
        this.id = id;
        this.address = address;
        this.phone = phone;
    }

    public Set<ProductInStock> getProductsInStock() {
        return productsInStock;
    }

    public void addProductInStock(ProductInStock productInStock) {
        getProductsInStock().add(productInStock);
    }
    public void removeProductInStock(ProductInStock productInStock) {
        getProductsInStock().remove(productInStock);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return Objects.equals(id, stock.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
