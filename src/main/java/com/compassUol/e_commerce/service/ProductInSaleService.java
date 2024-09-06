package com.compassUol.e_commerce.service;

import com.compassUol.e_commerce.entities.*;
import com.compassUol.e_commerce.entities.Enums.SaleStatus;
import com.compassUol.e_commerce.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ProductInSaleService {
    @Autowired
    ProductInSaleRepository productInSaleRepository;
    @Autowired
    SaleService saleService;
    @Autowired
    ProductService productService;
    @Autowired
    ProductInStockService productInStockService;

    private List<Stock> stocks;

    public void saveProduct(ProductInSale productInSale,Long userId, Long saleId, Long productId) {

        Sale sale = saleService.findASalesFromAUser(userId, saleId);
        Product product = productService.findProduct(productId);
        List<ProductInStock> productsInStock = productInStockService.findAllProductsInStock();
        List<ProductInStock> matches = new ArrayList<>();

        productInSale.setProduct(product);
        productInSale.setSale(sale);

        if(productInSale.getId().getSale().getStatus().equals(SaleStatus.DONE)){
            for(ProductInStock productInStock : productsInStock){
                if(productInStock.getId().getProduct().equals(product)){
                    matches.add(productInStock);
                }
            }
            if(matches.size() == 0){
                return;
            }

            ProductInStock pickedProductInStock;
            for(ProductInStock productInStock : matches){
                if(productInStock.getQuantityAvailable()>productsInStock.get(0).getQuantityAvailable()){
                    matches.set(0, productInStock);
                }
            }

            pickedProductInStock = matches.get(0);
            int quantity = pickedProductInStock.getQuantityAvailable();

            if(quantity < productInSale.getQuantity()){
                return;
            }

            pickedProductInStock.setQuantityAvailable(quantity - productInSale.getQuantity());

        }

        sale.addItem(productInSale);
        productInSaleRepository.save(productInSale);
        saleService.saveSale(userId, sale);

    }

    public List<ProductInSale> findAllProducts(Long userId, Long saleId) {
        Sale sale = saleService.findASalesFromAUser(userId, saleId);
        return sale.getItems().stream().toList();
    }


}
