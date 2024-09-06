package com.compassUol.e_commerce.controllers;

import com.compassUol.e_commerce.dto.StockDTO;
import com.compassUol.e_commerce.entities.Stock;
import com.compassUol.e_commerce.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/stocks")
public class StockController {
    @Autowired
    StockService stockService;

    @GetMapping
    public List<Stock> findAllStocks(){
        return stockService.findAllStocks();
    }
    @GetMapping("/{id}")
    public Stock findStockById(@PathVariable Long id){
        return stockService.findStockById(id);
    }
    @PostMapping
    public ResponseEntity createStock(@RequestBody Stock stock){
        stockService.saveStock(stock);
        return new ResponseEntity<>(new StockDTO(stock), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteStock(@PathVariable Long id){
        Stock deletedStock = stockService.deleteStockById(id);
        return new ResponseEntity(new StockDTO(deletedStock), HttpStatus.OK);
    }
}
