package com.compassUol.e_commerce.controllers;

import com.compassUol.e_commerce.entities.ProductInSale;
import com.compassUol.e_commerce.service.ProductInSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users/")
public class ProductInSaleController {
    @Autowired
    ProductInSaleService productInSaleService;

    @PostMapping("{userId}/sales/{saleId}/product/{productId}")
    public ResponseEntity saveProduct(@PathVariable Long userId,
                            @PathVariable Long saleId,
                            @PathVariable Long productId,
                            @RequestBody ProductInSale productInSale){
        productInSaleService.saveProduct(productInSale, userId, saleId, productId);
        return new ResponseEntity<>(productInSale, HttpStatus.CREATED);
    }
    @GetMapping("{userId}/sales/{saleId}/product")
    public List<ProductInSale> findAllProducts(@PathVariable Long userId, @PathVariable Long saleId){
        return productInSaleService.findAllProducts(userId, saleId);
    }

}
