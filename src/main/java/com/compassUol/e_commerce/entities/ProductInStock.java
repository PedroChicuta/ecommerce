package com.compassUol.e_commerce.entities;

import com.compassUol.e_commerce.entities.primaryKeys.ProductInStockPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_products_in_stock")
public class ProductInStock {

    @EmbeddedId
    private ProductInStockPK id = new ProductInStockPK();

    private Integer quantityAvailable;

    public ProductInStock(ProductInStockPK id, Integer quantityAvailable) {
        this.id = id;
        this.quantityAvailable = quantityAvailable;
    }
    public ProductInStock(){

    }
    public ProductInStock(Stock stock,Product product, Integer quantityAvailable) {
        setStock(stock);
        setProduct(product);
        this.quantityAvailable = quantityAvailable;
    }

    public void setStock(Stock stock) {
        id.setStock(stock);
    }
    public void setProduct(Product product) {
        id.setProduct(product);
    }
    public ProductInStockPK getId() {
        return id;
    }
    public Integer getQuantityAvailable() {
        return quantityAvailable;
    }
    public void setQuantityAvailable(Integer quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInStock that = (ProductInStock) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
