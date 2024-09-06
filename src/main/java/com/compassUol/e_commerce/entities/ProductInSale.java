package com.compassUol.e_commerce.entities;

import com.compassUol.e_commerce.entities.primaryKeys.ProductInSalePK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_products_in_sale")
public class ProductInSale {

    @EmbeddedId
    private ProductInSalePK id = new ProductInSalePK();

    private Integer quantity;

    public ProductInSale(Product product, Sale sale, Integer quantity) {
        id.setSale(sale);
        id.setProduct(product);
        this.quantity = quantity;
    }

    public ProductInSale() {
    }

    public ProductInSalePK getId() {return id;}

    public void setSale(Sale sale) {
        id.setSale(sale);
    }

    public void setProduct(Product product) {
        id.setProduct(product);
    }

    public Double getsubTotal() {
        return quantity * id.getProduct().getPrice();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInSale product = (ProductInSale) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
