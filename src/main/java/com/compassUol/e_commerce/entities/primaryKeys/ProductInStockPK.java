package com.compassUol.e_commerce.entities.primaryKeys;

import com.compassUol.e_commerce.entities.Product;
import com.compassUol.e_commerce.entities.Stock;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductInStockPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    @JsonIgnore
    private Stock stock;

    @ManyToOne
    @JoinColumn(name = "Product_id")
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInStockPK that = (ProductInStockPK) o;
        return Objects.equals(stock, that.stock) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stock, product);
    }
}
