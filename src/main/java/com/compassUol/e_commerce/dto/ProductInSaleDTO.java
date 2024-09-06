package com.compassUol.e_commerce.dto;

import com.compassUol.e_commerce.entities.ProductInSale;


public class ProductInSaleDTO {
    private Integer quantity;


    public ProductInSaleDTO(ProductInSale product){
        this.quantity = product.getQuantity();
    }
    public ProductInSaleDTO(){

    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
