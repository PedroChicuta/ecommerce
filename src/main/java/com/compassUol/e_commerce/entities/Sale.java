package com.compassUol.e_commerce.entities;

import com.compassUol.e_commerce.entities.Enums.SaleStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Entity
    @Table(name = "TB_SALE")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss z");
    private Instant lastUpdate;
    private SaleStatus status;

    @ManyToOne
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "id.sale")
    private Set<ProductInSale> items = new HashSet<>();

    public Sale(){

    }

    public Sale(String lastUpdate, SaleStatus status) {
        this.status = status;
        setLastUpdate(lastUpdate);
    }

    public Double getTotal() {
        List<Double> valuesOfItems = new ArrayList<>();
        items.stream().forEach(i -> valuesOfItems.add(i.getsubTotal()));
        if(valuesOfItems.size() != 0){
            return valuesOfItems.stream().reduce(Double::sum).get();
        }
        return 0.0;
    }

    public Set<ProductInSale> getItems() {
        return items;
    }

    public void addItem(ProductInSale productinSale){
        items.add(productinSale);
    }
    public void removeItem(ProductInSale productinSale){
        items.remove(productinSale);
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

    public void setLastUpdate(String lastUpdate) {
        ZonedDateTime ZonedformatedUpdate = ZonedDateTime.parse(lastUpdate, dtf);
        Instant formatedUpdate = ZonedformatedUpdate.toInstant();
        this.lastUpdate = formatedUpdate;
    }

    public SaleStatus getStatus() {return status;}

    public void setStatus(SaleStatus status) {this.status = status;}

    public User getUser() {return user;}

    public void setUser(User user) {this.user = user;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return Objects.equals(id, sale.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

