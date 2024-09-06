package com.compassUol.e_commerce.dto;

import com.compassUol.e_commerce.entities.Product;

public class ProductDTO {
    private String description;
    private Double price;

    public ProductDTO(){

    }
    public ProductDTO(Product product){
        this.description = product.getDescription();
        this.price = product.getPrice();
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
