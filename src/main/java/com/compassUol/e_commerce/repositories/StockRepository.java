package com.compassUol.e_commerce.repositories;

import com.compassUol.e_commerce.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
