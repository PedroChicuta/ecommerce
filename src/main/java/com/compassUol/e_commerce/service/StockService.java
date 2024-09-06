package com.compassUol.e_commerce.service;

import com.compassUol.e_commerce.entities.Stock;
import com.compassUol.e_commerce.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    @Autowired
    StockRepository stockRepository;

    public List<Stock> findAllStocks() {
        return stockRepository.findAll();
    }

    public Stock findStockById(Long id) {
        return stockRepository.findById(id).get();
    }

    public void saveStock(Stock stock) {
        stockRepository.save(stock);
    }

    public Stock deleteStockById(Long id) {
        Stock stock = findStockById(id);
        stockRepository.delete(stock);
        return stock;
    }
}
