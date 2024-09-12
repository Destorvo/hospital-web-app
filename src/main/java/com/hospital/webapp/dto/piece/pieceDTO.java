package com.hospital.webapp.dto.piece;

public record pieceDTO(
        Long id,
        String name,
        String description,
        String state
) {
}