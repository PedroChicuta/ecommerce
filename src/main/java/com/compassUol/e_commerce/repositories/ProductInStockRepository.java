package com.compassUol.e_commerce.repositories;

import com.compassUol.e_commerce.entities.ProductInStock;
import com.compassUol.e_commerce.entities.primaryKeys.ProductInStockPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInStockRepository extends JpaRepository<ProductInStock, ProductInStockPK> {
}
