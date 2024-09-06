package com.compassUol.e_commerce.dto;

import com.compassUol.e_commerce.entities.Product;
import com.compassUol.e_commerce.entities.ProductInStock;
import com.compassUol.e_commerce.entities.Stock;

public class ProductInStockDTO {
    private Integer quantityAvailable;

    public ProductInStockDTO(ProductInStock productInStock) {
        this.quantityAvailable = productInStock.getQuantityAvailable();
    }

    public ProductInStockDTO() {
    }

    public Integer getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(Integer quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }
}
