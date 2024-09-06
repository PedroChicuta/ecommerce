package com.compassUol.e_commerce.controllers;

import com.compassUol.e_commerce.dto.ProductInStockDTO;
import com.compassUol.e_commerce.entities.ProductInStock;
import com.compassUol.e_commerce.service.ProductInStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/stocks/")
public class ProductInStockController {
    @Autowired
    ProductInStockService service;

    @PostMapping("{stockId}/products/{productId}")
    public ResponseEntity saveProduct(@PathVariable Long stockId
            , @PathVariable Long productId
            , @RequestBody ProductInStock productInStock){

        service.saveProductInStock(stockId, productId, productInStock);
        return new ResponseEntity<>(new ProductInStockDTO(productInStock), HttpStatus.CREATED);
    }
}
