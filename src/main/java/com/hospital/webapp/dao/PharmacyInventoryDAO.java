package com.hospital.webapp.dao;

import com.hospital.webapp.entities.Pharmacy;

import java.util.List;
import java.util.Optional;

public interface PharmacyInventoryDAO {

    List<Pharmacy> findAll();

    Optional<Pharmacy> findById(Long id);

    void save (Pharmacy pharmacy);

    // void update(Product product);

    void updateStockById(Long id, Integer stock);

    void deleteById(Long id);

}
