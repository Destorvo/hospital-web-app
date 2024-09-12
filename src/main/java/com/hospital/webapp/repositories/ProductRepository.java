package com.hospital.webapp.repositories;

import com.hospital.webapp.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findProductByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
}
