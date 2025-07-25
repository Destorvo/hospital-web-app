package com.hospital.webapp.dao;


import com.hospital.webapp.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDAO {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    void save(Product product);

    // void update(Product product);

    void deleteById(Long id);

}
