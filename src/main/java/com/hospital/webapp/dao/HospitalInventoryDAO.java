package com.hospital.webapp.dao;

import com.hospital.webapp.entities.HospitalInventory;

import java.util.List;
import java.util.Optional;

public interface HospitalInventoryDAO {
    List<HospitalInventory> findAll();

    Optional<HospitalInventory> findById(Long id);

    List<HospitalInventory> findByPieceId(Long id);

    void save(HospitalInventory hospitalInventory);

    // void update(Product product);

    void deleteById(Long id);
}
