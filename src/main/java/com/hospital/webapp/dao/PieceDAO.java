package com.hospital.webapp.dao;

import com.hospital.webapp.entities.Piece;

import java.util.List;
import java.util.Optional;

public interface PieceDAO {

    List<Piece> findAll();

    Optional<Piece> findById(Long id);

    void save(Piece piece);

    // void update(Product product);

    void deleteById(Long id);
}
