package com.compassUol.e_commerce.service;

import com.compassUol.e_commerce.dto.SaleDTO;
import com.compassUol.e_commerce.entities.Sale;
import com.compassUol.e_commerce.entities.User;
import com.compassUol.e_commerce.repositories.SaleRepository;
import com.compassUol.e_commerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    SaleRepository saleRepository;

    public void saveSale(Long userId, Sale sale) {
        User user = userRepository.findById(userId).get();
        sale.setUser(user);
        user.addSale(sale);
        saleRepository.save(sale);
        userRepository.save(user);
    }

    public List<Sale> findAllSalesFromAUser(Long userId) {
        User user = userRepository.findById(userId).get();
        List<Sale> sales = user.getSales();
        return sales;
    }

    public Sale findASalesFromAUser(Long userId, Long Serviceid) {
        User user = userRepository.findById(userId).get();
        List<Sale> sales = user.getSales().stream().filter(p->p.getId() == Serviceid).toList();
        return sales.get(0);
    }
}
