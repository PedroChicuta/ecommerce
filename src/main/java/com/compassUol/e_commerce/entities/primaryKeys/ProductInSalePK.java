package com.compassUol.e_commerce.entities.primaryKeys;

import com.compassUol.e_commerce.entities.Product;
import com.compassUol.e_commerce.entities.Sale;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductInSalePK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "Product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "Sale_id")
    @JsonIgnore
    private Sale sale;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInSalePK that = (ProductInSalePK) o;
        return Objects.equals(product, that.product) && Objects.equals(sale, that.sale);
    }
    @Override
    public int hashCode() {
        return Objects.hash(product, sale);
    }
}
