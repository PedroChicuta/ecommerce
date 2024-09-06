package com.compassUol.e_commerce.controllers;

import com.compassUol.e_commerce.dto.ProductDTO;
import com.compassUol.e_commerce.entities.Product;
import com.compassUol.e_commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping
    public ResponseEntity createProduct(@RequestBody Product product){
        productService.saveProduct(product);
        return new ResponseEntity<>(new ProductDTO(product), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Product> findAllProducts(){
        return productService.findAllProducts();
    }
    @GetMapping("/{id}")
    public Product findProduct(@PathVariable Long id){
        return productService.findProduct(id);
    }
}
