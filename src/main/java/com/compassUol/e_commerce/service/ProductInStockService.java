package com.compassUol.e_commerce.service;

import com.compassUol.e_commerce.entities.Product;
import com.compassUol.e_commerce.entities.ProductInStock;
import com.compassUol.e_commerce.entities.Stock;
import com.compassUol.e_commerce.repositories.ProductInStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInStockService {
    @Autowired
    ProductInStockRepository productInStockRepository;
    @Autowired
    ProductService productService;
    @Autowired
    StockService stockService;

    public void saveProductInStock(Long stockId, Long productId, ProductInStock productInStock) {
        Product product = productService.findProduct(productId);
        Stock stock = stockService.findStockById(stockId);
        productInStock.setProduct(product);
        productInStock.setStock(stock);
        productInStockRepository.save(productInStock);
    }
    public List<ProductInStock> findAllProductsInStock(){
        return productInStockRepository.findAll();
    }
}
