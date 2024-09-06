package com.compassUol.e_commerce.repositories;

import com.compassUol.e_commerce.entities.ProductInSale;
import com.compassUol.e_commerce.entities.primaryKeys.ProductInSalePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInSaleRepository extends JpaRepository<ProductInSale, ProductInSalePK> {
}
