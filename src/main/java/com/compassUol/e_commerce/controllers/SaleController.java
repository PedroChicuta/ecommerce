package com.compassUol.e_commerce.controllers;

import com.compassUol.e_commerce.dto.SaleDTO;
import com.compassUol.e_commerce.entities.Sale;
import com.compassUol.e_commerce.entities.User;
import com.compassUol.e_commerce.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users/")
public class SaleController {
    @Autowired
    SaleService saleService;

    @PostMapping("{userId}/sales")
    public ResponseEntity<SaleDTO> saveUser(@PathVariable Long userId,@RequestBody Sale sale){
        saleService.saveSale(userId, sale);
        return new ResponseEntity<>(new SaleDTO(sale), HttpStatus.CREATED);
    }

    @GetMapping("{userId}/sales")
    public List<Sale> findAllSales(@PathVariable Long userId){
        return saleService.findAllSalesFromAUser(userId);
    }

    @GetMapping("{userId}/sales/{id}")
    public Sale findAllSales(@PathVariable Long userId, @PathVariable Long id){
        return saleService.findASalesFromAUser(userId, id);
    }
}
